/**
 * 
 */
package com.gest.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gest.exception.DaoException;
import com.gest.model.ArticleStock;
import com.gest.model.Stock;

/**
 * @author visibog
 *
 */
public class StockDaoImpl implements StockDao{
	private DaoFactory daoFactory;
	
	
	public StockDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	
	/**
	 * Ajoute un article à la base de données.
	 * @param article l'article à ajouter.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */	
	@Override
	public void AddArticle(ArticleStock article) throws DaoException {
		Connection connect = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		try {
			connect = daoFactory.getConnection();
			stmt = connect.prepareStatement("INSERT INTO Article(barcode, name, category, price) VALUES (?,?,?,?);");
			stmt.setString(1, article.getBarcode());
			stmt.setString(2, article.getName());
			stmt.setString(3, article.getCategory());
			stmt.setDouble(4, article.getPrice());
			stmt.executeUpdate();
			stmt2 = connect.prepareStatement("INSERT INTO Stock(barcode, quantity, treshold) VALUES (?,?,?);");
			stmt2.setString(1, article.getBarcode());
			stmt2.setInt(2, article.getQuantity());
			stmt2.setInt(3, article.getTreshold());
			stmt2.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Error while trying to connect to database");
		}
	}

	
	
	/**
 	* Récupère tout le stock.
 	* @return Stock un objet de type stock.
 	* @throws DaoException erreur sql en cas de problème avec la base de données.
 	*/
	@Override
	public Stock getStock() throws DaoException {
		String sql = "SELECT Article.barcode,name,category,price,quantity FROM Article,Stock WHERE Article.barcode = Stock.barcode;";
		Stock stock = new Stock();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connect = daoFactory.getConnection();
			stmt = connect.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				ArticleStock art = new ArticleStock();
				art.setBarcode(rs.getString("barcode"));
				art.setName(rs.getString("name"));
				art.setCategory(rs.getString("category"));
				art.setPrice(rs.getDouble("price"));
				art.setQuantity(rs.getInt("quantity"));
				if (art.getQuantity() > art.getTreshold())
					stock.addArticle(art);
			}
			
		} catch (SQLException e) {
			throw new DaoException("Error while trying to connect to database");
		}finally {
			try {
				if (connect != null)
					connect.close();
			} catch (Exception e3) {
				throw new DaoException("Error while trying to connect to database");
			}
		}
		
		
		return stock;
	}

	
	/**
	 * Retourne le stock mais dans une liste.
	 * @return List<ArticleStock> le stock dans une liste.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */
	@Override
	public List<ArticleStock> getStockList() throws DaoException {
		String sql = "SELECT Article.barcode,name,category,price,quantity,treshold FROM Article,Stock WHERE Article.barcode = Stock.barcode;";
		List<ArticleStock> articles = new ArrayList<ArticleStock>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connect = daoFactory.getConnection();
			stmt = connect.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				ArticleStock art = new ArticleStock();
				art.setBarcode(rs.getString("barcode"));
				art.setName(rs.getString("name"));
				art.setCategory(rs.getString("category"));
				art.setPrice(rs.getDouble("price"));
				art.setQuantity(rs.getInt("quantity"));
				art.setTreshold(rs.getInt("treshold"));
				if (art.getQuantity() > art.getTreshold())
					articles.add(art);
			}
			
		} catch (SQLException e) {
			throw new DaoException("Error while trying to connect to database");
		}finally {
			try {
				if (connect != null)
					connect.close();
			} catch (Exception e3) {
				throw new DaoException("Error while trying to connect to database");
			}
		}
		
		
		return articles;
	}
	
	/**
	 * Supprime un artile de la base de donnée.
	 * @param article l'article à supprimmer.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */
	@Override
	public void removeStock(ArticleStock article) throws DaoException {
		Connection connect = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		try {
			connect = daoFactory.getConnection();
			stmt = connect.prepareStatement("DELETE FROM Article WHERE barcode = '"+ article.getBarcode() + "';");
			stmt.executeUpdate();
			stmt2 = connect.prepareStatement("DELETE FROM Stock WHERE barcode = '" + article.getBarcode() + "';");
			stmt2.executeUpdate();
			connect.commit();
		} catch (SQLException e) {
			try {
				if (connect != null)
					connect.rollback();
			}catch(SQLException e2){}
			throw new DaoException("Error while trying to connect to database");
		}finally {
			try {
				if (connect != null)
					connect.close();
			} catch (Exception e3) {
				throw new DaoException("Error while trying to connect to database");
			}
		}
	}


	/**
	 * Mis à jour du stock en prenant les anciennes données et les nouvels données.
	 * @param oldArticle les anciennes informations d'un article.
	 * @param newArticle les nouvels informations d'un article.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */
	@Override
	public void updateStock(ArticleStock oldArticle, ArticleStock newArticle) throws DaoException{
		this.removeStock(oldArticle);
		this.AddArticle(newArticle);
	}
	
	/**
	 * Mis à jour de la base données stock à partir d'un panier de commande.
	 * @param articles liste d'articles d'une commande.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */
	public void updateStock(List<ArticleStock> articles) throws DaoException
	{
		Connection connect = null;
		String sql = "";
		PreparedStatement stmt = null;
		try {
			connect = daoFactory.getConnection();
			connect.setAutoCommit(true);
			for (ArticleStock art : articles)
			{
				sql = "UPDATE `Stock` SET Stock.quantity=Stock.quantity-"+ art.getQuantity() +" WHERE Stock.barcode='"+ art.getBarcode() +"';";
				stmt = connect.prepareStatement(sql);
				stmt.executeUpdate();
				System.out.println(art.getBarcode());
			}
			
			System.out.println(sql);
		}catch(SQLException e) {
			throw new DaoException("Error while trying to connect to database");
		} finally {
			try {
				if (connect != null)
					connect.close();
			} catch (Exception e3) {
				throw new DaoException("Error while trying to connect to database");
			}
		}
	}
	
	/**
	 * Récupère un article de stock avec son code bar.
	 * @param barcode code bar d'un article
	 * @return ArticleStock les detail de l'article recherché.
	 * @throws DaoException erreur sql en cas de problème avec la base de données.
	 */	@Override
	public ArticleStock getArticle(String barcode) throws DaoException
	{
		String sql = "SELECT Article.barcode,name,category,price,quantity FROM Article,Stock WHERE Article.barcode = Stock.barcode AND Article.barcode = "+ barcode + ";";
		ArticleStock art = new ArticleStock();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connect = daoFactory.getConnection();
			stmt = connect.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
			{
				art.setBarcode(rs.getString("barcode"));
				art.setName(rs.getString("name"));
				art.setCategory(rs.getString("category"));
				art.setPrice(rs.getDouble("price"));
				art.setQuantity(rs.getInt("quantity"));
				if (art.getQuantity() < art.getTreshold())
					art = null;
			}
			
		} catch (SQLException e) {
			throw new DaoException("Error while trying to connect to database");
		}finally {
			try {
				if (connect != null)
					connect.close();
			} catch (Exception e3) {
				throw new DaoException("Error while trying to connect to database");
			}
		}
		return art;
	}
	
	/**
	 * @return the daoFactory
	 */
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	/**
	 * @param daoFactory the daoFactory to set
	 */
	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	
	
	
}
