<%-- 
    Document   : insertLand2
    Created on : Mar 20, 2022, 6:23:06 PM
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
        <a href="/Assignment/menu/sector/insert"><button>Go back</button></a>
        <form action="insert2" method="POST">
            LandName:${requestScope.name}<input type="hidden" name="name" value="${requestScope.name}"/><br/>
            Acreage:${requestScope.acreage}<input type="hidden" name="acreage" value="${requestScope.acreage}"/><br/>
            ProjectName:${requestScope.pname} <select name="pid" hidden='hidden'>
                <c:forEach items="${requestScope.projects}" var="p">
                
                <option 
                    ${(p.getId() eq requestScope.pid)?"selected=\"selected\"":""}
                    value="${p.id}">${p.name}</option>
                </c:forEach>
            </select>
            <br/>
            SectorName: <select name="sid">
                <c:forEach items="${requestScope.sectors}" var="s">               
                <option value="${s.id}">${s.name}</option>
                </c:forEach>
                </select>
            <br/>
            <input type="submit" value="Insert"/>
            </form>
    </body>
</html>
