package br.ufpb.matheus.nail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NailSistema implements NailInterface {
    private Map<String, NailBase> nailAtendimentos;
    private GravadorDeDados gravador;

    public NailSistema() {
        this.nailAtendimentos = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }

    @Override
    public void cadastrarNovoAtendimento(String cliente, String tipoServico, String horarioMarcado, double precoAtendimento, String estabelecimento) {
        NailBase novoAtendimento = new NailBase(cliente, tipoServico, horarioMarcado, precoAtendimento, estabelecimento);
        this.nailAtendimentos.put(cliente, novoAtendimento);
        System.out.println("Novo Cliente foi cadastrado com sucesso! " + cliente + " (" + tipoServico + ")");
    }

    @Override
    public void pesquisarAtendimentoPorLocal(String clientePraProcurar) throws NaoAchouClienteException {
        if (nailAtendimentos.isEmpty() || !this.nailAtendimentos.containsKey(clientePraProcurar)) {
            throw new NaoAchouClienteException("O Cliente nao foi achado: " + clientePraProcurar);
        }

        NailBase n = this.nailAtendimentos.get(clientePraProcurar);
        System.out.println("Foi achado o cliente: " + clientePraProcurar + " no Estabelecimento " + n.getEstabelecimento());
    }

    @Override
    public void deletarAtendimentoPeloNomeDoCliente(String nomeCliente) throws NaoAchouClienteException {
        if (nailAtendimentos.isEmpty() || !this.nailAtendimentos.containsKey(nomeCliente)) {
            throw new NaoAchouClienteException("Nao foi achado o cliente com o nome: " + nomeCliente);
        }

        this.nailAtendimentos.remove(nomeCliente);
        System.out.println("O cliente foi achado com sucesso e removido! Cliente: " + nomeCliente);
    }

    @Override
    public void salvarDados() throws IOException {
        this.gravador.salvarDados(this.nailAtendimentos);
    }

    @Override
    public void recuperarDados() throws IOException {
        try {
            this.nailAtendimentos = this.gravador.recuperarDados();
        } catch (ClassNotFoundException e) {
            throw new IOException("Erro de formato ao carregar os dados.", e);
        }
    }
}