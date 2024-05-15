<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body {
            background-color: #ffc0cb;
            font-family: Arial, sans-serif; 
            text-align: center; 
            padding-top: 50px; 
        }
        h1 {
            color: #333; 
        }
        form {
            background-color: #fff; 
            border-radius: 5px; 
            padding: 20px;
            display: inline-block;
        }
        label {
            display: block;
            margin-bottom: 10px; 
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
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
    </style>
</head>
<body>
    <h1>Login</h1>
    <form action="TelaLogin" method="post" onsubmit="return redirecionarParaTelaInicial()">
        <label for="username">Usuário:</label>
        <input type="text" id="username" name="username"><br><br>
        <label for="password">Senha:</label>
        <input type="password" id="password" name="password"><br><br>
        <input type="submit" value="Entrar">
    </form>

    <script>
        function redirecionarParaTelaInicial() {
            window.location.href = "telainicial.jsp";
            return false; 
        }
    </script>
</body>
</html>
