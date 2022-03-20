<%-- 
    Document   : insertProject
    Created on : Mar 20, 2022, 2:56:15 PM
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
    </head>
    <body>
        <a href="/Assignment/menu/project"><button>Go back</button></a>
        <form action="insert" method="POST">
            ProjectName:<input type="text" name="name"/><br/>
            <input type="submit" value="Insert"/>
            </form>
    </body>
</html>
