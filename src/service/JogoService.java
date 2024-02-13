package service;

import model.Jogador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static utils.ConsoleUtils.*;

public class JogoService {

    List<Jogador> listaMelhoresJogadores = new ArrayList<>();

    public void adicionarMelhorJogador(Jogador jogador) {
        for (Jogador j : listaMelhoresJogadores) {
            if (j.getNome().equals(jogador.getNome())) {
                return;
            }
        }
        listaMelhoresJogadores.add(jogador);
        listaMelhoresJogadores.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());
    }

    public void exibeRanking(Jogador jogador) {
        int posJogadorAtual = 0;

        if (listaMelhoresJogadores.isEmpty()) {
            System.out.println("Ainda não há jogadores no ranking.");
            return;
        }

        if (listaMelhoresJogadores.size() >= 10) {
            System.out.println("\nTOP 10 JOGADORES \n");
            for (int i = 0; i < 10; i++) {
                System.out.println((i + 1) + " - " + listaMelhoresJogadores.get(i).getNome() + " - " + listaMelhoresJogadores.get(i).getPontuacao() + "PTS");
            }
        } else {
            System.out.println("\nRANKING GERAL\n");
            for (int i = 0; i < listaMelhoresJogadores.size(); i++) {
                System.out.println((i + 1) + " - " + listaMelhoresJogadores.get(i).getNome() + " - " + listaMelhoresJogadores.get(i).getPontuacao() + "PTS");
            }
        }

        for (int i = 0; i < listaMelhoresJogadores.size(); i++) {
            if (listaMelhoresJogadores.get(i).equals(jogador)) {
                posJogadorAtual = i + 1;
            }
        }

        System.out.println("\nSua colocação: " + posJogadorAtual);
        System.out.println("Pontuação total: " + jogador.getPontuacao());
        System.out.println("Quantidade de tentativas: " + jogador.getNumeroTentivas());
    }

    public void exibeListaJogadores(){
        System.out.println("Lista de Jogadores: \n");
        for(Jogador jogador : listaMelhoresJogadores){
            System.out.println(" - " + jogador.getNome());
        }
        System.out.println("\n");
    }

    public Jogador verificarNomeExistente(String nome) {
        for (Jogador jogador : listaMelhoresJogadores) {
            if (jogador.getNome().equals(nome)) {
                return jogador;
            }
        }
        return new Jogador(nome, 0, 0, 0);
    }

    public void menuPosJogo(Scanner scanner, Jogador jogador) {
        boolean menuPosJogoEmExecucao = true;

        while (menuPosJogoEmExecucao) {
            mostrarMenuPosJogo();
            String entradaUsuario = scanner.nextLine();
            switch (entradaUsuario) {
                case "1":
                case "2":
                    exibeRanking(jogador);
                    break;
                case "3":
                    menuPosJogoEmExecucao = false;
                    break;
                case "0":
                    System.out.println("Saindo do programa. \n");
                    adicionarMelhorJogador(jogador);
                    exibeRanking(jogador);
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Comando inválido. Use um dos comandos informados anteriormente. \n");
            }
        }
    }

}
