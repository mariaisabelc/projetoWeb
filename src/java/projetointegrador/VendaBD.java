package projetointegrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VendaBD {
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

    public static void saveVenda(Venda venda) throws SQLException {
        String sql = "INSERT INTO venda (id_cliente, valor_total, desconto) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, venda.getCliente().getId());
            statement.setDouble(2, venda.calcularValorTotal());
            statement.setDouble(3, venda.getDesconto());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to save the sale, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int vendaId = generatedKeys.getInt(1);
                    venda.setId(vendaId);

                    saveProdutosVendidos(vendaId, venda.getProdutosVendidos());
                } else {
                    throw new SQLException("Failed to save the sale, no ID obtained.");
                }
            }
        }
    }

    private static void saveProdutosVendidos(int vendaId, List<ProdutoVendido> produtosVendidos) throws SQLException {
        String sql = "INSERT INTO venda_produto (id_venda, id_produto, quantidade, valor_unitario) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (ProdutoVendido pv : produtosVendidos) {
                statement.setInt(1, vendaId);
                statement.setInt(2, pv.getProduto().getId()); // Supondo que Produto tenha um método getId()
                statement.setInt(3, pv.getQuantidade());
                statement.setDouble(4, pv.getValorTotal() / pv.getQuantidade()); // Valor unitário por produto vendido
                statement.addBatch();
            }

            statement.executeBatch();
        }
    }

    public static List<Venda> getAllVendas() throws SQLException {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM venda";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idCliente = resultSet.getInt("id_cliente");
                double valorTotal = resultSet.getDouble("valor_total");
                double desconto = resultSet.getDouble("desconto");

                Cliente cliente = ClienteBD.getClienteById(idCliente);
                
                List<ProdutoVendido> produtosVendidos = getProdutosVendidosByVendaId(id);

           
                Venda venda = new Venda(id, cliente, new Date(), desconto);
                venda.setProdutosVendidos(produtosVendidos);

                vendas.add(venda);
            }
        }

        return vendas;
    }

    private static List<ProdutoVendido> getProdutosVendidosByVendaId(int vendaId) throws SQLException {
        List<ProdutoVendido> produtosVendidos = new ArrayList<>();
        String sql = "SELECT vp.id_produto, p.nomeProduto, vp.quantidade, vp.valor_unitario " +
                     "FROM venda_produto vp " +
                     "JOIN produtos p ON vp.id_produto = p.id " +
                     "WHERE vp.id_venda = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, vendaId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idProduto = resultSet.getInt("id_produto");
                    String nomeProduto = resultSet.getString("nomeProduto");
                    int quantidade = resultSet.getInt("quantidade");
                    double valorUnitario = resultSet.getDouble("valor_unitario");

                    Produto produto = new Produto(idProduto, nomeProduto);
                    ProdutoVendido produtoVendido = new ProdutoVendido(produto, quantidade, valorUnitario);
                    produtosVendidos.add(produtoVendido);
                }
            }
        }

        return produtosVendidos;
    }

    public static void deleteVenda(int vendaId) throws SQLException {
        String sqlDeleteVenda = "DELETE FROM venda WHERE id = ?";
        String sqlDeleteVendaProduto = "DELETE FROM venda_produto WHERE id_venda = ?";
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement statementVenda = connection.prepareStatement(sqlDeleteVenda);
                 PreparedStatement statementVendaProduto = connection.prepareStatement(sqlDeleteVendaProduto)) {

                statementVenda.setInt(1, vendaId);
                statementVenda.executeUpdate();

                statementVendaProduto.setInt(1, vendaId);
                statementVendaProduto.executeUpdate();

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            } finally {
                connection.setAutoCommit(true);
            }
        }
    }
}
