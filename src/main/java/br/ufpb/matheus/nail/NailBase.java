package br.ufpb.matheus.nail;

import java.util.Objects;

public class NailBase {
    private String cliente;
    private String servico;
    private String horario;
    private double precoAtendimento;
    private String estabelecimentoLocal;

    public NailBase(String nomeCliente, String tipoServico, String horarioMarcado, double precoAtendimento, String estabelecimento) {
        this.cliente = nomeCliente;
        this.servico = tipoServico;
        this.horario = horarioMarcado;
        this.precoAtendimento = precoAtendimento;
        this.estabelecimentoLocal = estabelecimento;
    }

    // Iniciar Sem Nada
    public NailBase() {this("", "", "", 0.0, "Nenhum Estabelecimento!");}

    // Parte do Cliente
    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String novoCliente) {
        this.cliente = novoCliente;
    }

    // Parte do Serviço
    public String getServico() {
        return this.servico;
    }

    public void setServico(String novoServico) {
        this.servico = novoServico;
    }

    // Parte do Horario
    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String novoHorario) {
        this.horario = novoHorario;
    }

    // Parte do Preço
    public double getPreco() {
        return this.precoAtendimento;
    }

    public void setPreco(double novoPreco) {
        this.precoAtendimento = novoPreco;
    }

    // Parte do Estabelecimento
    public String getEstabelecimento() {
        return this.estabelecimentoLocal;
    }

    public void setEstabelecimento(String novoEstabelecimento) {
        this.estabelecimentoLocal = novoEstabelecimento;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + " selecionou o atendimento: " + servico + " (R$ " + precoAtendimento + "), marcado para o Horario: " + horario + " horas!";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NailBase that = (NailBase) o;
        return Double.compare(precoAtendimento, that.precoAtendimento) == 0 && Objects.equals(cliente, that.cliente) && Objects.equals(servico, that.servico) && Objects.equals(horario, that.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, servico, horario, precoAtendimento);
    }
}