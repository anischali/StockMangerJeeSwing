package com.gest.forms;

import javax.servlet.http.HttpServletRequest;

import com.gest.beans.ArticleStock;

public class ArticleForm {
	private String fields = "";
	
	
	public boolean checkArticleStockForm(HttpServletRequest request)
	{
		String barcode = request.getParameter("barcode");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		String treshold = request.getParameter("treshold");
		if (barcode.matches("/[0-9]") == false || barcode.length() != 13) 
		{
			fields += "Barcode must be digit with size 13.\n";
			return false;
		}
		if (price.matches("/[0-9]|.") == false || price.length() == 0)
		{
			fields += "Price must be digit.\n";
			return false;
		}
		if (quantity.matches("/[0-9]") == false || quantity.length() == 0)
		{
			fields += "Quantity must be digit.\n";
			return false;
		}
		if (treshold.matches("/[0-9]") == false || treshold.length() == 0)
		{
			fields += "Treshold must be digit.\n";
			return false;
		}
		if (name.length() == 0)
		{
			fields += "Name must not be null.\n";
			return false;
		}
		if (category.length() == 0)
		{
			fields += "Category must not be null.\n";
			return false;
		}
		return true;
	}
	
	
	public ArticleStock getUserStockArticle(HttpServletRequest request)
	{
		String barcode = request.getParameter("barcode");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		String treshold = request.getParameter("treshold");
		ArticleStock art = new ArticleStock();
		art.setBarcode(barcode);
		art.setName(name);
		art.setCategory(category);
		art.setPrice(new Double(price).doubleValue());
		art.setQuantity(new Integer(quantity).intValue());
		art.setTreshold(new Integer(treshold).intValue());
		return art;
	}


	public String getMessage() {
		return fields;
	}
	
	
	
}
