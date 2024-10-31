package Service;

import DAO.CarrinhoDAO;
import DAO.EstoqueDAO;
import Model.CarrinhoItem;
import Model.Produto;

import java.sql.SQLException;

public class CarrinhoService {
    private CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
    private EstoqueDAO estoqueDAO = new EstoqueDAO();

    public void adicionarProdutoAoCarrinho(int produtoId, int quantidade) throws SQLException {
        Produto produto = estoqueDAO.buscarProduto(produtoId);

        if (produto != null && produto.getQuantidade() >= quantidade) {
            CarrinhoItem item = new CarrinhoItem(produtoId, produto, quantidade);
            carrinhoDAO.adicionarItem(item);

            int novaQuantidadeEstoque = produto.getQuantidade() - quantidade;
            estoqueDAO.atualizarQuantidade(produtoId, novaQuantidadeEstoque);

            System.out.println("Produto adicionado ao carrinho.");
        } else {
            System.out.println("Produto indisponível ou quantidade insuficiente no estoque.");
        }
    }
}
