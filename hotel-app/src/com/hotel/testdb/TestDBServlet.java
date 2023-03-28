package com.hotel.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Connection Begins...");
		String user = "root";
		String pass = "123456";
		String jdbcUrl = "jdbc:mysql://localhost:3306/hotel_order_app?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			System.out.println("Before response...");
			PrintWriter out = response.getWriter();
			System.out.println("After response...");
			out.println("Connecting to database.. "+jdbcUrl);
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection : "+connection);
			out.println("Connection Successfull!!!");
			System.out.println("Inserting Records..");
//			Statement statement = connection.createStatement();
//			String sqlQuery = "insert into hotel_order_app.recipe "
//					+ "(recipe_name, is_available, cost) "
//					+ "values('Roti', 'true', 15);";
//			statement.executeUpdate(sqlQuery);
			connection.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
