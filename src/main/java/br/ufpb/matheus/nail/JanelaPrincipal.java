package br.ufpb.matheus.nail;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    private NailInterface sistema;

    private JTextField txtCliente = new JTextField(15);
    private JTextField txtServico = new JTextField(15);
    private JTextField txtHorario = new JTextField(10);
    private JTextField txtPreco = new JTextField(10);
    private JTextField txtLocal = new JTextField(15);

    public JanelaPrincipal() {
        this.sistema = new NailSistema();

        // Tentar carregar os dados ao abrir
        try {
            this.sistema.recuperarDados();
        } catch (Exception e) {
            System.out.println("Nenhum dado previo para recuperar.");
        }

        setTitle("Sistema de Agendamento - Nail System");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Barra de Menus
        JMenuBar menuBar = new JMenuBar();
        JMenu menuOperacoes = new JMenu("Operações");

        JMenuItem menuCadastrar = new JMenuItem("Cadastrar Atendimento");
        JMenuItem menuPesquisar = new JMenuItem("Pesquisar Cliente");
        JMenuItem menuApagar = new JMenuItem("Apagar Atendimento");
        JMenuItem menuSalvar = new JMenuItem("Salvar Dados");

        menuOperacoes.add(menuCadastrar);
        menuOperacoes.add(menuPesquisar);
        menuOperacoes.add(menuApagar);
        menuOperacoes.addSeparator();
        menuOperacoes.add(menuSalvar);
        menuBar.add(menuOperacoes);
        setJMenuBar(menuBar);

        // Painel do Formulário
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Nome do Cliente:"));
        panel.add(txtCliente);
        panel.add(new JLabel("Tipo de Serviço:"));
        panel.add(txtServico);
        panel.add(new JLabel("Horário:"));
        panel.add(txtHorario);
        panel.add(new JLabel("Preço (R$):"));
        panel.add(txtPreco);
        panel.add(new JLabel("Estabelecimento:"));
        panel.add(txtLocal);

        JButton btnCadastrar = new JButton("Cadastrar");
        panel.add(btnCadastrar);

        add(panel, BorderLayout.CENTER);

        // Vinculando Controller de Cadastro
        NailCadastroController cadastroController = new NailCadastroController(this.sistema, txtCliente, txtServico, txtHorario, txtPreco, txtLocal);
        btnCadastrar.addActionListener(cadastroController);
        menuCadastrar.addActionListener(cadastroController);

        // Ações simples para Pesquisar, Apagar e Salvar via Lambda nos Menus
        menuPesquisar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog(this, "Digite o nome do cliente a pesquisar:");
            if (nome != null && !nome.trim().isEmpty()) {
                try {
                    sistema.pesquisarAtendimentoPorLocal(nome.trim());
                    JOptionPane.showMessageDialog(this, "Cliente " + nome + " encontrado!");
                } catch (NaoAchouClienteException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Não Encontrado", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        menuApagar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog(this, "Digite o nome do cliente a apagar:");
            if (nome != null && !nome.trim().isEmpty()) {
                try {
                    sistema.deletarAtendimentoPeloNomeDoCliente(nome.trim());
                    JOptionPane.showMessageDialog(this, "Atendimento removido!");
                } catch (NaoAchouClienteException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro ao Apagar", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        menuSalvar.addActionListener(e -> {
            try {
                sistema.salvarDados();
                JOptionPane.showMessageDialog(this, "Dados salvos no arquivo com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}