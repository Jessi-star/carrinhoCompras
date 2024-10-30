package model;

public class carrinhoItem {
    private int id;
    private String nome;
    private String categoria;
    private double valor;
    private int quantidade;
    private double valorTotal;

    public carrinhoItem() {

    }

    public carrinhoItem(int id, String nome, String categoria, double valor, int quantidade, double valorTotal) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.valor = valor;
        this.quantidade = quantidade;
        this.valorTotal = valor * quantidade;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCategoria(){
        return categoria = categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor(){
        return valor;
    }

    public void setValor(double valor){
        this.valor = valor;
        calcularValorTotal();
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
        calcularValorTotal();
    }

    public double getvalorTotal(){
        return valorTotal;
    }

    private void calcularValorTotal(){
        this.valorTotal = this.valor * this.quantidade;
    }

    @Override
    public String toString() {
        return "CarrinhoItem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
