package projetointegrador;


public class ProdutoVendido {
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public ProdutoVendido(Produto produto, int quantidade, double valorTotal) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
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