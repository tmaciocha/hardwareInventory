<%--
  Created by IntelliJ IDEA.
  User: themos
  Date: 25/01/2022
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<html>
<title>Producers</title>
</html>


<div class="container-fluid px-4">
    <h1 class="mt-4"> Producers list:</h1>
    <ol class="breadcrumb mb-4">
    </ol>



    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            <a href="/settings">Settings</a>

        </div>
        <div class="card-body">
            <a href="add/">Add new</a>
            <table id="datatablesSimple">
                <thead>
                <tr>
                    <th>Producer Name</th>
                </tr>
                </thead>
                <tbody>


                <c:forEach items="${producers}" var="producer">
                    <tr>
                        <td >${producer.name}</td>
                        <td><a href="edit/${producer.id}">Edit</a></td>
                        <td><a href="remove/${producer.id}">Remove</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>