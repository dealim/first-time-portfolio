package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	
	public Insert(String name, String password) {
		Connection connection = null;

		try {
			//Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into person values('"+name+"', '"+password+"' )");
			connection.close();	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}
}
