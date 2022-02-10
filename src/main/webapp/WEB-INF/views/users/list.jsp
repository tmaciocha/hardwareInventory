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
<title>Users</title>
</html>


<div class="container-fluid px-4">
    <h1 class="mt-4"> users list:</h1>
    <ol class="breadcrumb mb-4">
    </ol>


    <form:form method="post" action="/user/filter" >

        <div>
            <label for="username">find user: </label>
            <input name="username" id="username" type="text" placeholder="DO ZROBIENIA PÓŹNIEJ - email address">
            <input type="submit" value="search">
        </div>
    </form:form>
    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            All users
        </div>
        <div class="card-body">
            <a href="add">Add new</a>
            <table id="datatablesSimple">
                <thead>
                <tr>
                    <th>Active</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Contract ends</th>
                </tr>
                </thead>
              <tfoot>
                <tr>
                    <th>Active</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Contract ends</th>
                </tr>
                </tfoot>
                <tbody>


                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:if test="${user.activeUser == true }">&#10004;</c:if></td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.username}</td>
                        <td>${user.phoneNumber}</td>
                        <td>${user.endOfContract}</td>

                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <td><a href="edit/${user.id}">Edit</a></td>
                        </sec:authorize>

                        <td><a href="/task/add/user/${user.id}">Add task</a></td>
                       <%-- <td><a href="remove/${user.id}">Remove</a></td>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>