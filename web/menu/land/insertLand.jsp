<%-- 
    Document   : insertLand
    Created on : Mar 20, 2022, 1:00:06 PM
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>
    <body>
        <a href="/Assignment/menu/sector"><button>Go back</button></a>
        <form action="insert" method="POST">
            LandName:<input type="text" name="name"/><br/>
            Acreage:<input type="text" name="acreage"/><br/>
            ProjectName: <select name="pid">
                <c:forEach items="${requestScope.projects}" var="p">
                
                <option value="${p.id}">${p.name}</option>
                </c:forEach>
            </select>
            <br/>
            <input type="submit" value="Next"/>
            </form>
    </body>
</html>
