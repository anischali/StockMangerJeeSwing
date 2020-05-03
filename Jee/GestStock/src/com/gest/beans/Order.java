/**
 * 
 */
package com.gest.beans;

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
}
