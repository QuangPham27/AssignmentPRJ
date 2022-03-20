<%-- 
    Document   : updateLand2
    Created on : Mar 20, 2022, 7:09:20 PM
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
        <a href="/Assignment/menu/sector/update"><button>Go back</button></a>
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
                <option
                    ${(s.getId() eq requestScope.sid)?"selected=\"selected\"":""}
                    value="${s.id}">${s.name}</option>
                </c:forEach>
                </select>
            <br/>
            <input type="submit" value="Update"/>
            </form>
    </body>
</html>
