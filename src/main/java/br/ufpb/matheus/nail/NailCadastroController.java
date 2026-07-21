package br.ufpb.matheus.nail;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NailCadastroController implements ActionListener {

    private NailInterface sistema;
    private JTextField txtCliente, txtServico, txtHorario, txtPreco, txtLocal;

    public NailCadastroController(NailInterface sistema, JTextField txtCliente, JTextField txtServico, JTextField txtHorario, JTextField txtPreco, JTextField txtLocal) {
        this.sistema = sistema;
        this.txtCliente = txtCliente;
        this.txtServico = txtServico;
        this.txtHorario = txtHorario;
        this.txtPreco = txtPreco;
        this.txtLocal = txtLocal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String cliente = txtCliente.getText().trim();
            String servico = txtServico.getText().trim();
            String horario = txtHorario.getText().trim();
            String local = txtLocal.getText().trim();

            if (cliente.isEmpty() || servico.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios (Cliente e Serviço)!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double preco = Double.parseDouble(txtPreco.getText());

            sistema.cadastrarNovoAtendimento(cliente, servico, horario, preco, local);
            JOptionPane.showMessageDialog(null, "Atendimento cadastrado com sucesso!");

            txtCliente.setText("");
            txtServico.setText("");
            txtHorario.setText("");
            txtPreco.setText("");
            txtLocal.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "O preço deve conter um valor numérico válido!", "Erro no Preço", JOptionPane.ERROR_MESSAGE);
        }
    }
}