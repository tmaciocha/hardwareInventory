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
    <h1 class="mt-4"> Edit hardware:${hardware.serialNumber} ${hardware.name}</h1>
    <ol class="breadcrumb mb-4">
    </ol>





    <%--@elvariable id="user" type="pl.tm.hardwareinventory.model.Producer"--%>
    <form:form action="/hardware/edit" method="post" modelAttribute="hardware">
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
        <form:select path="user.id" itemValue="id" itemLabel="username" items="${users}"/>  <a href="/user/add" target="_blank">... or add new</a>
        <form:errors path="user" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Description</label>
        <form:input path="description" type="text"/>
        <form:errors path="description" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Quality</label>
        <form:select path="hardwareQuality.id" items="${hardwareQualities}" itemLabel="name" itemValue="id"/>
        <form:errors path="hardwareQuality" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>MAC</label>
        <form:input path="macNumber" type="text"/>
        <form:errors path="macNumber" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Battery Quality</label>
        <form:input path="batteryQuality" type="text"/>
        <form:errors path="batteryQuality" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>RAM (GB)</label>
        <form:input path="ramAmount" type="number"/>
        <form:errors path="ramAmount" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Disk Size (GM)</label>
        <form:input path="discSize" type="text"/>
        <form:errors path="discSize" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Disk Type</label>
        <form:input path="discType" type="text"/>
        <form:errors path="discType" cssClass="errorForm" element="div"/>
    </div>

    <div><input value="save" type="submit"></div>


    </form:form>



<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>