package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

@SuppressWarnings("serial")
public class OrderList implements Serializable{
	private HashMap<Integer,Order> orders;

	public OrderList() {
		this.orders = new HashMap<>();
	}
	
	public void addOrder(Integer id, Order cmd)
	{
		this.orders.put(id, cmd);
	}
	
	
	public Order getOrder(Integer id)
	{
		if (this.orders.containsKey(id) == false)
			return null;
		return this.orders.get(id);
	}
	
	public boolean modifyOrder(Integer id, Order newOrder)
	{
		if (this.orders.containsKey(id) == false)
			return false;
		this.orders.put(id, newOrder);
		return true;
	}
	
	public boolean removeOrder(Integer id)
	{
		if (this.orders.containsKey(id) == false)
			return false;
		this.orders.remove(id);
		return true;
	}
	
	/**
	 * @return the orders
	 */
	public HashMap<Integer,Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(HashMap<Integer,Order> orders) {
		this.orders = orders;
	}
	
	private String generateName()
	{
		Date date = new Date();
		return date.toString();
	}

	
	
	public void saveToFile(String pathname) throws Exception
	{
		pathname += this.generateName();
		FileOutputStream outputFile = new FileOutputStream(pathname);
		ObjectOutputStream output = new ObjectOutputStream(outputFile);
		output.writeObject(this);
		output.close();
	}
	
	public OrderList readFromFile(String pathname) throws Exception
	{
		File file = new File(pathname);
		if (! file.exists())
			return new OrderList();
		FileInputStream inputFile = new FileInputStream(file);
		@SuppressWarnings("resource")
		ObjectInputStream input = new ObjectInputStream(inputFile);
		OrderList savedOrders = (OrderList) input.readObject();
		return savedOrders;
	}
	
}
