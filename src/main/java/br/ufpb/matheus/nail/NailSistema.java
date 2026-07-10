package br.ufpb.matheus.nail;

import java.util.HashMap;
import java.util.Map;

public class NailSistema implements NailInterface {
    private Map<String, NailBase> nailAtendimentos;

    public NailSistema() {
        this.nailAtendimentos = new HashMap<>();
    }

    public void cadastrarNovoAtendimento(String cliente, String tipoServico, String horarioMarcado, double precoAtendimento, String estabelecimento) {
        NailBase novoAtendimento = new NailBase(cliente, tipoServico, horarioMarcado, precoAtendimento, estabelecimento);

        this.nailAtendimentos.put(cliente, novoAtendimento);
        System.out.println("Novo Cliente foi cadastrado com sucesso! " + cliente + "(" + tipoServico + ")");
    }

    public void pesquisarAtendimentoPorLocal(String clientePraProcurar) throws NaoAchouClienteException {
        if (nailAtendimentos.isEmpty()) {
            throw new NaoAchouClienteException("O Cliente nao foi achado no Map " + clientePraProcurar);
        }

        boolean achouCliente = false;
        for (NailBase n : this.nailAtendimentos.values()) {
            if (n.getCliente().equals(clientePraProcurar)) {
                System.out.println("Foi achado o cliente: " + clientePraProcurar + " no Estabelecimento " + n.getEstabelecimento());
                achouCliente = true;
            }
        }

        if (!achouCliente) {
            throw new NaoAchouClienteException("O cliente nao foi achado!");
        }
    }
    public void deletarAtendimentoPeloNomeDoCliente(String nomeCliente) throws NaoAchouClienteException {
        if (nailAtendimentos.isEmpty()) {
            throw new NaoAchouClienteException("Nao foi achado o cliente com nome: " + nomeCliente);
        }

        if (!this.nailAtendimentos.containsKey(nomeCliente)) {
            throw new NaoAchouClienteException("Nao foi achado o cliente com a chave: " + nomeCliente);
        }

        this.nailAtendimentos.remove(nomeCliente);
        System.out.println("O cliente foi achado com sucesso e removido! Cliente: " + nomeCliente);
    }
}