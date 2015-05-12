<%@ page import="objects.AuthorList" %>
<%@ page import="objects.Author" %>
<%@ page import="objects.Genre" %>
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
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/main-style.css">
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>

<div class="main-div">
  <div>
    <h1>Hello, <%= request.getParameter("username") %></h1>
  </div>

  <div class="logo" width="100%" height="50px">
    <h1 class="logo-text">Welcome to the best online library </h1>
  </div>

  <div class="search-div">
   <form class="search_bar" name="search_form" method="post">
     <input type="text" name="search_string" value="">
     <input type="submit" value="Поиск" name="search_button">
     <select name="search_option">
       <option>Название книги</option>
       <option>Автор</option>
     </select>
    </form>
  </div><%--close search-div--%>

  <div class="author-list">
   <h3>Список жанров: </h3>
    <ul>
      <jsp:useBean id="genreList" class="objects.GenreList" scope="application"/>
      <%for(Genre genre:genreList.getGenreList()) {%>
        <li> <a href="#"><%=genre.getName()%> </a></li>
      <%}%>
    </ul>
  </div><%--close AuthorList--%>

  <div class="book-list">
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
    <p>book_book_book_book_book_book</p>
  </div><%--close bookList--%>




</div><%--close main container--%>



</body>
</html>
