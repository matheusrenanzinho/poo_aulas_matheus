package br.ufpb.matheus.nail;

public interface NailInterface {
    public void cadastrarNovoAtendimento(String nomeCliente, String tipoServico, String horarioMarcado, double precoAtendimento, String estabelecimento);
    public void pesquisarAtendimentoPorLocal(String clientePraProcurar) throws NaoAchouClienteException;
    public void deletarAtendimentoPeloNomeDoCliente(String nomeCliente) throws NaoAchouClienteException;
}