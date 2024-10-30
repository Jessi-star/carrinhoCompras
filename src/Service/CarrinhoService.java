package Service;

import Model.CarrinhoItem;
import Model.Produto;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoService {
    private List<CarrinhoItem> carrinho;

    public CarrinhoService() {
        this.carrinho = new ArrayList<>();
    }

    public void adicionarAoCarrinho(Produto produto, int quantidade) {
        CarrinhoItem itemExistente = this.buscarItemNoCarrinho(produto.getId());

        if (itemExistente != null) {
            itemExistente.setQuantidade(itemExistente.getQuantidade() + quantidade);
            System.out.println("Quantidade do produto atualizada no carrinho.");
        } else {
            CarrinhoItem novoItem = new CarrinhoItem(produto.getId(), produto.getNome(),
                    produto.getCategoria(), produto.getValor(), quantidade);
            carrinho.add(novoItem);
            System.out.println("Produto adicionado ao carrinho.");
        }
    }

    public void atualizarQuantidadeNoCarrinho(int idProduto, int novaQuantidade) {
        CarrinhoItem item = this.buscarItemNoCarrinho(idProduto);

        if (item != null) {
            item.setQuantidade(novaQuantidade);
            System.out.println("Quantidade do produto no carrinho atualizada.");
        } else {
            System.out.println("Produto não encontrado no carrinho.");
        }
    }

    public static void removerDoCarrinho(int idProduto) {
        CarrinhoItem item = this.buscarItemNoCarrinho(idProduto);

        if (item != null) {
            carrinho.remove(item);
            System.out.println("Produto removido do carrinho.");
        } else {
            System.out.println("Produto não encontrado no carrinho.");
        }
    }

    public static double calcularTotalCarrinho() {
        double total = 0.0;

        for (CarrinhoItem item : carrinho) {
            total += item.getValorTotal();
        }

        System.out.println("Valor total do carrinho: " + total);
        return total;
    }

    public static void listarItensDoCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            for (CarrinhoItem item : carrinho) {
                System.out.println(item);
            }
        }
    }

    private CarrinhoItem buscarItemNoCarrinho(int idProduto) {
        for (CarrinhoItem item : carrinho) {
            if (item.getId() == idProduto) {
                return item;
            }
        }
        return null;
    }
}
