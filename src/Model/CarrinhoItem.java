package Model;

public class CarrinhoItem {
    private int id;
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public CarrinhoItem(int id, Produto produto, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = produto.getValor() * quantidade;
    }


    public int getId() {
        return id;
    }
    public Produto getProduto() {
        return produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public double getValorTotal() {
        return valorTotal;
    }
}