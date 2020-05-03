/**
 * 
 */
package com.gest.model;

import java.util.HashMap;

/**
 * @author visibog
 *
 */
public class Order {
private HashMap<String, ArticleStock> articles;

	
	public Order() {
		articles = new HashMap<String, ArticleStock>();
	}
	
	/**
	 * Ajoute un article au panier de la commande.
	 * @param article L'article à ajouter.
	 */
	public void add(ArticleStock article)
	{
		articles.put(article.getBarcode(), article);
	}
	

	/**
	 * Récupère un article pour le modifier ou le supprimer de la commande.
	 * @param barcode le code bar de l'article.
	 * @return L'article si celui la existe dans le panier.
	 */
	public ArticleStock get(String barcode)
	{
		if (articles.containsKey(barcode) == true)
		{
			return articles.get(barcode);
		}
		return null;
	}
	

	/**
	 * Supprime un article de panier de commande.
	 * @param barcode le code bar de l'article concerné.
	 */
	public void remove(String barcode)
	{
		if (articles.containsKey(barcode) == true)
			articles.remove(barcode);
	}
	
	
		
	
	/**
	 * @return the articles
	 */
	public HashMap<String, ArticleStock> getArticles() {
		return articles;
	}

	/**
	 * @param articles the articles to set
	 */
	public void setArticles(HashMap<String, ArticleStock> articles) {
		this.articles = articles;
	}
	
	/**
	 * annule un commande.
	 */
	public void cancelOrder()
	{
		this.articles.clear();
	}
}
