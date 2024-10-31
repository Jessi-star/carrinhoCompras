package DAO;


import Database.ConexaoBD;
import Model.CarrinhoItem;
import Model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO {
    public void adicionarItem(CarrinhoItem item) throws SQLException {
        String sql = "INSERT INTO carrinho (id, nome, categoria, valor, quantidade, valor_total) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, item.getId());
            stmt.setString(2, item.getProduto().getNome());
            stmt.setString(3, item.getProduto().getCategoria());
            stmt.setDouble(4, item.getProduto().getValor());
            stmt.setInt(5, item.getQuantidade());
            stmt.setDouble(6, item.getValorTotal());
            stmt.executeUpdate();
        }
    }

    public List<CarrinhoItem> listarItens() throws SQLException {
        List<CarrinhoItem> itens = new ArrayList<>();
        String sql = "SELECT * FROM carrinho";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("categoria"),
                        rs.getDouble("valor"),
                        0);
                CarrinhoItem item = new CarrinhoItem(
                        rs.getInt("id"),
                        produto,
                        rs.getInt("quantidade"));
                itens.add(item);
            }
        }
        return itens;
    }

    public void atualizarItem(int id, int quantidade) throws SQLException {
        String sql = "UPDATE carrinho SET quantidade = ?, valor_total = valor * ? WHERE id = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, quantidade);
            stmt.setInt(2, quantidade);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    public void removerItem(int id) throws SQLException {
        String sql = "DELETE FROM carrinho WHERE id = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

