<!DOCTYPE html>
<html>
<head>
    <title>Tela Inicial</title>
    <style>
        body {
            background-color: pink;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            height: 100vh;
            margin: 0;
        }
        
        h1 {
            margin-top: 50px;
        }
        
        ul {
            list-style-type: none;
            padding: 0;
            text-align: center;
        }
        
        li {
            margin: 10px;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        
        li a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }
    </style>
</head>
<body>
    <h1>Tela Inicial</h1>
    <ul>
        <li><a href="telacaixa.jsp">Caixa</a></li>
        <li><a href="telavendas.jsp">Vendas</a></li>
        <li><a href="telaprodutos.jsp">Produtos</a></li>
        <li><a href="telaclientes.jsp">Clientes</a></li>
        <li><a href="telatodosprodutos.jsp">Estoque</a></li>
    </ul>
</body>
</html>
