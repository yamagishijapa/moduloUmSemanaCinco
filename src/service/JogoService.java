package service;

import model.Jogador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JogoService {

    List<Jogador> listaMelhoresJogadores = new ArrayList<>();

    public void iniciaJogo(){
        Jogador jogador =  new Jogador("Thiago", 26, 0, 5);
        System.out.println("\nJogo iniciado");
        System.out.println("\nJogador: " + jogador);
        adicionarMelhorJogador(jogador);
    }

    public void adicionarMelhorJogador(Jogador jogador) {
        listaMelhoresJogadores.add(jogador);
        listaMelhoresJogadores.sort(Comparator.comparingInt(Jogador::getPontuacao).reversed());
    }
}
