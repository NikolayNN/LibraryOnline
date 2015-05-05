<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 05.05.2015
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Library</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/index-style.css">
</head>
<body>
<div class="pic">
<img width="300" src="${pageContext.request.contextPath}/images/ikonka-knig.jpg"/>
  </div>
<div class="main">
<p>Welcome, to the best online library.</p>
<p>Here you can find many intresting books.</p>
<p>First time, you must enter your name in the form and press button "Login". </p>
<p>Enjoy!</p>
<form name="username" action="pages/main.jsp" method="post">
  <input type="text" name="username" value="" >
  <input type="submit" value="Login">
</form>
</div>
</body>
</html>