package com.gest.controller;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.gest.daos.DaoFactory;
import com.gest.daos.OrderDao;
import com.gest.daos.StockDao;
import com.gest.exception.DaoException;
import com.gest.model.ArticleOrder;
import com.gest.model.ArticleStock;
import com.gest.view.OrderPanel;

public class OrderController extends OrderPanel {
	
	private static final long serialVersionUID = 1L;
	private StockDao stock;
	private OrderDao orderDao;
	private HashMap<String, ArticleStock> articles;
	private int selectedArticle;
	private ArticleOrder order;
	
	public OrderController()
	{
		super();
		order = new ArticleOrder();
		DaoFactory factory = DaoFactory.getInstance();
		this.stock = factory.getStockDao();
		this.orderDao = factory.getOrderDao();
		try {
			articles = stock.getStock().getArticles();
			System.out.println(articles.values().toString());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		super.btnCancel.addActionListener(this::btnCancelListener);
		super.addBtn.addActionListener(this::addBtnListener);
		super.editBtn.addActionListener(this::editBtnListener);
		super.removeBtn.addActionListener(this::removeBtnListener);
		super.selected.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				tableEventListener();
			}
		});
		super.btnValidate.addActionListener(this::btnValidateListener);
	}
	

	/**
	 * Ecoute les évenements sur le button ajouter un article 
	 * @param event évenement écouté.
	 */
	public void addBtnListener(ActionEvent event)
	{
		if (order == null) {
			order = new ArticleOrder();
			super.tfCodeBar.setText("");
			super.tfQuantity.setText("");
			super.tfName.setText("");
		}
		ArticleStock art = null;
		if (articles.containsKey(super.tfCodeBar.getText()))
		{
			art = articles.get(super.tfCodeBar.getText());
			int quantity = (super.tfQuantity.getText().contentEquals("") == true) ? 1 : new Integer(super.tfQuantity.getText());
			art.setQuantity(quantity);
			order.add(art);
		}
		this.displayOrder();
		
	}

	

	/**
	 * Ecoute les évenements et les changement sur le panier de la commande. 
	 */
	private void tableEventListener()
	{
		selectedArticle = super.table.getSelectedRow();
		if (!(articles.isEmpty()) && selectedArticle != -1) {
			List<ArticleStock> arts = order.getOrderList();
			ArticleStock selectedArt = arts.get(selectedArticle);
			super.tfCodeBar.setText(selectedArt.getBarcode());
			super.tfQuantity.setText(new Integer(selectedArt.getQuantity()).toString());
			super.tfName.setText(selectedArt.getName());
		}
	}

	/**
	 * vérifie que les champs code bar et quantité sont pas vide 
	 * @return boolean true si tout est bien sinon false.
	 */
	private boolean checkFields()
	{
		if (super.tfCodeBar.getText().isEmpty() || super.tfQuantity.getText().isEmpty())
			return false;
		return true;
	}
	

	/**
	 * Ecoute les évenements sur le button modifier un article 
	 * @param event évenement écouté.
	 */
	private void editBtnListener(ActionEvent event)
	{
		if (! this.checkFields())
			return;
		int quantity = new Integer(super.tfQuantity.getText());
		if (quantity > 0)
		{
			this.addBtnListener(event);
		}
		else 
		{
			this.removeBtnListener(event);
		}
	}
	

	/**
	 * Ecoute les évenements sur le button ajouter un article 
	 * @param event évenement écouté.
	 */
	private void removeBtnListener(ActionEvent event)
	{
		if (! this.checkFields())
			return;
		order.remove(super.tfCodeBar.getText());
		this.displayOrder();
	}
	

	/**
	 * Ecoute les évenements sur le button annuler une commande 
	 * @param event évenement écouté.
	 */
	public void btnCancelListener(ActionEvent event)
	{
		if (order != null)
			order.cancelOrder();
		super.dispose();
	}
	

	/**
	 * Ecoute les évenements sur le button valider une commande
	 * @param event évenement écouté.
	 */
	public void btnValidateListener(ActionEvent event)
	{
		try {
			stock.updateStock(order.getOrderList());
			orderDao.validateOrder(order);
			orderDao.generateBill(order);
			order.cancelOrder();
			this.displayOrder();
			order = null;
			super.dispose();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Calcule le prix total d'un panier de commande.
	 * @return double le prix total du panier.
	 */
	public double getTotalPrice()
	{
		double price = 0.0;
		List<ArticleStock> arts = order.getOrderList();
		for (ArticleStock art : arts)
		{
			price += art.getPrice() * art.getQuantity(); 
		}
		return price;
	}

	
	/**
	 * Affiche le panier.
	*/
	public void displayOrder()
	{
		List<ArticleStock> arts = order.getOrderList();
		super.displayOrderTable(arts);
		Double price = new Double(this.getTotalPrice()); 
		super.lblTotalPrice.setText(price.toString());
	}
	
	
}
