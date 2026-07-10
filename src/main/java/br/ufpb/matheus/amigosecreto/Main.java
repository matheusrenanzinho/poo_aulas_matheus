package br.ufpb.matheus.amigosecreto;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AmigoScretoMap sistema = new AmigoScretoMap();

        System.out.println("=== INICIANDO O SISTEMA DE AMIGO SECRETO DA AULA DE POO (MAP) ===");

        try {
            System.out.println("\n-> Cadastrando amigos...");
            sistema.cadastrarAmigo("Matheus Renan", "matheus.lemos@dcx.ufpb.br");
            sistema.cadastrarAmigo("Lionel Messi", "messigoat@.com");
            sistema.cadastrarAmigo("Neymar Jr", "neymarJr@.com");
            System.out.println("Amigos cadastrados com sucesso!");

            System.out.println("\n-> Realizando o sorteio manual...");
            sistema.configAmigoSecretoDe("matheus.lemos@dcx.ufpb.br", "neymarJr@.com");
            sistema.configAmigoSecretoDe("messigoat@.com", "matheus.lemos@dcx.ufpb.br");
            sistema.configAmigoSecretoDe("neymarJr@.com", "joao@sertoes.com");
            System.out.println("Sorteio configurado!");

            System.out.println("\n-> Enviando mensagens pelo sistema...");
            sistema.enviarMensagemParaTodos("Ei povo? A festa vai ser um estouro ein!", "kauan.gomes@dcx.ufpb.br", false);
            sistema.enviarMensagemParaAlguem("Acho que tirei tu, viu?", "joao@sertoes.com", "kauan.gomes@dcx.ufpb.br", true);

            System.out.println("\n=== CONSULTANDO RESULTADOS ===");

            String secretoDe = sistema.pesquisaAmigoSecretoDe("matheus.renan@dcx.ufpb.br");
            Amiguinho amigoSorteado = sistema.pesquisaAmigo(secretoDe);
            System.out.println("O amigo secreto de Matheus é: " + amigoSorteado.getNome() + " (" + secretoDe + ")");

            System.out.println("\n-> Lista de todas as mensagens:");
            List<Mensagem> todasAsMensagens = sistema.pesquisaTodasAsMensagens();
            for (Mensagem m : todasAsMensagens) {
                System.out.println("   " + m.getFormatadaParaEnvio());
            }

        } catch (AmigoJaExisteException | AmigoInexistenteException | AmigoNaoSorteadoException e) {

            System.out.println("\nDeu erro no sistema: " + e.getMessage());
        }

        System.out.println("\n=== FIM DA EXECUÇÃO ===");
    }
}