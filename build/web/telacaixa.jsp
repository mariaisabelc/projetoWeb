<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <th>Venda</th>
                <th>Valor</th>
                <th>Saldo</th>
            </tr>
        </thead>
        <tbody>
         
            <%-- <tr> --%>
            <%--     <td>Valor dinâmico</td> --%>
            <%--     <td>Valor dinâmico</td> --%>
            <%--     <td>Valor dinâmico</td> --%>
            <%--     <td>Valor dinâmico</td> --%>
            <%-- </tr> --%>
        </tbody>
    </table>
    <form action="telainicial.jsp">
        <button type="submit">Voltar</button>
    </form>
</body>
</html>
