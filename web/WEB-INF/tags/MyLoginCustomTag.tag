<%-- 
    Document   : MyLoginCustomTag
    Created on : Oct 11, 2018, 12:54:06 PM
    Author     : 672762
--%>

<%@tag description="provides the log in information for this site" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>

        <form action="login" method="post">
            Username: <input type="text" value="${username}" name="username"> <br>
            Password: <input type="password" value="${password}" name="password"> <br>

            <input type="submit" value="login"> <br>
            <input type="checkbox" name="remeberMe" value="${rememberMe}">Remember me?<br>

            
        </form>