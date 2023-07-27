package javaStudy;

import java.sql.*;

public class TestJDBC { 
	
	public static void main(String[] args){
		Connection connection = null;

		try {
			//Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:test.db");
			Statement statement = connection.createStatement();

			statement.executeUpdate("drop table if exists person");
			statement.executeUpdate("create table person (id integer, name text)");
			statement.executeUpdate("insert into person values(1, 'kim')");
			statement.executeUpdate("insert into person values(2, 'han')");
			ResultSet rs = statement.executeQuery("select * from person");
			
			while(rs.next())
			{
				System.out.println("id = " + rs.getInt("id"));
				System.out.println("name = " + rs.getString("name"));
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