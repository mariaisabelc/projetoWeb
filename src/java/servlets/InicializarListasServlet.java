package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import projetointegrador.Cliente;
import projetointegrador.Produto;

@WebServlet("/InicializarListasServlet")
public class InicializarListasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
    
        List<Cliente> clientes = (List<Cliente>) session.getAttribute("clientes");
        if (clientes == null) {
            clientes = new ArrayList<>();
            session.setAttribute("clientes", clientes);
        }

    
        List<Produto> produtos = (List<Produto>) session.getAttribute("produtos");
        if (produtos == null) {
            produtos = new ArrayList<>();
            session.setAttribute("produtos", produtos);
        }

        response.sendRedirect("telavendas.jsp");
    }
}
