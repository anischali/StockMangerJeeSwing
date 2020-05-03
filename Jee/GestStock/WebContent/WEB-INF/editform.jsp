<div class="container">
<form method = "post" action ="/GestStock/stockedit">
  <input type="text" class="form-control" id="barcode" name="barcode"  value="${ article.barcode }" hidden="true">
   
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Nom</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" name="name" value="${ article.name }"/>
    </div>
  </div>
  <div class="form-group row">
    <label for="category" class="col-sm-2 col-form-label">Catégorie</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="category"  name="category" value="${ article.category }"/>
    </div>
  </div>
  <div class="form-group row">
    <label for="price" class="col-sm-2 col-form-label">Prix</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="price" name="price" value="${ article.price }"/>
    </div>
  </div>
    <div class="form-group row">
    <label for="quantity" class="col-sm-2 col-form-label">Quantité</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="quantity" name="quantity" value="${ article.quantity }"/>
    </div>
  </div>
    <div class="form-group row">
    <label for="treshold" class="col-sm-2 col-form-label">Seuille</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="treshold" name="treshold" value="${ article.treshold }">
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary"> Modifier </button>
    </div>
  </div>
</form>
</div>