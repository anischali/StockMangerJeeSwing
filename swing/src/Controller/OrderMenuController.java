package Controller;

import java.util.Map.Entry;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import Model.Article;
import Model.ArticleStock;
import Model.OrderList;
import Model.Stock;

public class OrderMenuController {
	private Stock stock;
	private OrderList orders;
	private OrderController order;
	
	
	
	public OrderMenuController(Stock stock, OrderList orders)
	{
		this.orders = orders;
		this.stock = stock;
		this.order = new OrderController();
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * @return the orders
	 */
	public OrderList getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(OrderList orders) {
		this.orders = orders;
	}

	public void btnAddEvent(JList<OrderController> list, String barcode, JLabel artNumber, JLabel totalPrice)
	{
		DefaultListModel<OrderController> model = new DefaultListModel<>();
		Article article;
		if (stock.isValid(barcode) == true)
		{
			article = stock.getArticle(barcode);
			order.update(article, 1, true);
			model.addElement(order);
			list.setModel(model);
			
			artNumber.setText(new Integer(order.getArticleNumber()).toString());
			totalPrice.setText(new Double(order.getTotalPrice()).toString());
			
		}

	}
	
	
	public void addToStock(JTextField name, JTextField barcode, JTextField price, JTextField quantity)
	{
		Double dprice = new Double(price.getText());
		Integer q = new Integer(quantity.getText());
		Article art = new Article(name.getText(), barcode.getText(), dprice.doubleValue());
		stock.update(art, q, true);
	}
	
	
	public void displayStock(JList<ArticleStock> list)
	{
		Set<Entry<String, ArticleStock>> arts = stock.getStockEntries();
		if (arts.isEmpty() == false) {
			DefaultListModel<ArticleStock> model = new DefaultListModel<ArticleStock>();
			for (Entry<String, ArticleStock> art : arts)
			{
				ArticleStock article = art.getValue();
				model.addElement(article);
			}
			list.setModel(model);
		}
	}

}
