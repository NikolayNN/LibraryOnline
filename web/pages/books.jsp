<%@ page import="objects.Book" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 12.05.2015
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/main-style.css">
</head>
<body>
<%@include file="../jspf/left-menu.jspf"%>
<div class="book-list">

<h1> <%=request.getParameter("name")%>: </h1>

<jsp:useBean id="bookList" class="objects.BookList" scope="page"/>


  <%bookList.setBookListByGenre(Integer.parseInt(request.getParameter("genre_id")));
    session.setAttribute("currentBookList",bookList.getBookList());
    if (bookList.getBookList().size()==0)%><%{%><br/><h2 class="book-not-found">Книги не найдены.<h2> <%}%>

    <% for(Book book : bookList.getBookList()){%>

        <p><strong>Название книги:</strong> <%=book.getName()%> </p>

  <p><strong>Автор: </strong> <%=book.getAuthor()%></p>

  <p><strong>Страниц: </strong> <%=book.getPages()%></p>
        <p><strong>Дата первой публикации: </strong> <%=book.getYear()%></p>
        <p><strong>isbn: </strong> <%=book.getIsbn()%></p>
        <p><img src="<%=request.getContextPath()%>/ShowImageServlet?index=<%=book.getId()%>"></p>
  <br/><hr/><br/>

  <%}%>



  </div>

</body>
</html>
