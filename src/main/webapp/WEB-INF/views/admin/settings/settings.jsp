<%--
  Created by IntelliJ IDEA.
  User: themos
  Date: 24/01/2022
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>


<head>
    <title>Settings</title>
</head>

<div class="container-fluid px-4">
    <h1 class="mt-4"> Settings list:</h1>
    <ol class="breadcrumb mb-4">
    </ol>
<div>
<a href="/softwaretype/">Software type</a>
</div>

    <div>
        <a href="/producer/">Producers</a>
    </div>

    <div>
        <a href="/hardwareQuality/">Hardware quality</a>
    </div>

    <div>
        <a href="/hardwareType/">Hardware type</a>
    </div>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>