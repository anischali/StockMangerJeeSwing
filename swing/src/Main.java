import java.awt.EventQueue;
import java.sql.ResultSet;

import Controller.OrderMenuController;
import Model.DataBase;
import Model.OrderList;
import Model.Stock;
import View.Menu;

public class Main {
	
/*
	public static void main(String[] args) throws Exception {
		System.out.println();
		Stock stock = new Stock();
		stock.readFromFile("db/stock/myStock.dat");
		Menu mainMenu = new Menu();
		mainMenu.mainMenu(stock);
		stock.saveToFile("db/stock/myStock.dat");
		OrderList sessionOrders = mainMenu.getSessionOrders();
		sessionOrders.saveToFile("db/orders/Orders of ");
	
	}*/
	public static void main(String[] args) throws Exception {
		Stock mainStock = new Stock();
		mainStock.readFromFile("db/stock/myStock.dat");
		OrderList orders = new OrderList();
		OrderMenuController orderController = new OrderMenuController(mainStock, orders);
		DataBase db = new DataBase();
		ResultSet r = db.executeAndGet("SELECT * FROM Article");
		while (r.next())
			System.out.println(r.getString("CodeBar") + " " + r.getString(2));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(orderController);
					frame.setVisible(true);
					mainStock.setStock(orderController.getStock().getStock());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		mainStock.saveToFile("db/stock/myStock.dat");
		System.out.println(mainStock.toString());
		orders = orderController.getOrders();
	}
}

