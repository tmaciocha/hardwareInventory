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
            <table id="datatablesSimple">
                <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                </tr>
                </thead>
              <tfoot>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                </tr>
                </tfoot>
                <tbody>


                <c:forEach items="${users}" var="user">
                    <tr>
                        <td colspan="">${user.firstName}</td>
                        <td colspan="">${user.lastName}</td>
                        <td colspan="">${user.username}</td>
                        <td colspan="">${user.phoneNumber}</td>
                        <td><a href="edit/${user.id}">Edit</a></td>
                        <td><a href="remove/${user.id}">Remove</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>