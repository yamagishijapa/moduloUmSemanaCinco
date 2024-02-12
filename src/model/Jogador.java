package model;

public class Jogador {

    String nome;
    int idade;
    int pontuacao;
    int numeroTentivas;

    public void adicionaPontos(int pontos){
        pontuacao = pontuacao + pontos;
    }

    public void perdePontos(int pontos){
        pontuacao = pontuacao + pontos;
    }

    public void adicionaTentativa(){
        numeroTentivas = numeroTentivas + 1;
    }
}
