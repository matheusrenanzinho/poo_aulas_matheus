package br.ufpb.matheus.amigosecreto;

public class AmigoInexistenteException extends Exception {
    public AmigoInexistenteException(String mensagem) {
        super(mensagem);
    }
}