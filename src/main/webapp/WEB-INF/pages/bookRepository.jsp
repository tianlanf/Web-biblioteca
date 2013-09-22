<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/css/gangnamStyle.css' />" type="text/css" />
</head>
<body>
<h1>books in biblioteca</h1>
<table class="invoice_table">
    <thead>
    <tr>
        <th>Title</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}" varStatus="row">
        <tr>
            <td>${book.title}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<%--<style>--%>
    <%--table{--%>
        <%--width:80%;--%>
        <%--border: 1px solid;--%>
        <%--border-collapse:collapse;--%>
    <%--}--%>
<%--</style>--%>
</html>