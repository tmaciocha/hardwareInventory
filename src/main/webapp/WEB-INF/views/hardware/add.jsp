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
    <title>New Hardware</title>
</head>



<div class="container-fluid px-4">
    <h1 class="mt-4"> Add new hardware:</h1>
    <ol class="breadcrumb mb-4">
    </ol>

    <%--@elvariable id="user" type="pl.tm.hardwareinventory.model.Producer"--%>
    <form:form method="post" modelAttribute="hardware">
        <form:hidden path="id"/>


    <div>
        <label>Serial Number</label>
        <form:input path="serialNumber" type="text"/>
        <form:errors path="serialNumber" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Name</label>
        <form:input path="name" type="text"/>
        <form:errors path="name" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Producer</label>
        <form:select path="producer.id" items="${producers}" itemValue="id" itemLabel="name"/>
        <a href="/producer/add" target="_blank">... or add new</a>
        <form:errors path="producer" cssClass="errorForm" element="div"/>
    </div>


    <div>
        <label>Type</label>
        <form:select path="hardwareType.id" items="${hardwareTypes}" itemValue="id" itemLabel="type"/>
        <a href="/hardwareType/add" target="_blank">... or add new</a>
        <form:errors path="hardwareType" cssClass="errorForm" element="div"/>
    </div>


    <div>
        <label>Owner (company)</label>
        <form:select path="company.id" items="${companies}" itemValue="id" itemLabel="name"/>
        <a href="/company/add" target="_blank">... or add new</a>
        <form:errors path="company" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>User</label>
        <form:select path="user.id" items="${users}" itemValue="id" itemLabel="username"/>
        <a href="/user/add" target="_blank">... or add new</a>
        <form:errors path="user" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Invoice</label>
        <form:select path="invoice.id" items="${invoices}" itemValue="id" itemLabel="NumberCompanyDateDescription"/>
        <a href="/invoice/add" target="_blank">... or add new</a>
        <form:errors path="invoice" cssClass="errorForm" element="div"/>
    </div>


    <div>
        <label>Description</label>
        <form:textarea path="description" type="text"/>
        <form:errors path="description" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Production Date</label>
        <form:input path="productionDate" type="date"/>
        <form:errors path="productionDate" cssClass="errorForm" element="div" />
    </div>
    <div>
        <label>Quality</label>
        <form:select path="hardwareQuality.id"  items="${qualities}" itemLabel="name" itemValue="id" />
        <form:errors path="hardwareQuality" cssClass="errorForm" element="div" />
    </div>


    <div>
        <label>MAC number</label>
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
        <label>Screen Size (inches)</label>
        <form:input path="screenSize" type="number"/>
        <form:errors path="screenSize" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Disk Size (GB)</label>
        <form:input path="discSize" type="number"/>
        <form:errors path="discSize" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Disk Type</label>
        <form:input path="discType" type="text"/>
        <form:errors path="discType" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Net Price </label>
        <form:input path="netPrice" />
        <form:errors path="netPrice" cssClass="errorForm" element="div"/>
    </div>


    <div><input value="save" type="submit"></div>


    </form:form>



<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>