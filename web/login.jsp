<%-- 
    Document   : login
    Created on : Mar 20, 2022, 10:52:33 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/login.css" rel="stylesheet">
    </head>
    <body>
        <form action="login" method="POST">
            Username <input type="text" name="username"><br/>
            Password <input type="password" name="password"><br/>
            <input type="submit" value="Login"/>
        </form>
        ${requestScope.message}
    </body>
</html>
