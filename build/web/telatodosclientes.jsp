<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Todos Clientes</title>
</head>
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
     
    </style>
<body>
    <h1>Todos Clientes</h1>
    <table border="1">
        <tr>
            <th>Nome</th>
            <th>CPF</th>
            <th>Endereço</th>
            <th>Telefone</th>
        </tr>
        <% if (request.getAttribute("cliente") != null) { %>
            <% Cliente cliente = (Cliente) request.getAttribute("cliente"); %>
            <tr>
                <td><%= cliente.getNome() %></td>
                <td><%= cliente.getCpf() %></td>
                <td><%= cliente.getEndereco() %></td>
                <td><%= cliente.getTelefone() %></td>
            </tr>
        <% } %>
    </table>
    <br>
    <a href="telainicial.jsp">Voltar</a>
</body>
</html>