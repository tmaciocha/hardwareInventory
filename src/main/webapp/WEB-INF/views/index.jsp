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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <c:if test="${users3MonthsEnd > 0}">
            <div style="color: #ff3e2d">Active users which contract ends in 3 months, or has ended: ${users3MonthsEnd}</div>
            </c:if>

            <div>Active tasks:
                <c:if test="${tasksNumber > 0}"><h5 style="color: red"> ${tasksNumber} </h5></c:if>
                <c:if test="${tasksNumber == 0}"><h4 style="color:green"> Great, You don't have any task. Go on a walk!</h4> </c:if>




                    </div>
<sec:authorize access="isAnonymous()">
            <div>users: ${usersNumber}</div>
            <div>hardware: ${hardwareNumber}</div>
            <div>software: ${softwareNumber}</div>

</sec:authorize>
            <sec:authorize access="isAuthenticated()">
            <hr>



            <i class="fas fa-table me-1"></i>
            All tasks</br>
         <label>show done
        <%--    <form:checkbox path="showFinished"/>--%>
        </label></div>
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

                <c:forEach items="${tasksDto}" var="task">
                    <tr>
                        <td><c:if test="${task.status == true }">&#10004;</c:if></td>
                        <td>${task.priority}</td>
                        <td>${task.logDate}</td>
                        <td>${task.closeDate}</td>
                        <td>${task.title}</td>
                        <td>${task.description}</td>
                        <td>${task.serialNumber} ${task.hardwareName}  </td>
                        <td>${task.softwareName} ${task.softwareProducerName}</td>
                        <td>${task.username}</td>
                        <td><a href="task/edit/${task.taskId}">Edit</a></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </sec:authorize>
    </div>
</div>

<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>