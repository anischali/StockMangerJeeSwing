package com.gest.daos;

import com.gest.beans.ArticleOrder;
import com.gest.exception.DaoException;

public interface OrderDao {

		/**
	 * Valider une commande en mettant à jour la base de données.
	 * @param order la commande à valider.
	 * @throws DaoException une erreur si un problème survient lors de la mise à jour de la base de données.
	 */

	public void validateOrder(ArticleOrder order) throws DaoException;

	/**
	 * Genere la facture au format pdf.
	 * @param order la commande pour laquel on genere la facture
	 */
	public void generateBill(ArticleOrder order);
	
}
