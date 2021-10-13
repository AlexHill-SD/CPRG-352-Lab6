<%-- 
    Document   : register
    Created on : 13-Oct-2021, 14:14:34
    Author     : BritishWaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="POST">
            <label for="username">Username:</label>
            <input type="text" name="username" id="username" value="">
            <br>
            <input type="submit" value="Register">

            <input type="hidden" name="action" value="register">
        </form>
            
            <p>
                ${error_message}
            </p>
    </body>
</html>
