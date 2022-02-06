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
    <h1 class="mt-4"> Add task for
        </br>${software.get().name} ${software.get().version}, serial: ${software.get().serialKey}</h1>
    <ol class="breadcrumb mb-4">
    </ol>


    Software id: ${software.get().id}
    <form:form method="post" modelAttribute="task" action="/task/add/software/${software.get().id}">
        <form:hidden path="id"/>

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


    <div><input value="save" type="submit"></div>


    </form:form>
</div>

<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>