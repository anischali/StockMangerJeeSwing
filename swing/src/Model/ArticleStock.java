package Model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ArticleStock extends Article implements Serializable{

	private int quantity;
	public ArticleStock(Article art, int quantity) {
		super(art);
		this.quantity = quantity;
	}
	
	
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String toString()
	{
		return super.toString() + " Quantity: " + quantity + " \n";
	}
}
