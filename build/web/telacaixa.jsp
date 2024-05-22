<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="projetointegrador.Venda" %>

<!DOCTYPE html>
<html>
<head>
    <title>Caixa</title>
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
        th {
            background-color: #f2f2f2; 
        }
    </style>
</head>
<body>
    <h1>Caixa</h1>
    <table>
        <thead>
            <tr>
                <th>Data</th>
                <th>Cliente</th>
                <th>Valor Total</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Venda> vendas = (List<Venda>) session.getAttribute("vendas");
                if (vendas != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    for (Venda venda : vendas) {
            %>
            <tr>
                <td><%= sdf.format(venda.getData()) %></td>
                <td><%= venda.getCliente().getNome() %></td>
                <td><%= venda.calcularValorTotal() %></td>
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
    <form action="telainicial.jsp">
        <button type="submit">Voltar</button>
    </form>
</body>
</html>
