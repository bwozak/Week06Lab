<%-- 
    Document   : login
    Created on : Oct 11, 2018, 12:49:28 PM
    Author     : 672762
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="login" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Remember Me Log In Page</h1>

        <div>{$message}</div>
        
        <MyLoginCustomTag:login></MyLoginCustomTag:login>
        
    </body>
</html>
