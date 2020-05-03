/**
 * 
 */
package com.gest.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 
 *
 */
public class DaoFactory {
	private String url;
	private String user;
	private String pass;
	
	
	public DaoFactory(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
	}
	
	/**
	 * Initialise le driver mysql.
	 * @return DaoFactory une instance qui servira pour la connection à la base de données. 
	 */
	public static DaoFactory getInstance()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new DaoFactory("jdbc:mysql://localhost:3306/gest?serverTimezone=EST5EDT", "gestuser", "password");
	}
	
	/**
	 * Récupère une connection à la base de données.
	 * @return Connection la connection à la base de données
	 * @throws SQLException une erreur sql si la connection à échoué.
	 */
	public Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url,user, pass);
	}
	
	
	/**
	 * Récupère une instance avec toutes les instructions sql pour stock et article. 
	 * @return StockDao l'instance pour modifier les tables stock et article.
	 */
	public StockDao getStockDao()
	{
		return new StockDaoImpl(this);
	}
	

	/**
	 * Récupère une instance avec toutes les instructions sql pour le commandes. 
	 * @return StockDao l'instance pour modifier les tables command.
	 */
	public OrderDao getOrderDao()
	{
		return new OrderDaoImpl(this);
	}

}
