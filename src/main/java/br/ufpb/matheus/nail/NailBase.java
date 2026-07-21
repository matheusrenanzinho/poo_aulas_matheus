package br.ufpb.matheus.nail;

import java.io.Serializable;
import java.util.Objects;

public class NailBase implements Serializable {
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

    public NailBase() {
        this("", "", "", 0.0, "Nenhum Estabelecimento!");
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String novoCliente) {
        this.cliente = novoCliente;
    }

    public String getServico() {
        return this.servico;
    }

    public void setServico(String novoServico) {
        this.servico = novoServico;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String novoHorario) {
        this.horario = novoHorario;
    }

    public double getPreco() {
        return this.precoAtendimento;
    }

    public void setPreco(double novoPreco) {
        this.precoAtendimento = novoPreco;
    }

    public String getEstabelecimento() {
        return this.estabelecimentoLocal;
    }

    public void setEstabelecimento(String novoEstabelecimento) {
        this.estabelecimentoLocal = novoEstabelecimento;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente + " | Serviço: " + servico + " (R$ " + precoAtendimento + ") | Horário: " + horario + "h | Local: " + estabelecimentoLocal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NailBase nailBase = (NailBase) o;
        return Double.compare(nailBase.precoAtendimento, precoAtendimento) == 0 &&
                Objects.equals(cliente, nailBase.cliente) &&
                Objects.equals(servico, nailBase.servico) &&
                Objects.equals(horario, nailBase.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, servico, horario, precoAtendimento);
    }
}