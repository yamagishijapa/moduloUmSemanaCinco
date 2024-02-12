package service;

import model.Jogador;

public class JogoService {

    public void iniciaJogo(){
        Jogador jogador =  new Jogador();
        System.out.println("\nJogo iniciado");
        System.out.println("\nJogador: " + jogador);
    }
}
