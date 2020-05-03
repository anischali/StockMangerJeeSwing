<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<style><%@include file="/WEB-INF/style/bootstrap.min.css"%></style>
	<title>Acceuil</title>
</head>
<body>
  <c:if test="${ !empty error }"><p style="color: red;"><c:out value="${ error }"></c:out> </p></c:if>

<div class="container">
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/GestStock/">Acceuil <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="/GestStock/stock">Session gestionnaire</a>
      <a class="nav-item nav-link" href="/GestStock/order">Session caisse</a>
    </div>
  </div>
  </nav>
  </div>	
  <div class="container">

	<h1>Gestionnaire de stock</h1>
	<h3>Groupe 1</h3>
	<h3>Université Paris 8 - Seine Saint Denis</h3>
	<h3>Professeur encadrant <b>M. Lefebvre Pierre</b></h3>
	<h3>Membres de groupe:</h3>
	<h3><b>Anis CHALI</b></h3>
	<h3><b>Habib Balit</b></h3>
	<h3><b>Sofian AIT EL DJOUDI</b></h3>
	<h3><b>Micipsa SADJI</b></h3>
	<h3><b>Alycia KARA</b></h3>

</div>
</div>
</body>
</html>