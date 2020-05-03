package com.gest.daos;

import java.util.List;

import com.gest.beans.ArticleStock;
import com.gest.beans.Stock;
import com.gest.exception.DaoException;

public interface StockDao {
	/**
	 * Ajoute un article à la base de données.
	 * @param article l'article à ajouter.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */
	public void AddArticle(ArticleStock article) throws DaoException;
	
	/**
 	* Récupère tout le stock.
 	* @return Stock un objet de type stock.
 	* @throws DaoException erreur sql en cas de problème avec la base de données.
 	*/
	public Stock getStock() throws DaoException;
	
	/**
	 * Supprime un artile de la base de donnée.
	 * @param article l'article à supprimmer.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */
	public void removeStock(ArticleStock article) throws DaoException;
	

	/**
	 * Mis à jour le stock quand la modification concerne le meme code bar
	 * @param article l'article concerné.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */
	public void updateStock(ArticleStock article) throws DaoException;
	
	/**
	 * Mis à jour de la base données stock à partir d'un panier de commande.
	 * @param articles liste d'articles d'une commande.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */
	public void updateStock(List<ArticleStock> articles) throws DaoException;

	/**
	 * Récupère un article de stock avec son code bar.
	 * @param barcode code bar d'un article
	 * @return ArticleStock les detail de l'article recherché.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */
	public ArticleStock getArticle(String barcode) throws DaoException;
	
	/**
	 * Retourne le stock mais dans une liste.
	 * @return List<ArticleStock> le stock dans une liste.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */
	public List<ArticleStock> getStockList() throws DaoException;
	
	/**
	 * Verifie l'existance d'un article en stock.
	 * @param barcode
	 * @return true si l'article existe sinon false
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */
	public boolean articleExists(String barcode) throws DaoException;
	
	/**
	 * Mis à jour du stock en prenant les anciennes données et les nouvels données.
	 * @param oldArticle les anciennes informations d'un article.
	 * @param newArticle les nouvels informations d'un article.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */
	public void updateStock(ArticleStock oldArticle, ArticleStock newArticle) throws DaoException;
}
