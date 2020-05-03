<div class="container">
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">Code bar</th>
      <th scope="col">Nom</th>
      <th scope="col">Prix</th>
      <th scope="col">Quantité</th>
      <th scope="col">Sous Total</th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
<c:set var = "subtotal" scope="page" value = "${ 0.0 }"/>
  <c:set var="total" scope="page" value="${ 0.0 }" /> 
  <c:forEach items="${ articles }" var="article">
  	<tr id = "${ article.barcode }">
      <th scope="row"><c:out value="${ article.barcode }"></c:out></th>
      <td><c:out value="${ article.name }"></c:out></td>
      <td><c:out value="${ article.price }"></c:out></td>
      <td><c:out value="${ article.quantity }"></c:out></td>
      <c:set var = "subtotal" value = "${ article.quantity * article.price }"/>
      <c:set var = "total" value = "${ total = total + subtotal }"/>
      <td><c:out value="${ subtotal }"></c:out></td>
      <td> <a id = "editLink${ article.barcode }" href="#"><input type="text" id="quantity${ article.barcode }" name="quantity" placeholder="Quantité..." style="width: 100px;"><button id = "btnEdit" class="btn btn-primary">Modifier</button></a></td>
      <td> <a id = "removeLink${ article.barcode }" href="#"><button id = "btnRemove" class="btn btn-primary">Supprimer</button></a></td>
    </tr>
   </c:forEach>
   <tr>
      <th scope="col"></th>
      <th scope="col"></th>
      <th scope="col"></th>
      <th scope="col"></th>
      <th scope="col"></th>
      <th scope="col">Total: </th>
      <th scope="col"><c:out value="${ total }"></c:out></th>
    </tr>
  </tbody>
</table>
</div>
