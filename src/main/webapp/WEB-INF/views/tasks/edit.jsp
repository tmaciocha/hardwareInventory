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
<title>Edit Task</title>
</html>



<div class="container-fluid px-4">
    <h1 class="mt-4"> Edit task id: ${task.id},
        <c:if test="${not empty task.software.name}">        Software: ${task.software.name},        </c:if>
        <c:if test="${not empty task.hardware.name}">        Hardware: ${task.hardware.name},        </c:if>
        <c:if test="${not empty task.user.username}">        User: ${task.user.username},        </c:if>
        </h1>
    <ol class="breadcrumb mb-4">
    </ol>



<form:form action="/task/edit" method="post" modelAttribute="task">
        <form:hidden path="id"/>
        <form:hidden path="hardware.id"/>
        <form:hidden path="software.id"/>
        <form:hidden path="user.id"/>
    <div>
        <label>Is done? </label>
        <form:checkbox path="status"/>
    </div>
    <div>
        <label>Title</label>
        <form:input path="title" type="text"/>
        <form:errors path="title" cssClass="errorForm"/>
    </div>

    <div>
        <label>Description</label>
        <form:textarea path="description" type="text"/>
        <form:errors path="description" cssClass="errorForm"/>
    </div>
    <div>
        <label>Priority (1-5)</label>
        <form:input path="priority" type="number"/>
        <form:errors path="priority" cssClass="errorForm"/>
    </div>
    <div>
        <label>Created: </label>${task.logDate}
    </div>
    <div><input type="submit" value="save"/></div>

</form:form>

<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>