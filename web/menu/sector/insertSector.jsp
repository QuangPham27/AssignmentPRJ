<%-- 
    Document   : insertSector
    Created on : Mar 20, 2022, 4:37:23 PM
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
        <link href="../css/input.css" rel="stylesheet">
    </head>
    <body>
        <a href="/Assignment/menu/sector"><button>Go back</button></a>
        <form action="insert" method="POST">
            SectorName:<input type="text" name="name"/><br/>
            Price:<input type="text" name="price"/><br/>
            ProjectName: <select name="pid">
                <c:forEach items="${requestScope.projects}" var="p">
                
                <option value="${p.id}">${p.name}</option>
                </c:forEach>
            </select>
            <br/>
            <input type="submit" value="Insert"/>
            </form>
    </body>
</html>
