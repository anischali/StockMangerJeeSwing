<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<style><%@include file="/WEB-INF/style/bootstrap.min.css"%></style>
	<title>Stock</title>
</head>
<body>
<div class="container">
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/GestStock/">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="/GestStock/stockadd">Add Article</a>
    </div>
  </div>
</nav>
</div>
<div class="container">
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">Barcode</th>
      <th scope="col">Name</th>
      <th scope="col">Category</th>
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${ articles }" var="article">
  	<tr>
      <th scope="row"><c:out value="${ article.barcode }"></c:out></th>
      <td><c:out value="${ article.name }"></c:out></td>
      <td><c:out value="${ article.category }"></c:out></td>
      <td><c:out value="${ article.price }"></c:out></td>
      <td><c:out value="${ article.quantity }"></c:out></td>
      <td> <a href="/GestStock/stockview?edit=${article.barcode}"><button class="btn btn-primary">Edit</button></a></td>
      <td> <a href="/GestStock/stockview?rem=${article.barcode}"><button class="btn btn-primary">Remove</button></a></td>
    </tr>
   </c:forEach>
  </tbody>
</table>
</div>
</div>
</body>
</html>