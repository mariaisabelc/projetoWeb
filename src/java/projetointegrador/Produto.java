package projetointegrador;

public class Produto {
    private int id;                             
    private String nomeProduto;   
    private String descricao;
    private double preco;         
    private int qtEstoque;

    public Produto(String nomeProduto, String descricao, double preco, int qtEstoque) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.qtEstoque = qtEstoque;         
    }

    Produto(int idProduto, String nomeProduto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters e Setters
    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQtEstoque() {
        return qtEstoque;
    }

    int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
