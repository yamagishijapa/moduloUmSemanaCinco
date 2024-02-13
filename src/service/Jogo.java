package service;

import model.Jogador;

import java.util.*;

import static utils.ConsoleUtils.obterIntValido;

public class Jogo {

    private String melhorJogador;
    private int numeroJogadas;

    public void jogar(Scanner scanner, Jogador jogador) {
        numeroJogadas = 0;
        System.out.println("Pedra, Papel e Tesoura.");

        while (true) {
            System.out.println("\nDigite sua jogada :");
            System.out.println("PEDRA - Digite '1' ou 'pedra';");
            System.out.println("PAPEL - Digite '2' ou 'papel';");
            System.out.println("TESOURA - Digite '3' ou 'tesoura';");
            System.out.println("Para sair, digite '0' ou 'sair'.");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("sair")) {
                System.out.println("Jogo encerrado.");
                break;
            }

            switch (input.toLowerCase()) {
                case "pedra":
                case "1":
                    input = "pedra";
                    break;
                case "papel":
                case "2":
                    input = "papel";
                    break;
                case "tesoura":
                case "3":
                    input = "tesoura";
                    break;
                case "sair":
                case "0":
                    System.out.println("Saindo do jogo.");
                    jogador.adicionaTentativa(numeroJogadas);
                    return;
                default:
                    System.out.println("Jogada inválida. Use uma das jogadas informadas anteriormente. \n");
                    continue;
            }

            String[] opcoes = {"pedra", "papel", "tesoura"};
            int indice = (int) (Math.random() * 3);
            String jogadaComputador = opcoes[indice];

            String resultado = determinarResultado(input, jogadaComputador, jogador);

            numeroJogadas++;

            System.out.println("Você jogou: " + input);
            System.out.println("O computador jogou: " + jogadaComputador);
            System.out.println(resultado);
        }
    }

    public void jogar(Scanner scanner, Jogador jogador, int numeroMax) {
        numeroJogadas = 0;
        boolean validacaoNumerica = false;
        System.out.println("Jogo de adivinhação.");

        if(!validacaoNumerica){
            while (true) {
                System.out.println("\nAdivinhe o número de 0 a " + numeroMax + ": ");
                System.out.println("\nDigite 'sair' para encerrar o jogo.");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("sair")) {
                    System.out.println("Jogo encerrado.");
                    jogador.adicionaTentativa(numeroJogadas);
                    break;
                }

                int numeroAleatorio = (int) (Math.random() * (numeroMax + 1));


                validacaoNumerica = true;
                int numeroEscolhido = obterIntValido(scanner, input);
                validacaoNumerica = false;
                if (numeroEscolhido < 0 || numeroEscolhido > numeroMax) {
                    System.out.println("Número fora do intervalo permitido.");
                    continue;
                }

                if (numeroEscolhido == numeroAleatorio) {
                    System.out.println("Parabéns! Você acertou!");
                    jogador.adicionaPontos(1);
                } else {
                    System.out.println("Número incorreto. O número correto era: " + numeroAleatorio);
                    jogador.perdePontos(1);
                }

                numeroJogadas++;

            }
        }

    }

    private String determinarResultado(String jogadaJogador, String jogadaComputador, Jogador jogador) {
        if (jogadaJogador.equals(jogadaComputador)) {
            return "Empate!";
        } else if ((jogadaJogador.equals("pedra") && jogadaComputador.equals("tesoura")) ||
                (jogadaJogador.equals("papel") && jogadaComputador.equals("pedra")) ||
                (jogadaJogador.equals("tesoura") && jogadaComputador.equals("papel"))) {
            jogador.adicionaPontos(1);
            return "Você ganhou!";
        } else {
            jogador.perdePontos(1);
            return "Você perdeu!";
        }
    }
}
