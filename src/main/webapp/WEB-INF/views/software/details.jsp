<%--
  Created by IntelliJ IDEA.
  User: themos
  Date: 24/01/2022
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Software Details</title>
</head>


<div class="container-fluid px-4">
    <h1 class="mt-4"> Software: ${software.name} </h1>
    <ol class="breadcrumb mb-4">
    </ol>


    <form:form method="post" modelAttribute="software">
        <form:hidden path="id"/>
    <table>
        <a href="/software/edit/${software.id}">Edit</a>
        <tr>
            <td>Active</td>
            <td>${software.active}</td>
        </tr>

        <tr>
            <td>Active Up to</td>
            <td>${software.activeUpTo}</td>
        </tr>
        <tr>
            <td>Owner</td>
            <td>${software.company.nipName}</td>
        </tr>
        <tr>
            <td>Description</td>
            <td>${software.description}</td>
        </tr>
        <tr>
            <td>Producer Home Page</td>
            <td>${software.homePage}</td>
        </tr>
        <tr>
            <td>Invoice</td>
            <td>${software.invoice.numberCompany}</td>
        </tr>
        <tr>
            <td>Last logs change</td>
            <td>${software.logDate}</td>
        </tr>

        <tr>
            <td>Manual</td>
            <td>${software.manual}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${software.name}</td>
        </tr>
        <tr>
            <td>Price (net)</td>
            <td>${software.netPrice}</td>
        </tr>

        <tr>
            <td>Producer</td>
            <td>${software.producer.name}</td>
        </tr>
        <tr>
            <td>Serial Key</td>
            <td>${software.serialKey}</td>
        </tr>
        <tr>
            <td>Licence Type</td>
            <td>${software.softwareType.type}</td>
        </tr>
        <tr>
            <td>Version</td>
            <td>${software.version}</td>
        </tr>

        <tr>
            <td>Installed on Hardware</td>
            <td>
            <c:forEach items="${software.hardwareList}" var="harware">
                ${harware.serialNumber} ${harware.name}<br/>
            </c:forEach>
            </td>
        </tr>
        <tr>
            <td>User</td>
            <td>

                <c:forEach items="${software.users}"  var="user">
                    ${user.username}, active: ${user.activeUser} <br/>
                </c:forEach>
            </td>
        </tr>

        <tr>
            <td>Purchase Date</td>
            <td>${software.invoice.purchaseDate}</td>
        </tr>




    </table>


    <a href="/hardware/">Back</a>

    </form:form>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>