<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 05.05.2015
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<h1>Hello</h1>
<h1>
  <%= request.getParameter("username") %>
</h1>
</body>
</html>
