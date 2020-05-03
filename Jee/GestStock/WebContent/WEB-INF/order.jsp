<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<style><%@include file="/WEB-INF/style/bootstrap.min.css"%></style>
	<title>Order</title>
</head>
<body>
<div class="container">
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/GestStock/">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="/GestStock/validate">Validate</a>
      <a class="nav-item nav-link" href="/GestStock/cancel">Cancel</a>
    </div>
  </div>
</nav>
</div>
<div class="container">
<form method = "post" action ="/orderaddart">
  <div class="form-group row">
    <label for="barcode" class="col-sm-2 col-form-label">Article barcode</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="barcode" placeholder="Article barcode...">
    </div>
  </div>
    <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Add to order</button>
    </div>
  </div>
</form>
</div>
</div>
</body>
</html>