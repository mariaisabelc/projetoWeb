package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import projetointegrador.Usuario;
import projetointegrador.UsuarioBD;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("username");
        String senha = request.getParameter("password");

        System.out.println("Recebido login: " + login);
        System.out.println("Recebido senha: " + senha);

        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);

        Usuario usuarioEncontrado = UsuarioBD.validarUsuario(usuario);

        if (usuarioEncontrado != null) {
            System.out.println("Usuário autenticado com sucesso: " + usuarioEncontrado.getLogin());
            response.sendRedirect("telainicial.jsp");
        } else {
            System.out.println("Falha na autenticação do usuário.");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('Login ou senha inválidos!'); window.location = 'index.html';</script>");
        }
    }
}
