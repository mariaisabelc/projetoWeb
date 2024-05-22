<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="projetointegrador.Cliente" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Todos Clientes</title>
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
            padding: 8px 12px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h1>Todos Clientes</h1>
    <table border="1">
        <tr>
            <th>Nome</th>
            <th>CPF</th>
            <th>Endereço</th>
            <th>Telefone</th>
        </tr>
        <%
            List<Cliente> clientes = (List<Cliente>) session.getAttribute("clientes");
            if (clientes != null) {
                for (Cliente cliente : clientes) {
        %>
        <tr>
            <td><%= cliente.getNome() %></td>
            <td><%= cliente.getCpf() %></td>
            <td><%= cliente.getEndereco() %></td>
            <td><%= cliente.getTelefone() %></td>
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
