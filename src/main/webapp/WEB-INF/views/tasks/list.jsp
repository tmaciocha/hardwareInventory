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
<title>Tasks</title>
</html>


<div class="container-fluid px-4">
    <h1 class="mt-4"> Tasks list:</h1>
    <ol class="breadcrumb mb-4">
    </ol>


    <form:form method="post" action="" modelAttribute="tasksDto">
        <div>
            <label for="username">find task: </label>
            <input name="username" id="username" type="text" placeholder="Later by number or date">
            <input type="submit" value="search">
        </div>
    </form:form>
    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            All tasks
        </div>
        <div class="card-body">
            <a href="add/">Add new</a>
            <table id="datatablesSimple">
                <thead>
                <tr>
                    <th>done</th>
                    <th>priority</th>
                    <th>Created date</th>
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
                    <th>Created date</th>
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
                        <td>${task.status}</td>
                        <td>${task.priority}</td>
                        <td>${task.logDate}</td>
                        <td>${task.title}</td>
                        <td>${task.description}</td>
                        <td>${task.serialNumber} ${task.hardwareName}  </td>
                        <%--<td>${task.software.name} ${task.software.producer} ${task.software.version}</td>--%>
                        <td>${task.username}</td>
                        <td><a href="edit/${task.taskId}">Edit</a></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>