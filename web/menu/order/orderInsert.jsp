<%-- 
    Document   : orderInsert
    Created on : Mar 20, 2022, 8:49:46 PM
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
        <form action="insert" method="POST">
            LandID:${requestScope.land.id}<input type="hidden" name="lid" value="${requestScope.land.id}"/><br/>
            StartPrice:${requestScope.land.acreage*requestScope.land.price} mil
            <input type="hidden" name="startprice" value="${requestScope.land.acreage*requestScope.land.price}"/><br/>
            EndPrice:<input type="text" name="endprice"/>
            <input type="submit" value="Sell"/>
            </form>
    </body>
</html>
