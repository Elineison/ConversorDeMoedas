package org.example;

import org.example.api.ExchangeRateApi;

import java.util.Scanner;

public class ConversorDeMoedas {
    private static final ExchangeRateApi exchangeRateApi = new ExchangeRateApi();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===========================================");
        System.out.println("        BEM-VINDO AO CONVERSOR DE MOEDAS");
        System.out.println("===========================================");

        while (true) {
            exibirOpcoesConversao();

            System.out.print("Escolha uma opção de conversão (ou 0 para sair): ");
            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("-------------------------------------------");
                System.out.println("Saindo do conversor. Até mais!");
                System.out.println("-------------------------------------------");
                break;
            }

            // Verifica se a opção é válida
            if (opcao < 1 || opcao > 12) {
                System.out.println("-------------------------------------------");
                System.out.println("Opção inválida! O programa será encerrado.");
                System.out.println("-------------------------------------------");
                break;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            // Validação do valor
            if (valor <= 0) {
                System.out.println("-------------------------------------------");
                System.out.println("Valor inválido! O valor deve ser maior que zero.");
                System.out.println("-------------------------------------------");
                continue; // Retorna ao início do loop
            }

            realizarConversao(opcao, valor);
        }
        scanner.close();
    }

    private static void exibirOpcoesConversao() {
        System.out.println("-------------------------------------------");
        System.out.println("Escolha uma das opções de conversão:");
        String[] opcoes = {
                "1. BRL para USD",
                "2. USD para BRL",
                "3. BRL para ARS",
                "4. ARS para BRL",
                "5. BRL para BOB",
                "6. BOB para BRL",
                "7. BRL para CLP",
                "8. CLP para BRL",
                "9. BRL para COP",
                "10. COP para BRL",
                "11. USD para ARS",
                "12. ARS para USD",
                "0. Sair"
        };
        for (String opcao : opcoes) {
            System.out.println(opcao);
        }
        System.out.println("-------------------------------------------");
    }

    private static void realizarConversao(int opcao, double valor) {
        String moedaBase = "";
        String moedaAlvo = "";

        switch (opcao) {
            case 1 -> { moedaBase = "BRL"; moedaAlvo = "USD"; }
            case 2 -> { moedaBase = "USD"; moedaAlvo = "BRL"; }
            case 3 -> { moedaBase = "BRL"; moedaAlvo = "ARS"; }
            case 4 -> { moedaBase = "ARS"; moedaAlvo = "BRL"; }
            case 5 -> { moedaBase = "BRL"; moedaAlvo = "BOB"; }
            case 6 -> { moedaBase = "BOB"; moedaAlvo = "BRL"; }
            case 7 -> { moedaBase = "BRL"; moedaAlvo = "CLP"; }
            case 8 -> { moedaBase = "CLP"; moedaAlvo = "BRL"; }
            case 9 -> { moedaBase = "BRL"; moedaAlvo = "COP"; }
            case 10 -> { moedaBase = "COP"; moedaAlvo = "BRL"; }
            case 11 -> { moedaBase = "USD"; moedaAlvo = "ARS"; }
            case 12 -> { moedaBase = "ARS"; moedaAlvo = "USD"; }
        }

        double valorConvertido = calcularConversao(moedaBase, moedaAlvo, valor);
        System.out.printf("===========================================%n");
        System.out.printf("O valor convertido de %.2f %s é: %.2f %s%n", valor, moedaBase, valorConvertido, moedaAlvo);
        System.out.println("===========================================");
    }

    private static double calcularConversao(String moedaBase, String moedaAlvo, double valor) {
        double taxaDeCambio = exchangeRateApi.obterTaxaDeCambio(moedaBase, moedaAlvo);
        return valor * taxaDeCambio;
    }
}
