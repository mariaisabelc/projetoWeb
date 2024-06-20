package projetointegrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/projeto_integrador";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";  

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load MySQL driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void saveProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO produtos (nomeProduto, descricao, preco, qtEstoque) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, produto.getNomeProduto());
            statement.setString(2, produto.getDescricao());
            statement.setDouble(3, produto.getPreco());
            statement.setInt(4, produto.getQtEstoque());
            statement.executeUpdate();
        }
    }

    public static List<Produto> getAllProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Produto produto = new Produto(
                    resultSet.getString("nomeProduto"),
                    resultSet.getString("descricao"),
                    resultSet.getDouble("preco"),
                    resultSet.getInt("qtEstoque")
                );
                produtos.add(produto);
            }
        }

        System.out.println("Produtos carregados: " + produtos.size());  
        return produtos;
    }
}
