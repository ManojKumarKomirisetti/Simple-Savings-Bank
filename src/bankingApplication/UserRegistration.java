package bankingApplication;

import java.util.*;
import java.sql.*;

public class UserRegistration {

	static Connection connect;

	static
	{
		 try
	     {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         //Creating the Connection
	         connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ManojKumarOracle","9347287432");
	             System.out.println("Connection Created:"+connect);
	     }
	     catch(ClassNotFoundException e)
	     {
	         e.printStackTrace();
	     }
	     catch(SQLException e)
	     {
	         e.printStackTrace();
	     }
	}

		public static void  createTable() throws SQLException
		{
			Statement stat = connect.createStatement(); 
			String createTbl = "create table CurrentAccount( Name varchar2(25),AccountNumber varchar2(15), Balance number )";
			stat.execute(createTbl);
		}
		
	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		

	}

}
