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
<title>New company</title>
</html>



<div class="container-fluid px-4">
    <h1 class="mt-4"> Add new company:</h1>
    <ol class="breadcrumb mb-4">
    </ol>





<%--@elvariable id="user" type="pl.tm.hardwareinventory.model.User"--%>
<form:form method="post" modelAttribute="company">
    <form:hidden path="id"/>
    <div>
        <label>NIP</label>
        <form:input path="nip" type="text"/>
        <form:errors path="nip" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Name</label>
        <form:input path="name" type="text"/>
        <form:errors path="name" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Street</label>
        <form:input path="street" type="text"/>
        <form:errors path="street" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Street number</label>
        <form:input path="streetNumber" type="text"/>
        <form:errors path="streetNumber" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>City</label>
        <form:input path="city" type="text"/>
        <form:errors path="city" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Post code</label>
        <form:input path="postCode" type="text"/>
        <form:errors path="postCode" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Description</label>
        <form:input path="description" type="text"/>
        <form:errors path="description" cssClass="errorForm" element="div"/>
    </div>



    <div><input value="save" type="submit"></div>


</form:form>

<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>