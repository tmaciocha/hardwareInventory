<%--
  Created by IntelliJ IDEA.
  User: themos
  Date: 23/01/2022
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="container-fluid px-4">
    <ol class="breadcrumb mb-4">
    </ol>



<html>
<head>
    <title>Logout</title>
</head>
<body>

<sec:authorize access="isAuthenticated()">
<form action="<c:url value="/logout"/>" method="post">
    <input class="fa fa-id-badge" type="submit" value="Wyloguj">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
    MAM ROLE ADMIN
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <p>Zalogowany jako: <sec:authentication property="principal.username"/></p>
    <p>Posiada role: <sec:authentication property="authorities"/></p>
</sec:authorize>

<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>