<%-- 
    Document   : updateLand
    Created on : Mar 20, 2022, 5:41:03 PM
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
        <a href="/Assignment/menu/land"><button>Go back</button></a>
        <form action="update" method="POST">
            LandName:<input type="text" name="name" value="${requestScope.name}"/><br/>
            Acreage:<input type="text" name="acreage" value="${requestScope.acreage}"/><br/>
            ProjectName:<select name="pid" >
                <c:forEach items="${requestScope.projects}" var="p">
                
                <option 
                    ${(p.getId() eq requestScope.pid)?"selected=\"selected\"":""}
                    value="${p.id}">${p.name}</option>
                </c:forEach>
            </select>
            <br/>
            <input type="submit" value="Next"/>
            <input type="hidden" name="id" value="${requestScope.id}"/>
            </form>
    </body>
</html>
