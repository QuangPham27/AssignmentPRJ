<%-- 
    Document   : sector
    Created on : Mar 20, 2022, 4:37:13 PM
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
    <script>           
            function deleteSector(id)
            {
                var result = confirm("Are you sure? You will also delete all lands in this Sector!");
                if(result)
                {
                    window.location.href = '/Assignment/menu/sector/delete?id=' + id;
                }
            }
        </script>
    <body>
        <a href="/Assignment/menu"><button>Go back</button></a>
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>SectorName</td>
                <td>ProjectName</td>
                <td>Price</td>
            </tr>
            <c:forEach items="${requestScope.sectors}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.pname}</td>
                <td>${s.price}</td>
                <td>
                    <a href="/Assignment/menu/sector/update?id=${s.id}">Update</a>
                    <a href="#" onclick="deleteSector(${s.id})"> Delete</a>                    
                </td>
            </tr>
            </c:forEach>
        </table>
        <a href="/Assignment/menu/sector/insert"><button>Insert</button></a>
    </body>
</html>
