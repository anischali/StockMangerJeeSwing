package com.gest.daos;

import java.util.ArrayList;

import com.gest.beans.ArticleStock;
import com.gest.beans.Stock;

public interface StockDao {

	public void AddArticle(ArticleStock article) throws DaoException;
	public Stock getStock() throws DaoException;
	public void removeStock(ArticleStock article) throws DaoException;
	public void updateStock(ArticleStock article) throws DaoException;
	public ArticleStock getArticle(String barcode) throws DaoException;
	public ArrayList<ArticleStock> getStockList() throws DaoException;
}
