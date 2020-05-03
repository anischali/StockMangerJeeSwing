package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Stock implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private HashMap<String, ArticleStock> stocks;
	

	public Set<Entry<String, ArticleStock>> getStockEntries() {
		return this.stocks.entrySet();
	}
	
	public HashMap<String, ArticleStock> getStock()
	{
		return this.stocks;
	}

	public void setStock(HashMap<String, ArticleStock> stock) {
		this.stocks.putAll( stock );
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Stock() {
		this.stocks = new HashMap<String, ArticleStock>();
	}

	public void update(Article article, int quantity, boolean add) {
		if (add == true) {
			if (this.stocks.containsKey(article.getBarCode())) {
				ArticleStock art = stocks.get(article.getBarCode());
				int q = art.getQuantity() + quantity;
				art.setQuantity(q);
				this.stocks.put(art.getBarCode(), art);
			}
			else {
				this.stocks.put(article.getBarCode(), new ArticleStock(article, quantity));
			}
		}
		else 
		{
			if (stocks.containsKey(article.getBarCode())) {
				ArticleStock art2 = stocks.get(article.getBarCode());
				int q2 = art2.getQuantity() - quantity;
				art2.setQuantity(q2);	
				this.stocks.put(article.getBarCode(), art2);
			}
		}
	}

	public void update(Order cmd, boolean op) {
		HashMap<Article, Integer> art = cmd.getArticles();
		for (Map.Entry<Article, Integer> entry : art.entrySet()) {
			this.update(entry.getKey(), entry.getValue(), op);
		}
	}

	public boolean isValid(String barcode) {
		if (this.stocks.containsKey(barcode) == false)
			return false;
		ArticleStock art = this.stocks.get(barcode);
		if (art.getQuantity() > art.getThreshold())
			return true;
		return false;
	}

	public Article getArticle(String barcode) {
		return stocks.get(barcode).getArticle();
	}
	
	
	public void removeArticle(String barcode)
	{
		stocks.remove(barcode);
	}
	
	@Override
	public String toString() {
		String artList = ""; 
		for (Entry<String , ArticleStock> art : this.stocks.entrySet())
		{
			
			artList += art.toString() + " \n";
		}
		return artList;
	}
	
	public void saveToFile(String pathname) throws Exception
	{
		FileOutputStream outputFile = new FileOutputStream(pathname);
		@SuppressWarnings("resource")
		ObjectOutputStream output = new ObjectOutputStream(outputFile);
		output.writeObject(this);
		output.close();
	}
	
	public void readFromFile(String pathname) throws Exception
	{
		File file = new File(pathname);
		if (! file.exists())
			return;
		FileInputStream inputFile = new FileInputStream(file);
		@SuppressWarnings("resource")
		ObjectInputStream input = new ObjectInputStream(inputFile);
		Stock savedStock = (Stock) input.readObject();
		this.stocks = savedStock.stocks;
	}
}
