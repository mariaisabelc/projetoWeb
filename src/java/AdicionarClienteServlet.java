import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import projetointegrador.Cliente;


@WebServlet("/AdicionarClienteServlet")

public class AdicionarClienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");

        Cliente cliente = new Cliente(nome, cpf, endereco, telefone);

        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("telatodosclientes.jsp").forward(request, response);
    }
    
}