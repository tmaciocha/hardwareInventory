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


<html>
<title>Hardware</title>
</html>


<div class="container-fluid px-4">
    <h1 class="mt-4"> Hardware list:</h1>
    <ol class="breadcrumb mb-4">
    </ol>


    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>



        </div>
        <div class="card-body">
            <a href="add/">Add new</a>
            <table id="datatablesSimple">
                <thead>
                <tr>
                    <th>serialNumber</th>
                    <th>name</th>
                    <th>producer</th>
                    <th>hardwareType</th>
                    <th>company</th>
                    <th>user</th>
                    <th>description</th>
                    <th>purchaseDate</th>
                </tr>
                </thead>
              <tfoot>
                <tr>
                    <th>serialNumber</th>
                    <th>name</th>
                    <th>producer</th>
                    <th>hardwareType</th>
                    <th>company</th>
                    <th>user</th>
                    <th>description</th>
                    <th>purchaseDate</th>
                </tr>
                </tfoot>
                <tbody>


                <c:forEach items="${hardwareList}" var="hardware">
                    <tr>
                        <td>${hardware.serialNumber}</td>
                        <td>${hardware.name}</td>
                        <td>${hardware.producer.name}</td>
                        <td>${hardware.hardwareType.type}</td>
                        <td>${hardware.company.name}</td>
                        <td>${hardware.user.username}</td>
                        <td>${hardware.description}</td>
                        <td>${hardware.invoice.purchaseDate}</td>
                        <td><a href="details/${hardware.id}">Details</a></td>
                        <td><a href="edit/${hardware.id}">Edit</a></td>
                        <td><a href="file/">Add file</a></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>