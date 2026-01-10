<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>

<h2>Danh sách sinh viên</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Tên</th>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
