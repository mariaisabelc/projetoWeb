package projetointegrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
    private int id;
    private Cliente cliente;
    private Date data;
    private List<ProdutoVendido> produtosVendidos;
    private int quantidadeTotal;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.data = new Date();
        this.produtosVendidos = new ArrayList<>();
        this.quantidadeTotal = 0;
    }


    public int getId() {
        return id;
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

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (ProdutoVendido produtoVendido : produtosVendidos) {
            valorTotal += produtoVendido.getValorTotal();
        }
        return valorTotal;
    }

    public boolean adicionarProduto(Produto produto, int quantidade, double valorProduto) {
        ProdutoVendido produtoVendido = new ProdutoVendido(produto, quantidade, valorProduto);
        boolean sucesso = produtosVendidos.add(produtoVendido);

        if (sucesso) {
            quantidadeTotal += quantidade;
        }

        return sucesso;
    }

    public void setProdutosVendidos(List<ProdutoVendido> produtosVendidos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
