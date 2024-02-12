package service;

import model.Jogador;

import java.util.*;

public class Jogo {

    private String melhorJogador;
    private int numeroJogadas;

    public void jogar(Scanner scanner, Jogador jogador, List<Jogador> melhoresJogadores) {
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
                    jogador.setNumeroTentivas(numeroJogadas);
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

            jogador.adicionaTentativa();
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
