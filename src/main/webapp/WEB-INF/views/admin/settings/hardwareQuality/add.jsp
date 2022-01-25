<%--
  Created by IntelliJ IDEA.
  User: themos
  Date: 23/01/2022
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<title>New quality</title>
</html>



<div class="container-fluid px-4">
    <h1 class="mt-4"> Add new quality name:</h1>
    <ol class="breadcrumb mb-4">
    </ol>





<%--@elvariable id="user" type="pl.tm.hardwareinventory.model.Producer"--%>
<form:form method="post" modelAttribute="qualityType">
    <form:hidden path="id"/>
    <div>
        <label>Name</label>
        <form:input path="name" type="text"/>
        <form:errors path="name" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Description</label>
        <form:input path="description" type="text"/>
        <form:errors path="description" cssClass="errorForm" element="div"/>
    </div>
    <div><input value="save" type="submit"></div>


</form:form>

<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>