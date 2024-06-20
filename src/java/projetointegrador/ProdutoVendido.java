package projetointegrador;

public class ProdutoVendido {
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public ProdutoVendido(Produto produto, int quantidade, double valorProduto) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorProduto * quantidade;
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

    double getValorUnitario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
