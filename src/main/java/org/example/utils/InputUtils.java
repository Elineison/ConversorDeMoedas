package org.example.utils;

import java.util.Scanner;

public class InputUtils {
    public static int lerInteiro(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
            scanner.next();
            System.out.print(mensagem);
        }
        return scanner.nextInt();
    }

    public static double lerValor(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        while (true) {
            String entrada = scanner.next();
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número válido.");
                System.out.print(mensagem);
            }
        }
    }
}
