
package projetointegrador;


public class Cliente {
     private int id;

String nome;

String endereco;

String telefone;

String  email;


public Cliente (String nome, String endereco, String telefone, String email){
    this.nome= nome;
    this.endereco=endereco;
    this.telefone= telefone;
    this.email=email;
            
}
 public String getNome(){
     return nome;
 }
  public String getEndereco(){
     return endereco;
 }
   public String getTelefone(){
     return telefone;
 }
    public String getEmail(){
     return email;
 }
}