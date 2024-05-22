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
import projetointegrador.Venda;

@WebServlet("/ConcluirVendaServlet")
public class ConcluirVendaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<Cliente> clientes = (List<Cliente>) session.getAttribute("clientes");
        List<Produto> produtos = (List<Produto>) session.getAttribute("produtos");

        if (clientes == null || produtos == null) {
            response.getWriter().println("Erro: Listas de clientes ou produtos não encontradas.");
            return;
        }

        String clienteNome = request.getParameter("cliente");
        String produtoNome = request.getParameter("produto");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        double desconto = Double.parseDouble(request.getParameter("desconto"));
        double valorTotal = Double.parseDouble(request.getParameter("valorTotal"));

        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getNome().equals(clienteNome)) {
                cliente = c;
                break;
            }
        }

        Produto produto = null;
        for (Produto p : produtos) {
            if (p.getNomeProduto().equals(produtoNome)) {
                produto = p;
                break;
            }
        }

        if (cliente != null && produto != null) {
            double valorTotalComDesconto = valorTotal;
            Venda venda = new Venda(cliente);
            venda.adicionarProduto(produto, quantidade, valorTotalComDesconto); 

            List<Venda> vendas = (List<Venda>) session.getAttribute("vendas");
            if (vendas == null) {
                vendas = new ArrayList<>();
                session.setAttribute("vendas", vendas);
            }
            vendas.add(venda);

            session.setAttribute("vendas", vendas);

            // Atualiza a lista de produtos na sessão
            session.setAttribute("produtos", produtos);

            response.sendRedirect("telacaixa.jsp");
        } else {
            response.getWriter().println("Erro: Cliente ou produto não encontrado.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
