<%-- 
    Document   : order
    Created on : Mar 20, 2022, 8:39:51 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/tablepage.css" rel="stylesheet">
    </head>
    <body>
        <a href="/Assignment/menu"><button>Go back</button></a>
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>LandID</td>
                <td>Date</td>
                <td>StartPrice</td>
                <td>EndPrice</td>
                <td>Income</td>
            </tr>
            <c:forEach items="${requestScope.orders}" var="o">
            <tr>
                <td>${o.id}</td>
                <td>${o.lid}</td>
                <td>${o.date}</td>
                <td>${o.startPrice}</td>
                <td>${o.endPrice}</td>
                <td>${o.income}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
