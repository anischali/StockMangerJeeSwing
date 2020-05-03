package com.gest.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gest.beans.ArticleOrder;
import com.gest.beans.ArticleStock;
import com.gest.daos.DaoFactory;
import com.gest.daos.OrderDao;
import com.gest.daos.StockDao;
import com.gest.exception.DaoException;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HashMap<String, ArticleStock> articles;   
    private StockDao stock;
    private OrderDao orderDao;
    private ArticleOrder order = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	DaoFactory factory = DaoFactory.getInstance();
    	this.stock = factory.getStockDao();
    	this.orderDao = factory.getOrderDao();
    	try {
			articles = stock.getStock().getArticles();
		} catch (DaoException e) {
			e.printStackTrace();
		}
    	order = new ArticleOrder();
    }
    
    /**
	 * Joue le role de controller pour l'ajout d'un article au panier de commande.
	 * @param request la requete envoyé au serveur depuis le client.
	 * @param response la réponse envoyé au client depuis le serveur.
	 * @throws ServletException Erreur soulevé si la communication http à un problème.
	 * @throws IOException Erreur soulevé si la lecture Input/Output rencontre des problème
	 * @throws DaoException une erreur si un problème survient lors de la mise à jour de la base de données.
	 */
    private void addArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DaoException
    {
    	if (order == null)
    	{
    		order = new ArticleOrder();
    	}
    	String barcode = request.getParameter("barcode");
    	if (articles.containsKey(barcode))
    	{
    		ArticleStock art = articles.get(barcode);
    		art.setQuantity(1);
    		order.add(art);
    	}
    	List<ArticleStock> arts = order.getOrderList();
    	request.setAttribute("articles", arts);
    	this.getServletContext().getRequestDispatcher("/WEB-INF/order.jsp").forward(request, response);
    	
    }
    
	/**
	 * Mis à jour le panier de commande.
	 * @param barcode le code bar de l'article concerné.
	 * @param quantity la nouvels quantité. si <= 0 l'article est supprimé.
	 */
    private void updateOrder(String barcode, int quantity)
    {
    	if (order == null) return;
    	if (quantity <= 0)
    	{
    		order.remove(barcode);
    	}
    	else {
    		ArticleStock art = articles.get(barcode);
    		art.setQuantity(quantity);
    		order.add(art);
    	}
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quantity = request.getParameter("quantity");
		String barcode =  request.getParameter("barcode");
		String remove = request.getParameter("remove");
		String validate = request.getParameter("validate");
		String cancel = request.getParameter("cancel");
		
		if (quantity != null && barcode != null)
		{
			updateOrder(barcode, new Integer(quantity));
		}
		else if (remove != null && barcode != null)
		{
			updateOrder(barcode, 0);
		}
		else if (validate != null)
		{
			try {
				orderDao.validateOrder(order);
				orderDao.generateBill(order);
				order = new ArticleOrder();				
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}
		else if (cancel != null)
		{
			order = new ArticleOrder();
		}
    	List<ArticleStock> arts = order.getOrderList();
    	request.setAttribute("articles", arts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			addArticle(request, response);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		//doGet(request, response);
	}

}
