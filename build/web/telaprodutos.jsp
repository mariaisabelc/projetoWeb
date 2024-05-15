<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Produtos</title>
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
        input[type="text"] {
            width: calc(100% - 20px); 
            padding: 10px; 
            border: 1px solid #ccc; 
            border-radius: 3px; 
            box-sizing: border-box; 
        }
        input[type="submit"], a {
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
        input[type="submit"]:hover, a:hover {
            background-color: #45a049; 
        }
    </style>
</head>
<body>
    <h1>Produtos</h1>
    <form action="AdicionarProdutoServlet" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>
        <label for="descricao">Descrição:</label>
        <input type="text" id="descricao" name="descricao" required>
        <label for="valor">Valor:</label>
        <input type="text" id="valor" name="valor" required>
        <label for="quantidade">Quantidade:</label>
        <input type="text" id="quantidade" name="quantidade" required>
        <input type="submit" value="Adicionar">
    </form>
    <a href="telainicial.jsp">Voltar</a>
</body>
</html>
