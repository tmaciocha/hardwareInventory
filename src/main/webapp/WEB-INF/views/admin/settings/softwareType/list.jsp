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
<title>Software Types</title>
</html>


<div class="container-fluid px-4">
    <h1 class="mt-4"> software types list:</h1>
    <ol class="breadcrumb mb-4">
    </ol>





    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            Software types
        </div>
        <div class="card-body">
            <table id="datatablesSimple">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Type</th>
                    <th>Description</th>
                </tr>
                </thead><%--
              <tfoot>
                <tr>
                    <th>Id</th>
                    <th>Type</th>
                    <th>Description</th>
                </tr>
                </tfoot>--%>
                <tbody>


                <c:forEach items="${softwareTypes}" var="type">
                    <tr>
                        <td colspan="">${type.id}</td>
                        <td colspan="">${type.type}</td>
                        <td colspan="">${type.description}</td>
                        <td><a href="edit/${type.id}">Edit</a></td>
                        <td><a href="remove/${type.id}">Remove</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>