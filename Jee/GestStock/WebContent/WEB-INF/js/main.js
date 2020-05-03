'use-strict'
window.onload = main;


function on(element, event, callback) {
    element.addEventListener(event, callback);
}





function edit(btnEdit)
{
	let line = btnEdit.parentNode.parentNode.parentNode;
	let barcode = line.id;
	let quantityBox = document.getElementById("quantity"+barcode);
	if (quantityBox.value == ""){
		alert("Le champs quantite est vide!!!");
	}
	let editLink =  document.getElementById("editLink"+barcode);
	editLink.href = "/GestStock/order?barcode="+barcode+"&quantity="+quantityBox.value;
}

function remove(btnRemove)
{
	let line = btnRemove.parentNode.parentNode.parentNode;
	let barcode = line.id;
	let removeLink =  document.getElementById("removeLink"+barcode);
	removeLink.href = "/GestStock/order?remove=1&barcode="+barcode;
}

function main()
{
	let btnEdit = document.querySelectorAll("#btnEdit");
	let btnRemove = document.querySelectorAll("#btnRemove");
	if (btnEdit == null && btnRemove == null)
		return;
	btnEdit.forEach((btn)=> {
		on(btn, 'click', (event)=>{
			edit(btn);
		});
	});
	btnRemove.forEach((btn)=> {		
		on(btn, 'click', (event)=>{
			remove(btn);
		});
	});
}
