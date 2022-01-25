<%--
  Created by IntelliJ IDEA.
  User: themos
  Date: 24/01/2022
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Edit Software Type </title>
</head>



<div class="container-fluid px-4">
    <h1 class="mt-4"> Edit software type:${softwaretype.type}</h1>
    <ol class="breadcrumb mb-4">
    </ol>





    <%--@elvariable id="user" type="pl.tm.hardwareinventory.model.Producer"--%>
    <form:form action="/softwaretype/edit" method="post" modelAttribute="softwaretype">
        <form:hidden path="id"/>
    <div>
        <label>Type</label>
        <form:input path="type" type="text"/>
        <form:errors path="type" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Description</label>
        <form:input path="description" type="text"/>
        <form:errors path="description" cssClass="errorForm" element="div"/>
    </div>
    <div><input value="save" type="submit"></div>


    </form:form>



<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>