<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page contentType="text/html;charset=UTF-8"%> --%>
<!DOCTYPE html>
<html lang="en">

<head>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>K19 Welcome page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/grid.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/common/footer.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" 
    integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer"/>

</head>

<body>
<c:set var="num" value="19"/>
    <h1>Hello From K${num} Team </h1>
    <h3>(Thai Hung and Hoang Loc)'s Team</h3>
    <button> 
        <a href="${pageContext.request.contextPath}/sign-up">
            <span>Register</span>
        </a>
    </button>

    <c:import url="/WEB-INF/views/common/footer.jsp" />
    <%-- <c:import url="./views/common/footer.jsp" /> --%>
    <%-- <jsp:include page="/WEB-INF/views/common/footer.jsp" /> --%>

</body>

</html>