<%-- 
    Document   : project
    Created on : Mar 20, 2022, 2:33:49 PM
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
    <script src="js/pagger.js" type="text/javascript"></script>
    <link href="css/pagger.css" rel="stylesheet" type="text/css"/>
    <script>           
            function deleteProject(id)
            {
                var result = confirm("Are you sure? You will also delete all lands and sectors in this Project!");
                if(result)
                {
                    window.location.href = '/Assignment/menu/project/delete?id=' + id;
                }
            }
        </script>
    <body>
        <a href="/Assignment/menu"><button>Go back</button></a>
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>ProjectName</td>
                <td></td>
            </tr>
            <c:forEach items="${requestScope.projects}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>
                    <a href="/Assignment/menu/project/update?id=${p.id}">Update</a>
                    <a href="#" onclick="deleteProject(${p.id})"> Delete</a>                    
                </td>
            </tr>
            </c:forEach>
        </table>
        <div id="paggerbot" class="pagger"> </div>
        <script> 
            pagger("paggerbot",${requestScope.pageindex},${requestScope.totalpage},2,"project");
        </script>
        <a href="/Assignment/menu/project/insert"><button>Insert</button></a>
    </body>
</html>
