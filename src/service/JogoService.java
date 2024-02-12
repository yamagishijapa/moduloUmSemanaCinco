package service;

import model.Jogador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static utils.ConsoleUtils.printLogoFMT;

public class JogoService {

    List<Jogador> listaMelhoresJogadores = new ArrayList<>();

    public void iniciaJogo() {
        Scanner scanner = new Scanner(System.in);
        printLogoFMT();

        System.out.println("Bem vindo ao programa de exercicios do Modulo 1 - Semana 5 do curso FullStack. \n");
        System.out.println("\nJogo iniciado");
        System.out.println("\nInsira o seu nome jogador:");

        String nome = scanner.nextLine();

        while (verificarNomeExistente(nome)) {
            System.out.println("O nome já existe. Por favor, insira outro nome:");
            nome = scanner.nextLine();
        }

        Jogador jogador = new Jogador(nome, 26, 0, 5);

        adicionarMelhorJogador(jogador);
        exibeRanking(jogador);
    }

    public void adicionarMelhorJogador(Jogador jogador) {
        listaMelhoresJogadores.add(jogador);
        listaMelhoresJogadores.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());
    }

    public void exibeRanking(Jogador jogador) {
        System.out.println("\nRANKING \n");
        int posJogadorAtual = 0;
        if (listaMelhoresJogadores.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                System.out.println(listaMelhoresJogadores.get(i).getNome() + " - " + (i + 1));
            }
        } else {
            for (int i = 0; i < listaMelhoresJogadores.size(); i++) {
                System.out.println(listaMelhoresJogadores.get(i).getNome() + " - " + (i + 1));
            }
        }

        for (int i = 0; i < listaMelhoresJogadores.size(); i++) {
            if (listaMelhoresJogadores.get(i).equals(jogador)) {
                posJogadorAtual = i + 1;
            }
        }

        System.out.println("\nSua colocação: " + posJogadorAtual);
    }

    private boolean verificarNomeExistente(String nome) {
        for (Jogador jogador : listaMelhoresJogadores) {
            if (jogador.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }


}
