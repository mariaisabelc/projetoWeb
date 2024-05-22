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

@WebServlet("/AdicionarClienteServlet")
public class AdicionarClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");

        Cliente cliente = new Cliente(nome, cpf, endereco, telefone);

        HttpSession session = request.getSession();
        List<Cliente> clientes = (List<Cliente>) session.getAttribute("clientes");

        if (clientes == null) {
            clientes = new ArrayList<>();
        }

        clientes.add(cliente);
        session.setAttribute("clientes", clientes);

        request.getRequestDispatcher("telatodosclientes.jsp").forward(request, response);
    }
}