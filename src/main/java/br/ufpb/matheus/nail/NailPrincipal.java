package br.ufpb.matheus.nail;

import javax.swing.SwingUtilities;

public class NailPrincipal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JanelaPrincipal janela = new JanelaPrincipal();
            janela.setVisible(true);
        });
    }
}