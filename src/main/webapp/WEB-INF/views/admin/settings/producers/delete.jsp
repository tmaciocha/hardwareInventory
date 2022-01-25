<%--
  Created by IntelliJ IDEA.
  User: themos
  Date: 23/01/2022
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<head>
    <title>Remove Producer</title>
</head>

<div class="container-fluid px-4">
    <h1 class="mt-4"> confirm deleting producer ${producerId}:</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item active"></li>
    </ol>

<form:form method="get" modelAttribute="producerId" action="/producer/delete/${producerId}" >
   <div><h4> Are you sure ? </h4></div>
    <div>
        <a href="/producer/delete/${producerId}"><button type="submit" value="Yes" name="confirm">Yes</button></a>

        <a href="/producer/"><button type="submit" value="No" name="confirm">No</button></a>
    </div>



</form:form>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>