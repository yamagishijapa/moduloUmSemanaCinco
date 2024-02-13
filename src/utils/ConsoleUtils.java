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
