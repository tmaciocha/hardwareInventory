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
<title>New invoice</title>
</html>



<div class="container-fluid px-4">
    <h1 class="mt-4"> Add new invoice:</h1>
    <ol class="breadcrumb mb-4">
    </ol>



<%--@elvariable id="user" type="pl.tm.hardwareinventory.model.User"--%>
<form:form method="post" modelAttribute="invoice" enctype="multipart/form-data"  action="/invoice/savefile/${invoice.id}" >
    <form:hidden path="id"/>

    <div>
        <label>seller</label>
        <form:select path="company.id" items="${companies}"  itemLabel="nipName" itemValue="id" />
        <a href="/company/add" target="_blank">If doesn't exist add new</a>
        <form:errors path="company" cssClass="errorForm" element="div"/>
    </div>


    <div>
        <label>number</label>
        <form:input path="number" type="text"/>
        <form:errors path="number" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>purchase date</label>
        <form:input path="purchaseDate" type="date"/>
        <form:errors path="purchaseDate" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>net value</label>
        <form:input path="netValue"/>
        <form:errors path="netValue" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>description</label>
        <form:textarea path="description" type="text"/>
        <form:errors path="description" cssClass="errorForm" element="div"/>
    </div>


    <p><%--@declare id="image"--%><label for="image">Choose invoice file:</label>
        <input name="file" id="fileToUpload" type="file" /></p>

    <div><input value="save" type="submit"></div>


</form:form>

<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>