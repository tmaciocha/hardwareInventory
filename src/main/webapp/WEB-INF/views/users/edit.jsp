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
<title>Edit user</title>
</html>



<div class="container-fluid px-4">
    <h1 class="mt-4"> You are editing user ${user.username}</h1>
    <ol class="breadcrumb mb-4">
    </ol>





    <%--@elvariable id="user" type="pl.tm.hardwareinventory.model.User"--%>
    <form:form action="/user/edit" method="post" modelAttribute="user">
        <form:hidden path="id"/>

    <div>
        <label>Email</label>
        <form:input path="username" type="text" readonly="true"/>
        <form:errors path="username" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>First Name</label>
        <form:input path="firstName" type="text"/>
        <form:errors path="firstName" cssClass="errorForm" element="div"/>
    </div>

    <div>
        <label>Last Name</label>
        <form:input path="lastName" type="text"/>
        <form:errors path="lastName" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Password</label>
        <form:input path="password" type="password"/>
        <form:errors path="password" cssClass="errorForm" element="div"/>
    </div>
        <c:if test="${user.id != 1}">
     <div>
                <label>End of the contract</label>
                <form:input path="endOfContract" type="date" />
                <form:errors path="endOfContract" cssClass="errorForm" element="div"/>
            </div>
    </c:if>
    <div>
        <label>Domain username:</label>
        <form:input path="domainUserName" type="text" />
        <form:errors path="domainUserName" cssClass="errorForm" element="div"/>
    </div>
    <div>
        <label>Phone Number:</label>
        <form:input path="phoneNumber" type="text" />
        <form:errors path="phoneNumber" cssClass="errorForm" element="div"/>
    </div>



    <c:if test="${user.id != 1}">
    <div>
        <label>active:</label>
        <form:checkbox path="activeUser" />
    </div>
    <div>
        <label>admin:</label>
        <form:checkbox path="superUser"/>
    </div>
    </c:if>
    <div><input value="save" type="submit"></div>


    </form:form>





<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>