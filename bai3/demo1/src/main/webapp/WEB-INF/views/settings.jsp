<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Settings</h2>

<form:form action="/settings/update" method="post" modelAttribute="settings">

  Language:
  <form:select path="language">
    <form:option value="English" label="English"/>
    <form:option value="Vietnamese" label="Vietnamese"/>
    <form:option value="Japanese" label="Japanese"/>
    <form:option value="Chinese" label="Chinese"/>
  </form:select>

  <br><br>

  Page Size:
  <form:select path="pageSize">
    <form:option value="5"/>
    <form:option value="10"/>
    <form:option value="15"/>
    <form:option value="25"/>
    <form:option value="50"/>
    <form:option value="100"/>
  </form:select>

  <br><br>

  Spam Filter:
  <form:checkbox path="spamFilter"/>

  <br><br>

  Signature:
  <br>
  <form:textarea path="signature"/>

  <br><br>

  <button type="submit">Update</button>

</form:form>