<%-- 
    Document   : shoppingList
    Created on : 13-Oct-2021, 14:14:44
    Author     : BritishWaldo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>

        <p>Hello ${username}</p>
        <a href="ShoppingList?action=logout">Logout!</a>

        <form action="" method="post">
            <h2>Add item to shopping list:</h2>
            <label for="newItem">Item name:</label>
            <input type="text" name="newItem" id="newItem">
            <br>
            <input type="submit" value="Add Item">

            <input type="hidden" name="action" value="addItem">
        </form>

        <c:if test="${itemList.size() != null}" var="result">
            <form action="" method="post">
                <ul>
                    <c:forEach items="${itemList}" var="itemListing">
                        <c:out value=   "  <li>
                                            <input type='radio' name='itemToDelete' value='${itemListing}'>
                                            <label for='itemToDelete'>${itemListing}</label>
                                            </li>
                                        "
                                escapeXml = "false">
                            </c:out>
                        </c:forEach>
                    <br>
                    <input type="submit" value="Delete selected item">

                    <input type="hidden" name="action" value="deleteItem">
                </ul>
            </form>
        </c:if>
    </body>
</html>
