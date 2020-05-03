<form method = "post" action ="/GestStock/stockadd">
  <div class="form-group row">
    <label for="barcode" class="col-sm-2 col-form-label">Article barcode</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="barcode" name="barcode" placeholder="Article barcode...">
    </div>
  </div>
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Article name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" name="name" placeholder="Article name...">
    </div>
  </div>
  <div class="form-group row">
    <label for="category" class="col-sm-2 col-form-label">Article category</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="category"  name="category" placeholder="Article Category...">
    </div>
  </div>
  <div class="form-group row">
    <label for="price" class="col-sm-2 col-form-label">Article price</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="price" name="price" placeholder="Article price...">
    </div>
  </div>
    <div class="form-group row">
    <label for="quantity" class="col-sm-2 col-form-label">Article quantity</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="quantity" name="quantity" placeholder="Article quantity...">
    </div>
  </div>
    <div class="form-group row">
    <label for="treshold" class="col-sm-2 col-form-label">Article treshold</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="treshold" name="treshold" placeholder="Article treshold...">
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Add to stock</button>
    </div>
  </div>
</form>