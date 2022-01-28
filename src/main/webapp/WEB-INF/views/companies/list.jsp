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
<title>Companies</title>
</html>


<div class="container-fluid px-4">
    <h1 class="mt-4"> Company list:</h1>
    <ol class="breadcrumb mb-4">
    </ol>


    <form:form method="post" action="/user/filter" >
        <div>
            <label for="username">find company: </label>
            <input name="username" id="username" type="text" placeholder="DO ZROBIENIA PÓŹNIEJ - NIP">
            <input type="submit" value="search">
        </div>
    </form:form>
    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            All companies
        </div>
        <div class="card-body">
            <a href="add/">Add new</a>
            <table id="datatablesSimple">
                <thead>
                <tr>
                    <th>NIP</th>
                    <th>name</th>
                    <th>street</th>
                    <th>street number</th>
                    <th>post code</th>
                    <th>city</th>
                    <th>description</th>
                </tr>
                </thead>
              <tfoot>
                <tr>
                    <th>NIP</th>
                    <th>name</th>
                    <th>street</th>
                    <th>street number</th>
                    <th>post code</th>
                    <th>city</th>
                    <th>description</th>
                </tr>
                </tfoot>
                <tbody>


                <c:forEach items="${companies}" var="company">
                    <tr>
                        <td colspan="">${company.nip}</td>
                        <td colspan="">${company.name}</td>
                        <td colspan="">${company.street}</td>
                        <td colspan="">${company.streetNumber}</td>
                        <td colspan="">${company.city}</td>
                        <td colspan="">${company.postCode}</td>
                        <td colspan="">${company.description}</td>
                        <td><a href="edit/${company.id}">Edit</a></td>
                        <td><a href="remove/${company.id}">Remove</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>