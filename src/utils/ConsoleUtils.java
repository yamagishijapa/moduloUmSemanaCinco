package utils;

import java.util.Scanner;

public class ConsoleUtils {

    public static void printLogoFMT() {
        System.out.println("███████╗██╗   ██╗██╗     ██╗         ███████╗████████╗ █████╗  ██████╗██╗  ██╗");
        System.out.println("██╔════╝██║   ██║██║     ██║         ██╔════╝╚══██╔══╝██╔══██╗██╔════╝██║ ██╔╝");
        System.out.println("█████╗  ██║   ██║██║     ██║         ███████╗   ██║   ███████║██║     █████╔╝ ");
        System.out.println("██╔══╝  ██║   ██║██║     ██║         ╚════██║   ██║   ██╔══██║██║     ██╔═██╗ ");
        System.out.println("██║     ╚██████╔╝███████╗███████╗    ███████║   ██║   ██║  ██║╚██████╗██║  ██╗");
        System.out.println("╚═╝      ╚═════╝ ╚══════╝╚══════╝    ╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝");
        System.out.println("                                                                              ");
    }

    public static void mostrarMenuPrincipal(){

        System.out.println("\nPara selecionar o jogo de Pedra, Papel e Tesoura digite '1';");
        System.out.println("Para selecionar o jogo de adivinhação digite '2';");
        System.out.println("Para sair do programa, digite 'sair' ou '0'. \n");
    }

    public static void mostrarMenuPosJogo(){
        System.out.println("Selecione uma das opções para seguir: \n");
        System.out.println("Para visualizar o ranking completo digite '1';");
        System.out.println("Para visualizar os top 10 jogadores digite '2';");
        System.out.println("Para jogar novamente digite '3';");
        System.out.println("Para encerrar o programa, digite 'sair' ou '0'. \n");
    }

    public static int obterIntValido(Scanner scanner, String input) {
        int numero = 0;
        boolean primeiraEntrada = true;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                if (primeiraEntrada) {
                    primeiraEntrada = false;
                    numero = Integer.parseInt(input);
                    entradaValida = true;
                } else {
                    System.out.println("Digite um número válido: ");
                    numero = Integer.parseInt(scanner.nextLine());
                    entradaValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido. \n");
            }
        }

        return numero;
    }
}
