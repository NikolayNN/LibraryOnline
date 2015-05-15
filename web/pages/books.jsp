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
<%if(request.getParameter("name")!=null){%>
<h1> <%=request.getParameter("name")%>: </h1>
<%}%>

<jsp:useBean id="bookList" class="objects.BookList" scope="page"/>


  <% if (request.getParameter("type_request").equalsIgnoreCase("byGenre")){
         bookList.setBookList(Integer.parseInt(request.getParameter("genre_id")));
            }else if (request.getParameter("type_request").equalsIgnoreCase("allBooks")){
                bookList.setBookList();
                }else if(request.getParameter("type_request").equalsIgnoreCase("byLetter")){
                    bookList.setBookList(request.getParameter("id"));
                    }else if(request.getParameter("type_request").equalsIgnoreCase("search")){
                        bookList.setBookList(request.getParameter("search_string"),request.getParameter("selector"));
  }


    session.setAttribute("currentBookList", bookList.getBookList());
        if (bookList.getBookList().size()==0)%><%{%><br/><h2 class="book-not-found">Книги не найдены.<h2> <%}%>
        <%if (bookList.getBookList().size()!=0)%><%{%><br/><h2 class="book-not-found">Найдено книг: <%= bookList.getBookList().size()%> <h2> <%}%>


    <% for(Book book : bookList.getBookList()){%>
        <div class="book">
       <br/>
           <div class="book-name"> <h2> <%=book.getName()%>.</h2></div>
            <div class="book-cover"><img class="img1" src="<%=request.getContextPath()%>/ShowImageServlet?index=<%=book.getId()%>"></div>

        <p><strong>Автор: </strong> <%=book.getAuthor()%></p>
        <p><strong>Страниц: </strong> <%=book.getPages()%></p>
        <p><strong>Дата первой публикации: </strong> <%=book.getYear()%></p>
        <p><strong>isbn: </strong> <%=book.getIsbn()%></p>
        <p><a class="link-read" href="#"> Читать </a></p>

  <br/></div>

  <%}%>



  </div>

</body>
</html>
