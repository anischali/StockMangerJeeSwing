package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataBase {

	private Connection connect;
	
	public DataBase() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		if (connect == null)
		{
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/gdb", "stockuser", "password");
		}
	}
	
	public boolean execute(String sql) throws Exception {
		Statement stmt = connect.createStatement();
		return stmt.execute(sql);
	}
	
	public ResultSet executeAndGet(String sql) throws Exception
	{
		Statement stmt = connect.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		return result;
	}
}
