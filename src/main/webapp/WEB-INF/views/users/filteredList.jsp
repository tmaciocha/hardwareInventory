<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: themos
  Date: 23/01/2022
  Time: 13:57
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<title>find user</title>
</html>


<div class="container-fluid px-4">
    <h1 class="mt-4">finded user</h1>
    <ol class="breadcrumb mb-4">
    </ol>


    <form method="post" action="/user/find">
        <div>
            <label for="username">find user: </label>
            <input name="username" id="username" type="text" placeholder="email address">

            <input type="submit" value="search">
        </div>

    </form>



    <div class="card mb-4" >
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            founded user:
        </div>
        <div class="card-body">
            <table id="datatablesSimpleSingle">
                <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${foundeduser}" var="foundeduser">
                    <tr>
                        <td colspan="">${foundeduser.firstName}</td>
                        <td colspan="">${foundeduser.lastName}</td>
                        <td colspan="">${foundeduser.username}</td>
                        <td colspan="">${foundeduser.phoneNumber}</td>
                        <td><a href="edit/${foundeduser.id}">Edit</a></td>
                        <td><a href="remove/${foundeduser.id}">Remove</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>




<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>--%>
