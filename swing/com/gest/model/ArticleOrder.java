package com.gest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleOrder extends Order{
	private String date = "";
	private int id;
	
	
	public ArticleOrder() {
		super();
		this.date = generateDate();
		this.id = generateId();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	
	public List<ArticleStock> getOrderList()
	{
		return  new ArrayList<ArticleStock>(super.getArticles().values());
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * setter pour changer la date 
	 * @param date la chaine de charactère de la date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Récupère la date et la renvoi en chaine de caractères.
	 * @return date chaine de caractères.
	 */
	private String generateDate()
	{
		Date date = new Date();
		return date.toString();
	}
	
	/**
	 * Gènere un id unique positive à partir de la date et l'heure.
	 * @return id un identifiant de commande.
	 */
	private int generateId()
	{
		Date date = new Date();
		return Math.abs(date.toString().hashCode());
	}

	
}
