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
</head>
<body>
    <h1>Vendas</h1>
    <form>
        <label for="clientevenda">Cliente:</label>
        <select id="clientevenda">
        </select>
        <label for="produtovenda">Produto:</label>
        <select id="produtovenda">
        </select>
        <label for="quantidade">Quantidade:</label>
        <input type="text" id="quantidade">
        <button id="botaoAddProduto" type="button">Adicionar Produto</button>
        <ul id="listaProdutosVenda"></ul>
        <label for="porcentagemDesconto">Desconto:</label>
        <input type="text" id="porcentagemDesconto">
        <button id="botaoCalcular" type="button">Calcular</button>
        <label for="valorTotalVenda">Valor Total:</label>
        <input type="text" id="valorTotalVenda">
        <button id="botaoConfirmar" type="button">Confirmar</button>
    </form>
</body>
</html>
