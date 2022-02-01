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
<title>Software</title>
</html>


<div class="container-fluid px-4">
    <h1 class="mt-4"> Software list:</h1>
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
                    <th>name</th>
                    <%--<th>software type</th>--%>
                    <th>producer</th>
                    <th>version</th>
                    <th>serial key</th>
                    <th>hardware list</th>
                    <th>users</th>
                    <%--<th>invoice</th>--%>
                    <th>description</th>
                    <%--<th>manual</th>
                    <th>homePage</th>
                    <th>netPrice</th>--%>
                    <th>active up to</th>
                    <th>active</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>name</th>
                    <%--<th>software type</th>--%>
                    <th>producer</th>
                    <th>version</th>
                    <th>serial key</th>
                    <th>hardware list</th>
                    <th>users</th>
                    <%--<th>invoice</th>--%>
                    <th>description</th>
                    <%--<th>manual</th>
                    <th>homePage</th>
                    <th>netPrice</th>--%>
                    <th>active up to</th>
                    <th>active</th>
                </tr>
                </tfoot>
                <tbody>


                <c:forEach items="${softwareList}" var="software">
                    <tr>
                        <td>${software.name}</td>
                        <td>${software.producer.name}</td>
                        <td>${software.version}</td>
                        <td>${software.serialKey}</td>
                        <td>
                            <c:forEach items="${software.hardwareList}" var="hardware">
                                ${hardware.producer.name} ${hardware.name};;<br/>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${software.users}" var="user">
                                ${user.username};+;<br/>
                            </c:forEach>
                        </td>
                        <td>${software.description}</td>
                        <td>${software.activeUpTo}</td>
                        <td>${software.active}</td>

                        <td><a href="details/${software.id}">Details</a></td>
                        <td><a href="edit/${software.id}">Edit</a></td>
                        <td><a href="file/">Add file</a></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>