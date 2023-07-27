package javaStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class testJDBC3 {
	
	public static void main(String[] args){
		Connection connection = null;

		try {
			//Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:test.db");
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select * from person");
			while(rs.next())
			{
				System.out.print(rs.getInt("id") + " , ");
				System.out.println(rs.getString("name"));
			}
			rs.close();
			connection.close();	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}
}
