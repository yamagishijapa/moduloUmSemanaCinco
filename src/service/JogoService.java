package service;

import model.Jogador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JogoService {

    List<Jogador> listaMelhoresJogadores = new ArrayList<>();

    public void iniciaJogo() {
        Jogador jogador = new Jogador("Thiago", 26, 100, 5);
        System.out.println("\nJogo iniciado");
        System.out.println("\nJogador: " + jogador);
        adicionarMelhorJogador(jogador);
        exibeRanking(jogador);
    }

    public void adicionarMelhorJogador(Jogador jogador) {
        listaMelhoresJogadores.add(jogador);
        listaMelhoresJogadores.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());
    }

    public void exibeRanking(Jogador jogador) {
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
}
