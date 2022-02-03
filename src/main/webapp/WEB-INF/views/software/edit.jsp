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
        <label>Type of license</label>
        <form:select path="softwareType.id" items="${softwareTypes}" itemValue="id" itemLabel="type"/>
        <form:errors path="softwareType" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Producer</label>
        <form:select path="producer.id" items="${producers}" itemValue="id" itemLabel="name"/>
        <a href="/producer/add" target="_blank">... or add new</a>
        <form:errors path="producer" cssClass="errorForm" element="div"/>
    </div>


    <div>
        <label>Version</label>
        <form:input path="version" type="text"/>
        <form:errors path="version" cssClass="errorForm" element="div" />
    </div>

    <div>
        <label>Producer web page</label>
        <form:input path="homePage" type="text"/>
        <form:errors path="homePage" cssClass="errorForm" element="div" />
    </div>


    <div>
        <label>Serial key</label>
        <form:input path="serialKey" type="text"/>
        <form:errors path="serialKey" cssClass="errorForm" element="div" />
    </div>
    <div>
        <label>User</label>
        <form:checkboxes path="users" items="${users}" itemValue="id" itemLabel="username" multiple="true"/>
        <a href="/user/add" target="_blank">... or add new</a>
        <form:errors path="users" cssClass="errorForm"/>
    </div>
    <div>
        <label>Hardware List</label>
        <form:checkboxes path="hardwareList" items="${hardwareList}" itemValue="id" itemLabel="name" multiple="true"    />
        <a href="/hardware/add" target="_blank">... or add new</a>
        <form:errors path="hardwareList" cssClass="errorForm" />
    </div>

    <div>
        <label>Owner (company)</label>
        <form:select path="company.id" items="${companies}" itemValue="id" itemLabel="name"/>
        <a href="/company/add" target="_blank">... or add new</a>
        <form:errors path="company" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Invoice</label>
        <form:select path="invoice.id" items="${invoices}" itemValue="id" itemLabel="NumberCompanyDateDescription"/>
        <a href="/invoice/add" target="_blank">... or add new</a>
        <form:errors path="invoice" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Net Price </label>
        <form:input path="netPrice"/>
        <form:errors path="netPrice" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Manual </label>
        <form:input path="manual" type="text"/>
        <form:errors path="manual" cssClass="errorForm" element="div"/>
    </div>


    <div>
        <label>Description</label>
        <form:textarea path="description" type="text"/>
        <form:errors path="description" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Active up to day...</label>
        <form:input path="activeUpTo" type="date"/>
        <form:errors path="activeUpTo" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Active</label>
        <form:checkbox path="active"/>
    </div>

    <div><input value="save" type="submit"></div>



    </form:form>



<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>