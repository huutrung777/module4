<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<h2>Calculator</h2>

<form action="/calculate" method="post">

    <input type="text" name="num1">
    <input type="text" name="num2">

    <br><br>

    <button type="submit" name="operator" value="+">Addition(+)</button>
    <button type="submit" name="operator" value="-">Subtraction(-)</button>
    <button type="submit" name="operator" value="*">Multiplication(x)</button>
    <button type="submit" name="operator" value="/">Division(/)</button>

</form>

<h3>Result: ${result}</h3>

</body>
</html>