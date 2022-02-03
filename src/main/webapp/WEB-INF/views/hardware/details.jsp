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
    <title>Hardware Details</title>
</head>


<div class="container-fluid px-4">
    <h1 class="mt-4"> Hardware: ${hardware.name}, ${hardware.serialNumber}, details: </h1>
    <ol class="breadcrumb mb-4">
    </ol>


    <%--@elvariable id="user" type="pl.tm.hardwareinventory.model.Producer"--%>
    <form:form method="post" modelAttribute="hardware">
        <form:hidden path="id"/>
    <table>
        <a href="/hardware/edit/${hardware.id}">Edit</a>
        <tr>
            <td>In use</td>
            <td>${hardware.inUse}</td>
        </tr>
        <tr>
            <td>Serial Number</td>
            <td>${hardware.serialNumber}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${hardware.name}</td>
        </tr>
        <tr>
            <td>Producer</td>
            <td>${hardware.producer.name}</td>
        </tr>
        <tr>
            <td>Type</td>
            <td>${hardware.hardwareType.type}</td>
        </tr>
        <tr>
            <td>Usable</td>
            <td>${hardware.usable}</td>
        </tr>
        <tr>
            <td>Company(owner)</td>
            <td>${hardware.company.nipName}</td>
        </tr>

        <tr>
            <td>Quality</td>
            <td>${hardware.hardwareQuality.name}</td>
        </tr>
        <tr>
            <td>Last Changes</td>
            <td>${hardware.lastChangeDate}</td>
        </tr>
        <tr>
            <td>User</td>
            <td>${hardware.user.username}</td>
        </tr>
        <tr>
            <td>Installed on Software</td>
            <td>
                <c:forEach items="${hardware.softwareList}" var="software">
                    ${software.name} ${software.producer.name} ${software.version}<br/>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>Description</td>
            <td>${hardware.description}</td>
        </tr>
        <tr>
            <td>Battery Quality</td>
            <td>${hardware.batteryQuality}</td>
        </tr>
        <tr>
            <td>Disk Size (GB)</td>
            <td>${hardware.discSize}</td>
        </tr>
        <tr>
            <td>Disk Type</td>
            <td>${hardware.discType}</td>
        </tr>
        <tr>
            <td>Invoice</td>
            <td>${hardware.invoice.numberCompany}, ${hardware.invoice.purchaseDate}</td>
        </tr>


        <tr>
            <td>MAC</td>
            <td>${hardware.macNumber}</td>
        </tr>
        <tr>
            <td>Price (net)</td>
            <td>${hardware.netPrice}</td>
        </tr>
        <tr>
            <td>Production Date</td>
            <td>${hardware.productionDate}</td>
        </tr>
        <tr>
            <td>RAM (GB)</td>
            <td>${hardware.ramAmount}</td>
        </tr>

        <tr>
            <td>Screen Size (inches)</td>
            <td>${hardware.screenSize}</td>
        </tr>













    </table>


    <a href="/hardware/">Back</a>

    </form:form>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>