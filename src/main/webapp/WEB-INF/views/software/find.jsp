<%--
  Created by IntelliJ IDEA.
  User: themos
  Date: 23/01/2022
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<title>Software</title>
</html>


<div class="container-fluid px-4">
    <h1 class="mt-4"> Software list:</h1>
    <ol class="breadcrumb mb-4">
    </ol>


    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>


        </div>
        <div class="card-body">
            you are searching software: ${search} </br>found:</br>
            <c:forEach items="${softwareSearch}" var="searched">
                <a href="/software/details/${searched.id}">${searched.name}</a></br>
            </c:forEach>

        </div>
    </div>
</div>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>