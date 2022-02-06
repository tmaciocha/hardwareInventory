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
<title>New task</title>
</html>



<div class="container-fluid px-4">
    <h1 class="mt-4"> Add new task:</h1>
    <ol class="breadcrumb mb-4">
    </ol>



<form:form method="post" modelAttribute="task">
    <form:hidden path="id"/>

    SELECT:
    <div>
        <label>hardware</label><br/>
        <form:checkboxes path="hardware.id" items="${hardware}"  itemLabel="name" itemValue="id" />
    </div><hr>
    <div>
        <label>software</label><br/>
        <form:checkboxes path="software.id" items="${software}"   itemLabel="name" itemValue="id" />
    </div><hr>
    <div>
        <label>SOFTWARE !!!</label><br/>
        <%--<form:checkboxes path="software5" items="${software5}"   itemLabel="name" itemValue="id" />--%>
        ${software5.get().name}
        <hr>
    </div>
    <div>
        <label>user</label><br/>
        <form:checkboxes path="user" items="${users}"  itemLabel="username" itemValue="id" />
    </div>



<%--
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
    <div>
        <label>filename</label>
        <form:input path="filename" type="text"/>
        <form:errors path="filename" cssClass="errorForm" element="div"/>
    </div>

    <p>&lt;%&ndash;@declare id="image"&ndash;%&gt;<label for="image">Choose Invoice Image</label></p>
    <p><input name="file" id="fileToUpload" type="file" /></p>
    <p><input type="submit" value="Upload"></p>--%>

    <div><input value="save" type="submit"></div>


</form:form>

<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>