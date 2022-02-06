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




    <div class="card mb-4">
        <div class="card-header">
            <div>users number  whose contract will end in the next 3 months: TODO</div>
            <div>tasks: ${tasksNumber}</div>
            <div>users: ${usersNumber}</div>
            <div>hardware: ${hardwareNumber}</div>
            <div>software: ${softwareNumber}</div>

            <hr>

            <i class="fas fa-table me-1"></i>
            All tasks
        </div>
        <div class="card-body">
            <table id="datatablesSimple">
                <thead>
                <tr>
                    <th>done</th>
                    <th>priority</th>
                    <th>Created/opened on</th>
                    <th>Closed on</th>
                    <th>title</th>
                    <th>description</th>
                    <th>hardware</th>
                    <th>software</th>
                    <th>user</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>done</th>
                    <th>priority</th>
                    <th>Created/opened on</th>
                    <th>Closed on</th>
                    <th>title</th>
                    <th>description</th>
                    <th>hardware</th>
                    <th>software</th>
                    <th>user</th>
                </tr>
                </tfoot>
                <tbody>

                <c:forEach items="${tasks}" var="task">
                    <tr>
                        <td>${task.status}</td>
                        <td>${task.priority}</td>
                        <td>${task.logDate}</td>
                        <td>${task.closeDate}</td>
                        <td>${task.title}</td>
                        <td>${task.description}</td>
                        <td>${task.hardware.name} ${task.hardware.serialNumber}</td>
                        <td>${task.software.name} ${task.software.version} ${task.software.serialKey}</td>
                        <td>${task.user.username}</td>
                        <td><a href="task/edit/${task.id}">Edit</a></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>