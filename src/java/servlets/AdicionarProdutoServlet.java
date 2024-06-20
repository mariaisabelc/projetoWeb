package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetointegrador.Produto;
import projetointegrador.ProdutoBD;

@WebServlet("/AdicionarProdutoServlet")
public class AdicionarProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeProduto = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        double valor = Double.parseDouble(request.getParameter("valor"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        Produto produto = new Produto(nomeProduto, descricao, valor, quantidade);

        try {
            ProdutoBD.saveProduto(produto);
        } catch (SQLException e) {
            throw new ServletException("Erro ao salvar produto no banco de dados", e);
        }

        HttpSession session = request.getSession();
        List<Produto> produtos = (List<Produto>) session.getAttribute("produtos");

        if (produtos == null) {
            produtos = new ArrayList<>();
        }

        produtos.add(produto);
        session.setAttribute("produtos", produtos);

        request.getRequestDispatcher("telatodosprodutos.jsp").forward(request, response);
    }
}
