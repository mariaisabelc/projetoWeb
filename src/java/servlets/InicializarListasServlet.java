package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import projetointegrador.Cliente;
import projetointegrador.ClienteBD;
import projetointegrador.Produto;
import projetointegrador.ProdutoBD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/InitializeServlet")
public class InicializarListasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        try {
            List<Cliente> clientes = ClienteBD.getAllClientes();
            List<Produto> produtos = ProdutoBD.getAllProdutos();

            getServletContext().setAttribute("clientes", clientes);
            getServletContext().setAttribute("produtos", produtos);
        } catch (SQLException e) {
            throw new ServletException("Failed to load initial data", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        response.sendRedirect("telacaixa.jsp");
    }
}
