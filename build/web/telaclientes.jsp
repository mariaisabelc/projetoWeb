<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clientes</title>
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
            width: calc(100% - 10px); 
            padding: 10px; 
            border: 1px solid #ccc; 
            border-radius: 3px; 
            box-sizing: border-box; 
        }
        input[type="submit"] {
            background-color: #4caf50; 
            color: white; 
            padding: 15px 20px; 
            border: none; 
            border-radius: 3px; 
            cursor: pointer; 
            font-size: 16px;
            transition: background-color 0.3s;  
        }
        input[type="submit"]:hover {
            background-color: #45a049; 
        }
        a {
            display: inline-block; 
            background-color: #4caf50; 
            color: white; 
            padding: 10px 20px; 
            text-decoration: none; 
            border-radius: 3px; 
            transition: background-color 0.3s;
        }
        a:hover {
            background-color: #45a049; 
        }
    </style>
</head>
<body>
     <h1>Clientes</h1>
    <form action="AdicionarClienteServlet" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required><br><br>
        
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" required><br><br>
        
        <label for="endereco">Endereço:</label>
        <input type="text" id="endereco" name="endereco" required><br><br>
        
        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone" required><br><br>
        
        <input type="submit" value="Adicionar">
    </form>
    <br>
    <a href="telainicial.jsp">Voltar</a>
</body>
</html>