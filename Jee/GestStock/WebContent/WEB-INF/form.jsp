<form method = "post" action ="/GestStock/stockadd">
  <div class="form-group row">
    <label for="barcode" class="col-sm-2 col-form-label">Code Bar</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="barcode" name="barcode" placeholder="Code bar...">
    </div>
  </div>
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Nom</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" name="name" placeholder="Nom...">
    </div>
  </div>
  <div class="form-group row">
    <label for="category" class="col-sm-2 col-form-label">Catégorie</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="category"  name="category" placeholder="Categorie...">
    </div>
  </div>
  <div class="form-group row">
    <label for="price" class="col-sm-2 col-form-label">Prix</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="price" name="price" placeholder="Prix...">
    </div>
  </div>
    <div class="form-group row">
    <label for="quantity" class="col-sm-2 col-form-label">Quantité</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="quantity" name="quantity" placeholder="Quantité...">
    </div>
  </div>
    <div class="form-group row">
    <label for="treshold" class="col-sm-2 col-form-label">Seuille</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="treshold" name="treshold" placeholder="Seuille...">
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Ajouter</button>
    </div>
  </div>
</form>