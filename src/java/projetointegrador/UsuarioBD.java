package projetointegrador;
import java.sql.Connection;
                      import java.sql.DriverManager;
                      import java.sql.SQLException;
                      import java.sql.PreparedStatement;
                      import java.sql.ResultSet;
                      
                      public class UsuarioBD {
                         public static Usuario validarUsuarioSeguro(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        Usuario usuarioEncontrado = null;

        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/pi", "root", "1111");
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getSenha());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                usuarioEncontrado = new Usuario();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipo(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao validar usuário: " + ex.getMessage());
        }

        return usuarioEncontrado;
    
                          }
                          
                          
                          // M�TODO INSEGURO!!!
                          public static Usuario validarUsuarioInseguro(Usuario usuario) {
                              String sql = "SELECT * FROM usuario WHERE login = "+ usuario.getLogin() +" AND senha = " + usuario.getSenha();
                              Usuario usuarioEncontrado = null;
                      
                              try {
                                  Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_exemplo", "root", "");
                                  PreparedStatement statement = conexao.prepareStatement(sql);
                                  ResultSet rs = statement.executeQuery();
                      
                                  while (rs.next()) {
                                      usuarioEncontrado = new Usuario();
                                      usuarioEncontrado.setId(rs.getInt("id"));
                                      usuarioEncontrado.setNome(rs.getString("nome"));
                                      usuarioEncontrado.setLogin(rs.getString("login"));
                                      usuarioEncontrado.setSenha(rs.getString("senha"));
                                      usuarioEncontrado.setTipo(rs.getString("tipo"));
                                  }
                              } catch (SQLException ex) {
                                  System.out.println("Sintaxe de comando invalida");
                              }
                              
                              return usuarioEncontrado;
                          }    
                      } 
                    