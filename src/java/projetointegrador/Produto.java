
package projetointegrador;


public class Produto {
   private int id;                             
    String nomeProduto;   
    String descricao;
    double preco;         
    int qtEstoque;
    
    
    public Produto ( String nomeProduto,String descricao, double preco, int qtEstoque){
        
        this.nomeProduto= nomeProduto;
        this.descricao=descricao;
        this.preco= preco;
        this.qtEstoque= qtEstoque;         
    }
  
        public String getNomeProduto(){
            return nomeProduto;}
        public String getDescricao(){
            return descricao;
        }
        public double getPreco (){
            return preco;
        }
        public int getQtEstoque(){
            return qtEstoque;
    }
        public int atualizarEstoque(int quantidade){
            return qtEstoque -= quantidade;
        }
           @Override
    public String toString() {
        return "Nome do Produto: " + nomeProduto +
               ", Preço: " + preco +
               ", Quantidade em Estoque: " + qtEstoque;
}

    public boolean isVendido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}