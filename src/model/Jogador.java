package model;

public class Jogador {

    private String nome;
    private int idade;
    private int pontuacao;
    private int numeroTentivas;

    public Jogador(String nome, int idade, int pontuacao, int numeroTentivas) {
        this.nome = nome;
        this.idade = idade;
        this.pontuacao = pontuacao;
        this.numeroTentivas = numeroTentivas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getNumeroTentivas() {
        return numeroTentivas;
    }

    public void setNumeroTentivas(int numeroTentivas) {
        this.numeroTentivas = numeroTentivas;
    }

    public void adicionaPontos(int pontos){
        pontuacao = pontuacao + pontos;
    }

    public void perdePontos(int pontos){
        pontuacao = pontuacao - pontos;
    }

    public void adicionaTentativa(){
        numeroTentivas = numeroTentivas + 1;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontuacao=" + pontuacao +
                ", numeroTentivas=" + numeroTentivas +
                '}';
    }
}
