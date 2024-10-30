package App;

import Model.Produto;
import Service.CarrinhoService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarrinhoService carrinhoService = new CarrinhoService();


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


            switch (opcoes) {
                case 1:
                    adicionarAoCarrinho(carrinhoService, scanner);
                    break;
                case 2:
                    atualizarQuantidadeNoCarrinho(carrinhoService, scanner);
                    break;
                case 3:
                    removerDoCarrinho(carrinhoService, scanner);
                    break;
                case 4:
                    carrinhoService.listarItensDoCarrinho();
                    break;
                case 5:
                    carrinhoService.calcularTotalCarrinho();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        }

        scanner.close();
    }

    private static void adicionarAoCarrinho (CarrinhoService carrinhoService, Scanner scanner){
        System.out.println("Digite o ID do produto: ");
        int produtoId = scanner.nextInt();
        System.out.println("Digite a quantidade: ");
        int quantidade = scanner.nextInt();


        boolean sucesso = carrinhoService.adicionarAoCarrinho(ProdutoId, quantidade);
        if (sucesso) {
            System.out.println("Produto adicionado ao carrinho com sucesso.");
        } else {
            System.out.println("Erro ao adicionar produto. Verifique estoque.");
        }
    }

    private static void atualizarQuantidadeNoCarrinho (CarrinhoService Carrinho, Scanner scanner) {
        System.out.print("Digite o ID do produto para atualizar: ");
        int idProduto = scanner.nextInt();
        System.out.print("Digite a nova quantidade: ");
        int novaQuantidade = scanner.nextInt();

        CarrinhoService.atualizarQuantidadeNoCarrinho(idProduto, novaQuantidade);
        System.out.println("Quantidade atualizada com sucesso.");
    }

    private static void removerDoCarrinho(CarrinhoService CarrinhoService, Scanner scanner) {
        System.out.print("Digite o ID do produto a remover: ");
        int idProduto = scanner.nextInt();

        Service.CarrinhoService.removerDoCarrinho(idProduto);
        System.out.println("Produto removido do carrinho.");
    }

    private static void listarItensDoCarrinho(CarrinhoService CarrinhoService) {
        System.out.println("Produtos no carrinho:");
        for (Produto produto : Service.CarrinhoService.listarItensDoCarrinho()) {
            System.out.println("ID: " + produto.getId() +
                    ", Nome: " + produto.getNome() +
                    ", Categoria: " + produto.getCategoria() +
                    ", Valor: " + produto.getValor() +
                    ", Quantidade: " + produto.getQuantidade());
        }
    }

    private static void calcularTotalCarrinho(CarrinhoService CarrinhoService) {
        double valorTotal = Service.CarrinhoService.calcularTotalCarrinho();
        System.out.println("Valor total do carrinho: R$ " + valorTotal);
    }
}















