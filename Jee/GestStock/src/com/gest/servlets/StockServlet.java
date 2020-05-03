package com.gest.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gest.beans.ArticleStock;
import com.gest.daos.DaoFactory;
import com.gest.daos.StockDao;
import com.gest.exception.DaoException;
import com.gest.forms.ArticleForm;

/**
 * Servlet implementation class StockServlet
 */
@WebServlet("/StockServlet")
public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StockDao stock;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	DaoFactory factory = DaoFactory.getInstance();
    	this.stock = factory.getStockDao();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rem = request.getParameter("rem");
		String edit = request.getParameter("edit");
		request.setAttribute("edit", false);
		if (rem != null)
		{
			try {
				ArticleStock art = stock.getArticle(rem);
				stock.removeStock(art);
			} catch (DaoException e) {
				request.setAttribute("error", e.getMessage());
			}
		}		
		
		if(request.getRequestURI().contains("stockadd") || (edit != null && request.getRequestURI().contains("stockedit")))
		{
			request.setAttribute("edit", false);
			if (edit != null) {
				ArticleStock art;
				try {
					art = stock.getArticle(edit);
					request.setAttribute("article", art);
					request.setAttribute("edit", true);
				} catch (DaoException e) {
					request.setAttribute("error", e.getMessage());
				}
			}
			this.getServletContext().getRequestDispatcher("/WEB-INF/stockadd.jsp").forward(request, response);
			
		}

		else if (request.getRequestURI().contains("/stockview"))
		{
			List<ArticleStock> articles = new ArrayList<ArticleStock>();
			try {
				articles = stock.getStockList();
				request.setAttribute("articles", articles);
				this.getServletContext().getRequestDispatcher("/WEB-INF/stockview.jsp").forward(request, response);
			} catch (DaoException e) {
				request.setAttribute("error", e.getMessage());
				this.getServletContext().getRequestDispatcher("/WEB-INF/stockview.jsp").forward(request, response);
			}
		}

		
		else
		{
			request.setAttribute("edit", false);
			this.getServletContext().getRequestDispatcher("/WEB-INF/stock.jsp").forward(request, response);
		}
		
		
	}

	
    /**
	 * Cette fonction gère une récéption en post des données d'un article à ajouter à la base de données.
	 * @param request la requete envoyé au serveur depuis le client.
	 * @param response la réponse envoyé au client depuis le serveur.
	 * @throws ServletException Erreur soulevé si la communication http à un problème.
	 * @throws IOException Erreur soulevé si la lecture Input/Output rencontre des problème
	 * @throws DaoException une erreur si un problème survient lors de la mise à jour de la base de données.
	 */
	@SuppressWarnings("unused")
	private void addArticlePost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{		
		ArticleForm form = new ArticleForm();
		if (form.checkArticleStockForm(request) == true)
		{	
			ArticleStock art = form.getUserStockArticle(request);
			try {
				stock.AddArticle(art);
				response.sendRedirect("/GestStock/stockview");
			} catch (DaoException e) {
				request.setAttribute("error", e.getMessage());
			}
		
		}
		else {
			String error = form.getMessage();
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/WEB-INF/stockadd.jsp").forward(request, response);
		}
	}

	/**
	 * Cette fonction gère une récéption en post des données d'un article à mettre à jour dans la base de données.
	 * @param request la requete envoyé au serveur depuis le client.
	 * @param response la réponse envoyé au client depuis le serveur.
	 * @throws ServletException Erreur soulevé si la communication http à un problème.
	 * @throws IOException Erreur soulevé si la lecture Input/Output rencontre des problème
	 * @throws DaoException une erreur si un problème survient lors de la mise à jour de la base de données.
	 */
	@SuppressWarnings("unused")
	private void editArticlePost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{		
		ArticleForm form = new ArticleForm();
		if (form.checkArticleStockForm(request) == true)
		{	
			ArticleStock art = form.getUserStockArticle(request);
			try {
				if (stock.articleExists(art.getBarcode()) == true)
				{
					ArticleStock oldArticle = stock.getArticle(art.getBarcode());
					stock.updateStock(art);
				}
				response.sendRedirect("/GestStock/stockview");
			} catch (DaoException e) {
				System.out.println(e.getMessage());
				request.setAttribute("error", e.getMessage());
			}
		
		}
		else {
			String error = form.getMessage();
			request.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/WEB-INF/stockadd.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		if (request.getRequestURI().contains("/stockedit"))
		{
			editArticlePost(request, response);
		}
		else if (request.getRequestURI().contains("/stockadd"))
		{
			addArticlePost(request, response);
		}
	}
}	
	
