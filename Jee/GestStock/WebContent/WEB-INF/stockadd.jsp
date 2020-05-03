<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<style><%@include file="/WEB-INF/style/bootstrap.min.css"%></style>
	<title>Add article</title>
</head>
<body>
<div class="container">
 <c:if test="${ !empty error }"><p style="color: red;"><c:out value="${ error }"></c:out> </p></c:if>
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/GestStock/">Acceuil <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="/GestStock/stockview">Afficher le stock</a>
      <a class="nav-item nav-link" href="/GestStock/stockadd">Ajouter un article</a>
    </div>
  </div>
</nav>
</div>
<c:choose>
<c:when test="${ edit == false}">
<div class="container">
  <%@ include file="form.jsp" %>
</div>
</c:when>
<c:otherwise>
<%@ include file="editform.jsp" %>
</c:otherwise>
</c:choose>
</div>
</body>
</html>