package br.ufpb.matheus.nail;

import java.io.IOException;

/**
 * Interface que representa o Tipo Abstrato de Dados para o gerenciamento de atendimentos de unhas.
 */
public interface NailInterface {

    /**
     * Cadastra um novo atendimento no sistema.
     * @param cliente Nome do cliente.
     * @param tipoServico Tipo do serviço.
     * @param horarioMarcado Horário do agendamento.
     * @param precoAtendimento Valor do serviço.
     * @param estabelecimento Local de atendimento.
     */
    void cadastrarNovoAtendimento(String cliente, String tipoServico, String horarioMarcado, double precoAtendimento, String estabelecimento);

    /**
     * Pesquisa se existe atendimento cadastrado para determinado cliente.
     * @param clientePraProcurar Nome do cliente a ser pesquisado.
     * @throws NaoAchouClienteException Caso o cliente não seja localizado.
     */
    void pesquisarAtendimentoPorLocal(String clientePraProcurar) throws NaoAchouClienteException;

    /**
     * Remove o atendimento do cliente a partir de seu nome.
     * @param nomeCliente Nome do cliente.
     * @throws NaoAchouClienteException Caso o cliente não esteja cadastrado.
     */
    void deletarAtendimentoPeloNomeDoCliente(String nomeCliente) throws NaoAchouClienteException;

    /**
     * Grava os dados do sistema em arquivo.
     * @throws IOException Em caso de falha na gravação dos dados.
     */
    void salvarDados() throws IOException;

    /**
     * Recupera os dados salvos em arquivo.
     * @throws IOException Em caso de erro na leitura do arquivo.
     */
    void recuperarDados() throws IOException;
}