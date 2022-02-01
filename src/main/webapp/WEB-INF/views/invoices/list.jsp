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
<title>Invoices</title>
</html>


<div class="container-fluid px-4">
    <h1 class="mt-4"> Invoices list:</h1>
    <ol class="breadcrumb mb-4">
    </ol>


    <form:form method="post" action="" >
        <div>
            <label for="username">find invoice: </label>
            <input name="username" id="username" type="text" placeholder="Later by number or date">
            <input type="submit" value="search">
        </div>
    </form:form>
    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            All invoices
        </div>
        <div class="card-body">
            <a href="add/">Add new</a>
            <table id="datatablesSimple">
                <thead>
                <tr>
                    <th>number</th>
                    <th>purchase date</th>
                    <th>filename</th>
                    <th>seller</th>
                </tr>
                </thead>
              <tfoot>
                <tr>
                    <th>number</th>
                    <th>purchase date</th>
                    <th>filename</th>
                    <th>seller</th>
                </tr>
                </tfoot>
                <tbody>


                <c:forEach items="${invoices}" var="invoice">
                    <tr>
                        <td colspan="">${invoice.number}</td>
                        <td colspan="">${invoice.purchaseDate}</td>
                        <td colspan="">${invoice.filename}</td>
                        <td colspan="">${invoice.company.nipName}</td>
                        <td>${invoice.description}</td>
                        <td><a href="edit/${invoice.id}">Edit</a></td>
                        <td><a href="file/">Add file</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>