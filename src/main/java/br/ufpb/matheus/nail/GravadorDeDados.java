package br.ufpb.matheus.nail;

import java.io.*;
import java.util.Map;

public class GravadorDeDados {
    private String nomeArquivo;

    public GravadorDeDados(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public GravadorDeDados() {
        this("atendimentos.dat");
    }

    public void salvarDados(Map<String, NailBase> atendimentos) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.nomeArquivo))) {
            oos.writeObject(atendimentos);
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, NailBase> recuperarDados() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.nomeArquivo))) {
            return (Map<String, NailBase>) ois.readObject();
        }
    }
}