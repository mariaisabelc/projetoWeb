<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="projetointegrador.Cliente" %>
<%@ page import="projetointegrador.Produto" %>
<%@ page import="projetointegrador.Venda" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vendas</title>
    <style>
        body {
            background-color: #ffc0cb; 
            font-family: Arial, sans-serif; 
            text-align: center; 
            padding-top: 50px; 
        }
        form {
            background-color: #fff; 
            width: 300px; 
            margin: 0 auto; 
            padding: 20px; 
            border-radius: 5px; 
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); 
        }
        label {
            display: block; 
            margin-bottom: 10px; 
            text-align: left; 
        }
        input[type="text"], select {
            width: calc(100% - 20px); 
            padding: 10px; 
            border: 1px solid #ccc; 
            border-radius: 3px; 
            box-sizing: border-box; 
        }
        button, input[type="submit"], a {
            display: inline-block;
            background-color: #4caf50; 
            color: white; 
            padding: 10px 20px; 
            text-decoration: none; 
            border: none; 
            border-radius: 3px; 
            cursor: pointer; 
            font-size: 16px;
            transition: background-color 0.3s;  
            margin-top: 10px;
        }
        button:hover, input[type="submit"]:hover, a:hover {
            background-color: #45a049; 
        }
    </style>
    <script>
        function calcularTotal() {
            var quantidade = document.getElementById('quantidade').value;
            var desconto = document.getElementById('porcentagemDesconto').value;
            var produtoSelect = document.getElementById('produtovenda');
            var valorProduto = parseFloat(produtoSelect.options[produtoSelect.selectedIndex].getAttribute('data-valor'));

            if (quantidade && valorProduto) {
                var valorTotal = quantidade * valorProduto;
                if (desconto) {
                    valorTotal -= (valorTotal * (desconto / 100));
                }
                document.getElementById('valorTotalVenda').value = valorTotal.toFixed(2);
            }
        }

        function concluirVenda() {
            var cliente = document.getElementById('clientevenda').value;
            var produto = document.getElementById('produtovenda').value;
            var quantidade = document.getElementById('quantidade').value;
            var desconto = document.getElementById('porcentagemDesconto').value;
            var valorTotal = document.getElementById('valorTotalVenda').value;

            
            window.location.href = "ConcluirVendaServlet?cliente=" + cliente + "&produto=" + produto + "&quantidade=" + quantidade + "&desconto=" + desconto + "&valorTotal=" + valorTotal;
        }
    </script>
</head>
<body>
    <h1>Vendas</h1>
    <form onsubmit="return false;">
        <label for="clientevenda">Cliente:</label>
        <select id="clientevenda">
            <%
                List<Cliente> clientes = (List<Cliente>) session.getAttribute("clientes");
                if (clientes != null) {
                    for (Cliente cliente : clientes) {
            %>
            <option value="<%= cliente.getNome() %>"><%= cliente.getNome() %></option>
            <%
                    }
                }
            %>
        </select>
        <label for="produtovenda">Produto:</label>
        <select id="produtovenda">
            <%
                List<Produto> produtos = (List<Produto>) session.getAttribute("produtos");
                if (produtos != null) {
                    for (Produto produto : produtos) {
            %>
            <option value="<%= produto.getNomeProduto() %>" data-valor="<%= produto.getPreco() %>"><%= produto.getNomeProduto() %></option>
            <%
                    }
                }
            %>
        </select>
        <label for="quantidade">Quantidade:</label>
        <input type="text" id="quantidade">
        <label for="porcentagemDesconto">Desconto:</label>
        <input type="text" id="porcentagemDesconto">
        <button type="button" onclick="calcularTotal()">Calcular</button>
        <label for="valorTotalVenda">Valor Total:</label>
        <input type="text" id="valorTotalVenda" readonly>
        <button type="button" onclick="concluirVenda()">Concluir</button>
    </form>
</body>
</html>
