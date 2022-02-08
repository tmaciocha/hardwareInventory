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
    <h1 class="mt-4"> Edit task id: ${taskDto.id},
        <c:if test="${not empty taskDto.software.name}">        Software: ${taskDto.software.name},        </c:if>
        <c:if test="${not empty taskDto.hardware.name}">        Hardware: ${taskDto.hardware.name},        </c:if>
        <c:if test="${not empty taskDto.user.username}">        User: ${taskDto.user.username},        </c:if>
        </h1>
    <ol class="breadcrumb mb-4">
    </ol>



<form:form action="/task/edit" method="post" modelAttribute="taskDto">
        <form:hidden path="id"/>


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
        <label>Created: </label>${taskDto.logDate}
    </div>
    <div>
        <label>CLose date: </label>${taskDto.closeDate}
    </div>
    <div>
        Hardware Id: ${taskDto.hardware.id}
    </div>
    <div>
        Software Id: ${taskDto.software.id}
    </div>
    <div>
        User Id: ${taskDto.user.id}
    </div>

    <div><input type="submit" value="save"/></div>

</form:form>

<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>