package App;

import DAO.CarrinhoDAO;
import DAO.EstoqueDAO;
import Model.CarrinhoItem;
import Model.Produto;
import Service.CarrinhoService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static CarrinhoService carrinhoService = new CarrinhoService();
    private static EstoqueDAO estoqueDAO = new EstoqueDAO();
    private static CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1 -> adicionarProdutoEstoque();
                    case 2 -> listarProdutosEstoque();
                    case 3 -> atualizarProdutoEstoque();
                    case 4 -> removerProdutoEstoque();
                    case 5 -> adicionarProdutoCarrinho();
                    case 6 -> listarItensCarrinho();
                    case 7 -> atualizarItemCarrinho();
                    case 8 -> removerItemCarrinho();
                    case 9 -> calcularValorTotalCarrinho();
                    case 0 -> {
                        System.out.println("Saindo...");
                        return;
                    }
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n***** Menu *****");
        System.out.println("1. Adicionar Produto ao Estoque");
        System.out.println("2. Listar Produtos do Estoque");
        System.out.println("3. Atualizar Produto no Estoque");
        System.out.println("4. Remover Produto do Estoque");
        System.out.println();
        System.out.println("5. Adicionar Produto ao Carrinho");
        System.out.println("6. Listar Itens do Carrinho");
        System.out.println("7. Atualizar Item no Carrinho");
        System.out.println("8. Remover Item do Carrinho");
        System.out.println();
        System.out.println("9. Calcular Valor Total do Carrinho");
        System.out.println("0. Sair");
        System.out.println();
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarProdutoEstoque() throws SQLException {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a categoria do produto: ");
        String categoria = scanner.nextLine();
        System.out.print("Digite o valor do produto: ");
        double valor = scanner.nextDouble();
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();

        if (quantidade < 1) {
            System.out.println("A quantidade mínima do produto deve ser 1. Tente novamente.");
        } else {
            Produto produto = new Produto(0, nome, categoria, valor, quantidade);
            estoqueDAO.adicionarProduto(produto);
            System.out.println("Produto adicionado ao estoque.");

        }

    }

    private static void listarProdutosEstoque() throws SQLException {
        List<Produto> produtos = estoqueDAO.listarProdutos();
        System.out.println("\n--- Produtos no Estoque ---");
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Quantidade: " + produto.getQuantidade());
        }
    }

    private static void atualizarProdutoEstoque() throws SQLException {
        System.out.print("Digite o ID do produto a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o novo nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a nova categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Digite o novo valor: ");
        double valor = scanner.nextDouble();
        System.out.print("Digite a nova quantidade: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(id, nome, categoria, valor, quantidade);
        estoqueDAO.atualizarProduto(produto);
        System.out.println("Produto atualizado no estoque.");
    }

    private static void removerProdutoEstoque() throws SQLException {
        System.out.print("Digite o ID do produto a ser removido: ");
        int id = scanner.nextInt();

        estoqueDAO.removerProduto(id);
        System.out.println("Produto removido do estoque.");
    }

    private static void adicionarProdutoCarrinho() throws SQLException {
        System.out.print("Digite o ID do produto a ser adicionado ao carrinho: ");
        int produtoId = scanner.nextInt();
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();

        carrinhoService.adicionarProdutoAoCarrinho(produtoId, quantidade);
    }

    private static void listarItensCarrinho() throws SQLException {
        List<CarrinhoItem> itens = carrinhoDAO.listarItens();
        System.out.println("\n--- Itens no Carrinho ---");
        for (CarrinhoItem item : itens) {
            System.out.println("ID: " + item.getId() + ", Nome: " + item.getProduto().getNome() +
                    ", Quantidade: " + item.getQuantidade() + ", Valor Total: " + item.getValorTotal());
        }
    }

    private static void atualizarItemCarrinho() throws SQLException {
        System.out.print("Digite o ID do item a ser atualizado no carrinho: ");
        int id = scanner.nextInt();
        System.out.print("Digite a nova quantidade: ");
        int quantidade = scanner.nextInt();

        carrinhoDAO.atualizarItem(id, quantidade);
        System.out.println("Item atualizado no carrinho.");
    }

    private static void removerItemCarrinho() throws SQLException {
        System.out.print("Digite o ID do item a ser removido do carrinho: ");
        int id = scanner.nextInt();

        carrinhoDAO.removerItem(id);
        System.out.println("Item removido do carrinho.");
    }

    private static void calcularValorTotalCarrinho() throws SQLException {
        List<CarrinhoItem> itens = carrinhoDAO.listarItens();
        double total = 0;
        for (CarrinhoItem item : itens) {
            total += item.getValorTotal();
        }
        System.out.println("Valor total do carrinho: " + total);
    }
}
