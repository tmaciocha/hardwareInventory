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
<title>Invoice</title>
</html>


<div class="container-fluid px-4">
    <h1 class="mt-4"> Invoice list:</h1>
    <ol class="breadcrumb mb-4">
    </ol>


    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>


        </div>
        <div class="card-body">
            you are searching software: ${search} </br>founded:</br>
            <c:forEach items="${invoiceSearch}" var="searched">
                <a href="/invoice/edit/${searched.id}">edit ${searched.numberCompanyDateDescription}</a>; View invoice: <a href="/invoices/${searched.filename}">view</a></br>

            </c:forEach>

        </div>
    </div>
</div>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>