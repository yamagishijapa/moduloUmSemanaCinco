package service;

import model.Jogador;

public class JogoService {

    public void iniciaJogo(){
        Jogador jogador =  new Jogador("Thiago", 26, 0, 5);
        System.out.println("\nJogo iniciado");
        System.out.println("\nJogador: " + jogador);
    }
}
