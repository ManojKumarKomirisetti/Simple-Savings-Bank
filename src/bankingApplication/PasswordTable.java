package bankingApplication;
import java.sql.*;
//Password
public class PasswordTable {
	
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
			String createTbl = "CREATE TABLE Authentication ("
			        + "    AccountNumber VARCHAR(20) PRIMARY KEY,"
			        + "    CustomerID INT,"
			        + "SystemPassword varchar2(13),"
			        + "UserPassword varchar2(20)" + ")";
			       
			stat.execute(createTbl);

		}

		public static void main(String[] args) throws SQLException
		
		{
			createTable();
		}

	}
