package projetointegrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioBD {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/projeto_integrador";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "1111";

    static {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver JDBC do MySQL carregado com sucesso!");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver JDBC do MySQL: " + e.getMessage());
        }
    }

    public static Usuario validarUsuario(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        Usuario usuarioEncontrado = null;

        try (Connection conexao = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
             PreparedStatement statement = conexao.prepareStatement(sql)) {

            System.out.println("Conexão com o banco de dados estabelecida.");

            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getSenha());
            System.out.println("Query preparada: " + statement.toString());

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    usuarioEncontrado = new Usuario();
                    usuarioEncontrado.setId(rs.getInt("id"));
                    usuarioEncontrado.setLogin(rs.getString("login"));
                    usuarioEncontrado.setSenha(rs.getString("senha"));
                    System.out.println("Usuário encontrado: " + usuarioEncontrado.getLogin());
                } else {
                    System.out.println("Usuário não encontrado.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao validar usuário: " + ex.getMessage());
        }

        return usuarioEncontrado;
    }
}
