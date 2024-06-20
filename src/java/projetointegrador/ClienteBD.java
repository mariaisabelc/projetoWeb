package projetointegrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteBD {
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

    public static void saveCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, cpf, endereco, telefone) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getEndereco());
            statement.setString(4, cliente.getTelefone());
            statement.executeUpdate();
        }
    }

    public static List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                    resultSet.getString("nome"),
                    resultSet.getString("cpf"),
                    resultSet.getString("endereco"),
                    resultSet.getString("telefone")
                );
                clientes.add(cliente);
            }
        }

        System.out.println("Clientes carregados: " + clientes.size()); 
        return clientes;
    }

    static Cliente getClienteById(int idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
