<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Image File Upload</title>
</head>
<body>



<h3 style="color:red">${filesuccess}</h3>
<form:form method="post" action="/invoice/savefile" enctype="multipart/form-data">
    <p><%--@declare id="image"--%><label for="image">Choose Invoice Image</label></p>
    <p><input name="file" id="fileToUpload" type="file" /></p>
    <p><input type="submit" value="Upload"></p>
</form:form>


<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>