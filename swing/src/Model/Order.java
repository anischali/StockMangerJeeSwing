package Model;

import java.io.Serializable;
import java.util.HashMap;

public class Order implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private static Integer id = 0;
    private HashMap<Article, Integer> articles;
    private double totalPrice;

    public Order(HashMap <Article, Integer> articles, double price)
    {
        id++;  
        this.articles = new HashMap<>();
        this.articles.putAll(articles);
        this.setTotalPrice(price);    
    }

    @SuppressWarnings("static-access")
	public Integer getId()
    {
    	return this.id;
    }
    
    public HashMap<Article, Integer> getArticles()
    {
        return this.articles;
    }



	public double getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
}
