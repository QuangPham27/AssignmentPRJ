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
        <link href="css/tablepage.css" rel="stylesheet">
    </head>
    <script src="js/pagger.js" type="text/javascript"></script>
    <link href="css/pagger.css" rel="stylesheet" type="text/css"/>
    <script>           
            function deleteLand(id)
            {
                var result = confirm("Are you sure?");
                if(result)
                {
                    window.location.href = '/Assignment/menu/land/delete?id=' + id;
                }
            }
        </script>
    <body>
        <a href="/Assignment/menu"><button>Go back</button></a>
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
                    <a href="/Assignment/menu/land/update?id=${l.id}">Update</a>
                    <a href="#" onclick="deleteLand(${l.id})"> Delete</a>   
                    <a href="/Assignment/menu/orders/insert?id=${l.id}">Sell</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <div id="paggerbot" class="pagger"> </div>
        <script> 
            pagger("paggerbot",${requestScope.pageindex},${requestScope.totalpage},2,"land");
        </script>
        <a href="/Assignment/menu/land/insert"><button>Insert</button></a>
    </body>
</html>
