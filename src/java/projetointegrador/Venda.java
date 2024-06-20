package projetointegrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
    private int id;
    private Cliente cliente;
    private Date data;
    private List<ProdutoVendido> produtosVendidos;
    private double desconto;

    public Venda(int id, Cliente cliente, Date data, double desconto) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.desconto = desconto;
        this.produtosVendidos = new ArrayList<>();
    }

    public Venda(Cliente cliente, double desconto) {
        this.cliente = cliente;
        this.data = new Date();
        this.desconto = desconto;
        this.produtosVendidos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getData() {
        return data;
    }

    public List<ProdutoVendido> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(List<ProdutoVendido> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (ProdutoVendido produtoVendido : produtosVendidos) {
            valorTotal += produtoVendido.getValorTotal();
        }
        return valorTotal - desconto;
    }

    public boolean adicionarProduto(Produto produto, int quantidade, double valorProduto) {
        ProdutoVendido produtoVendido = new ProdutoVendido(produto, quantidade, valorProduto);
        return produtosVendidos.add(produtoVendido);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", data=" + data +
                ", produtosVendidos=" + produtosVendidos +
                ", desconto=" + desconto +
                '}';
    }
}
