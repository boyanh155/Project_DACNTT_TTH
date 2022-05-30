<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/member/ownhome.jsp">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/main.css">

</head>

<body>
        <%-- get cookie --%>        
        <c:forEach var="cookie" items="${cookie}">
            <c:if test = "${cookie.name == 'usernameCookie'}">
                <c:set var = "username" value = "${cookie.value}"/>
            </c:if>
            <c:if test = "${cookie.name == 'sessionIDCookie'}">
                <c:set var = "sessionID" value = "${cookie.value}"/>
            </c:if>
        </c:forEach>

        <%-- check exist cookie --%>
        <c:set var = "flagcU" value = "${false}"/>
        <c:if test = "${cookie.containsKey('usernameCookie')}">
            <c:out value="Sai gon dep lam em oi"/>
        </c:if>

        <%--  --%>
        <c:set var="sessionU" value="${sessionScope.username}"/>
            <%-- <h1>Halo <%= session.getAttribute("username") %> from Session</h1> --%>
        <c:choose>
            <c:when test="${flagcU}">
                <h1>Halo ${username} from Cookie <br/>
                Your sessionID is ${sessionID} from Cookie</h1>
                <br/>
                <h1>Your session Username is ${sessionU}</h1>
            </c:when>
            <c:otherwise>
                <h1>Halo my friend, Welcome. Go to shopping</h1> <br/>
                <a href="${pageContext.request.contextPath}/member/sign-in">shopping</a>
            </c:otherwise>
        </c:choose>
</h1>
</body>

</html>