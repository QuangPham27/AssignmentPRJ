<%-- 
    Document   : updateProject
    Created on : Mar 20, 2022, 4:13:29 PM
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
        <a href="/Assignment/menu/project"><button>Go back</button></a>
        <form action="update" method="POST">
            ProjectName:<input type="text" name="name" value="${requestScope.name}"/><br/>
            <input type="hidden" name="id" value="${requestScope.id}"/>
            <input type="submit" value="Update"/>
            </form>
    </body>
</html>
