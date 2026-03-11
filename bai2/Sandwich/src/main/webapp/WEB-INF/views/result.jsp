<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<h2>Gia vị đã chọn</h2>

<c:forEach items="${list}" var="item">
  <p>${item}</p>
</c:forEach>

<a href="/">Quay lại</a>

</body>
</html>