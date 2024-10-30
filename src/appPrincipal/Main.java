package appPrincipal;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcoes = -1;
        while (opcoes != 0) {
            System.out.println("*** Escolha uma opção para seu carrinho de compras: ");
            System.out.println("1. Adicionar produto no carrinho");
            System.out.println("2. Remover produtos do carrinho");
            System.out.println("3. Atualizar a quantidade de produtos no carrinho");
            System.out.println("4. Listar produtos no carrinho");
            System.out.println("5. Calcular valor total do carrinho");
            System.out.println("0. Sair do sistema");
            opcoes = scanner.nextInt();


            scanner.close();
        }
    }

}