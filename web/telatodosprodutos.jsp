<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="projetointegrador.Produto" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Todos Produtos</title>
    <style>
        body {
            background-color: #ffc0cb;
            font-family: Arial, sans-serif;
            text-align: center;
            padding-top: 50px;
        }
        table {
            margin: 0 auto;
            border-collapse: collapse;
            width: 80%;
            background-color: #fff;
            border: 1px solid #000;
        }
        th, td {
            padding: 10px;
            border: 1px solid #000;
        }
    </style>
</head>
<body>
    <h1>Todos Produtos</h1>
    <table border="1">
        <tr>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th>Quantidade</th>
        </tr>
        <%
            List<Produto> produtos = (List<Produto>) session.getAttribute("produtos");
            if (produtos != null) {
                for (Produto produto : produtos) {
        %>
        <tr>
            <td><%= produto.getNomeProduto() %></td>
            <td><%= produto.getDescricao() %></td>
            <td><%= produto.getPreco() %></td>
            <td><%= produto.getQtEstoque() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <br>
    <a href="telainicial.jsp">Voltar</a>
</body>
</html>
