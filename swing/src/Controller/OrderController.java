package Controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map.Entry;

import Model.Article;
import Model.Order;

public class OrderController {
	private HashMap<Article, Integer> articles;
	private double totalPrice;
	private int articleNumber;

	public OrderController() {
		this.articles = new HashMap<>();
		this.totalPrice = 0.0;
		this.articleNumber = 0;
	}

	public double getTotalPrice() {
		BigDecimal bd = new BigDecimal(totalPrice);
		return bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue() ;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}

	public void update(Article article, int quantity, boolean add) {
		double price = article.getPrice() * quantity;
		if (add == true) {
			this.articleNumber += quantity;
			this.totalPrice += price;
			this.articles.put(article, (articles.containsKey(article))?articles.get(article) + quantity : quantity);
		} else {
			this.totalPrice -= price;
			this.articleNumber -= quantity;
			this.articles.put(article, (articles.containsKey(article))?articles.get(article) - quantity : quantity);
			if (this.articles.containsKey(article))
				if (this.articles.get(article) <= 0)
					this.articles.remove(article);
		}
	}
	
	public Order validate() {
		Order cmd = new Order(this.articles, this.totalPrice);
		this.cancel();
		return cmd;
	}
	
	
	public void setQuantity(String barcode, int quantity)
	{
		Article article = this.getArticle(barcode);
		if (article == null) return;
		int q = this.articles.get(article);
		this.totalPrice -= (q * article.getPrice());
		this.articleNumber -= q;
		this.totalPrice += article.getPrice() * quantity;
		this.articleNumber += quantity;
		this.articles.put(article, quantity);
		if (quantity == 0)
		{
			this.articles.remove(article);
		}
	}
	

	public void cancel() {
		this.articles.clear();
		this.totalPrice = 0.0;
		this.articleNumber = 0;
	}
	
	public Article getArticle(String barcode)
	{
		for (Entry<Article, Integer> art : this.articles.entrySet())
		{
			Article a = art.getKey();
			if (a.getBarCode().equals(barcode))
				return a;
		}
		return null;
	}
	
	
	@Override
	public String toString() {
		String artList = ""; 
		BigDecimal bd = new BigDecimal(totalPrice);
		double tmp = bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
		totalPrice = tmp;
		for (Entry<Article, Integer> art : this.articles.entrySet())
		{
			Article a = art.getKey();
			int q = art.getValue().intValue();
			double total = q * a.getPrice();
			bd =  new BigDecimal(total);
			total = bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
			artList += "\n" + a.getName() + " " + a.getBarCode() + " " + a.getPrice() +" Quantity: " + q + " Total price " + total + '\n';
		}
		return artList;
	}
	
	
}
