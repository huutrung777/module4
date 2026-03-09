<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
</head>
<body>
<h2>Chuyển đổi USD sang VNĐ</h2>
<form action="convert" method="post">
    Tỷ giá: <input type="number"  name="rate" required><br><br>
    Số tiền USD: <input type="number"  name="usd" required><br><br>
    <button type="submit">Chuyển đổi</button>
</form>

</body>
</html>
