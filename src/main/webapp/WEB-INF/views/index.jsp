<%--
  Created by IntelliJ IDEA.
  User: themos
  Date: 22/01/2022
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Home Page</title>
</html>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Dashboard</h1>
                <ol class="breadcrumb mb-4">
                 <%--   <li class="breadcrumb-item active">Dashboard</li>--%>
                </ol>
            </div>

<div>
    <div>tasks : TODO</div>
    <div>number users whose contract will end in the next 3 months: TODO</div>
    <div>licence problems: MAYBE</div>
    <div>users number: ${usersNumber}</div>
    <div>hardware number: ${hardwareNumber}</div>
    <div>software number: ${softwareNumber}</div>
</div>
<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>