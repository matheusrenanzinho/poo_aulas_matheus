package br.ufpb.matheus.amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmigoScretoMap {
    private final Map<String, Amiguinho> amigos;
    private final List<Mensagem> mensagens;

    public AmigoScretoMap() {
        this.amigos = new HashMap<>();
        this.mensagens = new ArrayList<>();
    }

    public void cadastrarAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        if (this.amigos.containsKey(emailAmigo)) {
            throw new AmigoJaExisteException("Já existe um amigo cadastrado com o e-mail: " + emailAmigo);
        }
        Amiguinho novoAmigo = new Amiguinho();o(nomeAmigo, emailAmigo);
        this.amigos.put(emailAmigo, novoAmigo);
    }

    private void o(String nomeAmigo, String emailAmigo) {

    }

    public Amiguinho pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        Amiguinho amigo = this.amigos.get(emailAmigo);
        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo não encontrado com o e-mail: " + emailAmigo);
        }
        return amigo;
    }

    public void configAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amiguinho pessoa = pesquisaAmigo(emailDaPessoa);
        pesquisaAmigo(emailAmigoSorteado);
        pessoa.setEmailAmigoSorteado(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amiguinho pessoa = pesquisaAmigo(emailDaPessoa);
        String sorteado = pessoa.getEmailAmigoSorteado();
        if (sorteado == null || sorteado.trim().isEmpty()) {
            throw new AmigoNaoSorteadoException("O amigo secreto de " + emailDaPessoa + " ainda não foi sorteado.");
        }
        return sorteado;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem msg = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(msg);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        Mensagem msg = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        this.mensagens.add(msg);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem m : this.mensagens) {
            if (m.ehAnonima()) {
                anonimas.add(m);
            }
        }
        return anonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new ArrayList<>(this.mensagens);
    }
}