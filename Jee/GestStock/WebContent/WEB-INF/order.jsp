<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style><%@include file="/WEB-INF/style/bootstrap.min.css"%></style>
	<script type="text/javascript"><%@ include file = "/WEB-INF/js/main.js" %></script>
	<title>Order</title>
</head>
<body>
<div class="container">
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/GestStock/">Acceuil <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="/GestStock/order?validate=1">Valider</a>
      <a class="nav-item nav-link" href="/GestStock/order?cancel=1">Annuler</a>
    </div>
  </div>
</nav>
</div>
<div class="container">
<form method = "post" action ="/GestStock/order">
  <div class="form-group row">
    <label for="barcode" class="col-sm-2 col-form-label">Code bar</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="barcode" name="barcode" placeholder="Code bar">
    </div>
  </div>
    <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Ajouter</button>
    </div>
  </div>
</form>
</div>
<%@ include file="/WEB-INF/orderview.jsp" %>
</div>
</body>
</html>