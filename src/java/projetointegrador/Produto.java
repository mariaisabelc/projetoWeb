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

    public void atualizarEstoque(int quantidade) {
        this.qtEstoque -= quantidade;
    }

    @Override
    public String toString() {
        return "Nome do Produto: " + nomeProduto +
               ", Preço: " + preco +
               ", Quantidade em Estoque: " + qtEstoque;
    }

    
    public boolean isVendido() {
        return false; 
    }
}
