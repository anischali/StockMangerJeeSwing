package com.gest.forms;

import javax.servlet.http.HttpServletRequest;

import com.gest.beans.ArticleStock;

public class ArticleForm {
	private String fields = "";
	
    /**
	 * Vérifie l'entrée de l'utilisateur pour éviter des problème de sécurité ou des erreurs avec la base de données. 
	 * @param art le contenu de différents champs de l'article.
	 * @return true si tout est bien sinon false.
	 */
	public boolean checkArticleStockForm(HttpServletRequest request)
	{
		String barcode = request.getParameter("barcode");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		String treshold = request.getParameter("treshold");
		if (barcode.matches("^\\d+?") == false || barcode.length() != 13) 
		{
			fields += "Barcode must be digit with size 13.\n";
			return false;
		}
		if (price.matches("^\\d+(\\.\\d+)?") == false || price.length() == 0)
		{
			fields += "Price must be digit.\n";
			return false;
		}
		if (quantity.matches("^\\d+?") == false || quantity.length() == 0)
		{
			fields += "Quantity must be digit.\n";
			return false;
		}
		if (treshold.matches("^\\d+?") == false || treshold.length() == 0)
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
	
	

	/**
	 * Récupère l'article dans le cas ou tout est valide.
	 * @return ArticleStock l'article saisi par l'utilisateur. 
	 */
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

	/**
	 * Récupère le message de l'erreur de formulaire.
	 * @return String message d'erreur.
	 */
	public String getMessage() {
		return fields;
	}
	
	
	
}
