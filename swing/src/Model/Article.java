package Model;

import java.io.Serializable;

public class Article implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	private String barCode;
	private double price;
	private static int threshold = 5;

	public Article(String name, String barCode, double price) {
		this.name = name;
		this.barCode = barCode;
		this.price = price;
	}
	
	public Article(Article article)
	{
		this.name = article.name;
		this.barCode = article.barCode;
		this.price = article.price;
	}
	
	public double getPrice() {
		return this.price;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int t) {
		threshold = t;
	}

	public String getBarCode() {
		return barCode;
	}
	
	public Article getArticle()
	{
		return this;
	}
	
	@Override
	public String toString() {
		return "Name " + this.name + " Bar Code: " + this.barCode + " Price: " + this.price;
	}

}
