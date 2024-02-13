import model.Jogador;
import service.Jogo;
import service.JogoService;

import java.util.Scanner;

import static utils.ConsoleUtils.*;

public class Main {
    public static void main(String[] args) {
        JogoService jogoService = new JogoService();
        Jogo jogo = new Jogo();
        boolean jogoEmExecucao = false;

        printLogoFMT();

        System.out.println("\nBem vindo ao programa de exercicios do Modulo 1 - Semana 5 do curso FullStack.");
        System.out.println("JOGO PEDRA - PAPEL - TESOURA E JOGO DA ADIVINHAÇÃO. \n");

        Scanner scanner = new Scanner(System.in);
        while (true) {

            jogoService.exibeListaJogadores();

            System.out.println("Para selecionar um jogador, digite um nome da lista.");
            System.out.println("Para criar um novo jogador, digite um nome que não existe na lista. \n");
            String nome = scanner.nextLine();
            Jogador jogador = jogoService.verificarNomeExistente(nome);

            mostrarMenuPrincipal();

            String entradaUsuario = scanner.nextLine();

            if (!jogoEmExecucao) {
                if (entradaUsuario.equalsIgnoreCase("sair") ||
                        entradaUsuario.equalsIgnoreCase("0")) {
                    System.out.println("Saindo do programa. \n");
                    jogoService.exibeRanking(jogador);
                    scanner.close();
                    System.exit(0);
                }
            }


            if (!jogoEmExecucao) {
                switch (entradaUsuario) {
                    case "1":
                        jogoEmExecucao = true;
                        jogo.jogar(scanner, jogador);
                        jogoService.adicionarMelhorJogador(jogador);
                        jogoEmExecucao = false;
                        break;
                    case "2":
                        jogoEmExecucao = true;
                        System.out.println("Insira um número que definirá o limite máximo para o jogo de adivinhação.");
                        jogo.jogar(scanner, jogador, obterIntValido(scanner, scanner.nextLine()));
                        jogoService.adicionarMelhorJogador(jogador);
                        jogoEmExecucao = false;
                        break;
                    default:
                        System.out.println("Comando inválido. Use um dos comandos informados anteriormente. \n");
                }
            }


            jogoService.menuPosJogo(scanner, jogador);
        }
    }
}