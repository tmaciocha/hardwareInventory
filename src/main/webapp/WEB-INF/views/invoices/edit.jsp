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
<title>Edit invoice</title>
</html>



<div class="container-fluid px-4">
    <h1 class="mt-4"> Edit invoice:</h1>
    <ol class="breadcrumb mb-4">
    </ol>





<%--@elvariable id="user" type="pl.tm.hardwareinventory.model.Invoice"--%>
<form:form action="/invoice/edit" method="post" modelAttribute="invoice">
    <form:hidden path="id"/>
    <div>
        <label>Number</label>
        <form:input path="number" type="text"/>
        <form:errors path="number" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Purchase date</label>
        <form:input path="purchaseDate" type="date"/>
        <form:errors path="purchaseDate" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Seller</label>
        <form:select path="company.id" items="${sellers}" itemLabel="nipName" itemValue="id"/>
        <form:errors path="company" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Description</label>
        <form:textarea path="description" type="text"/>
        <form:errors path="description" cssClass="errorForm" element="div"/>
    </div>



    <div><input value="save" type="submit"></div>


</form:form>

<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>