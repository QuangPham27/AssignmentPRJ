<%-- 
    Document   : list
    Created on : Mar 20, 2022, 11:10:17 AM
    Author     : admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Land"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>SectorName</td>
                <td>ProjectName</td>
                <td>Acreage(m2)</td>
                <td>Price(mil/m2)</td>
                <td>TotalPrice(mil)</td>
                <td></td>
            </tr>
            <c:forEach items="${requestScope.lands}" var="l">
            <tr>
                <td>${l.id}</td>
                <td>${l.name}</td>
                <td>${l.sname}</td>
                <td>${l.pname}</td>
                <td>${l.acreage} m2</td>
                <td>${l.price} mil/m2</td>
                <td>${l.acreage*l.price} mil</td>
                <td>
                    <a href="land/update?id=${l.id}">Update</a>
                    <a href="#" onclick="deletePatient(${l.id})"> Delete</a>                    
                </td>
            </tr>
            </c:forEach>
        </table>
        <a href="land/insert"><button>Insert</button></a>
    </body>
</html>
