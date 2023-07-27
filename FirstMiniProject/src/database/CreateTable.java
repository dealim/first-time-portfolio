package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	
	public static void main(String[] args) {
		new CreateTable();
	}
	
	public CreateTable() {
		Connection connection = null;

		try {
			//Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();

			statement.executeUpdate("drop table if exists person");
			statement.executeUpdate("create table person (name text, password text)");
			statement.executeUpdate("insert into person values('kim', '123321')");
			statement.executeUpdate("insert into person values('hanna' , '321321')");
			connection.close();	
		}
		catch(SQLException e)
		{
			System.err.println(e.getMessage());
		}
	}
}
