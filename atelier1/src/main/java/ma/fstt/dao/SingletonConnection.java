package ma.fstt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	static Connection connexion =null;
	
	String url = "jdbc:mysql://localhost:3306/db_premiereatelier?useSSL=false";
	String login = "root";
	String password = "";
	private  SingletonConnection () throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		SingletonConnection.connexion =  DriverManager.getConnection(url, login, password);
}
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if(SingletonConnection.connexion == null) {
			new SingletonConnection ();
		}
		return SingletonConnection.connexion;
	}

}
