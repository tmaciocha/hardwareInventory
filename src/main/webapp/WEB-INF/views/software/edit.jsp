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
    <title>Edit Hardware </title>
</head>



<div class="container-fluid px-4">
    <h1 class="mt-4"> Edit software: ${software.name}, ${software.producer.name}</h1>
    <ol class="breadcrumb mb-4">
    </ol>


    <%--@elvariable id="user" type="pl.tm.hardwareinventory.model.Producer"--%>
    <form:form action="/software/edit" method="post" modelAttribute="software">
        <form:hidden path="id"/>
    <div>
        <label>Name</label>
        <form:input path="name" type="text"/>
        <form:errors path="name" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Company</label>
        <form:select path="company.id" itemValue="id" itemLabel="nipName" items="${companies}"/>  <a href="/company/add" target="_blank">... or add new</a>
        <form:errors path="name" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>User</label>
        <form:checkboxes path="users" itemValue="id" itemLabel="username" items="${users}" />  <a href="/user/add" target="_blank">... or add new</a>
        <form:errors path="users" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Hardware</label>
        <form:checkboxes path="hardwareList" itemValue="id" itemLabel="name" items="${hardwareList}" />  <a href="/hardware/add" target="_blank">... or add new</a>
        <form:errors path="hardwareList" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Description</label>
        <form:textarea path="description" type="text"/>
        <form:errors path="description" cssClass="errorForm" element="div"/>
    </div>



    <div><input value="save" type="submit"></div>


    </form:form>



<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>