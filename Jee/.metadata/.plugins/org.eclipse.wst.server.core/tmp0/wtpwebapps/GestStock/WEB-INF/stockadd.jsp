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
      <a class="nav-item nav-link active" href="/GestStock/">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="/GestStock/stockview">View stock</a>
      <a class="nav-item nav-link" href="/GestStock/stockadd">Add Article</a>
    </div>
  </div>
</nav>
</div>
<div class="container">
<form method = "post" action ="/GestStock/stockaddart">
  <div class="form-group row">
    <label for="barcode" class="col-sm-2 col-form-label">Article barcode</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="barcode" placeholder="Article barcode...">
    </div>
  </div>
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Article name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" placeholder="Article name...">
    </div>
  </div>
  <div class="form-group row">
    <label for="category" class="col-sm-2 col-form-label">Article category</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="category" placeholder="Article Category...">
    </div>
  </div>
  <div class="form-group row">
    <label for="price" class="col-sm-2 col-form-label">Article price</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="price" placeholder="Article price...">
    </div>
  </div>
    <div class="form-group row">
    <label for="quantity" class="col-sm-2 col-form-label">Article quantity</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="quantity" placeholder="Article quantity...">
    </div>
  </div>
    <div class="form-group row">
    <label for="treshold" class="col-sm-2 col-form-label">Article treshold</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="treshold" placeholder="Article treshold...">
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Add to stock</button>
    </div>
  </div>
</form>
  
</div>
</div>
</body>
</html>