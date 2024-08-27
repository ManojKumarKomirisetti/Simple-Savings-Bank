package bankingApplication;
import java.sql.*;
//import java.util.Scanner;
public class SavingsBankCreation {
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
		String createTbl = "create table SimpleSavings( Name varchar2(25),AccountNumber varchar2(15), Balance number )";
		stat.execute(createTbl);
	}

	public static void main(String[] args) throws SQLException
	
	{
		createTable();
	}

}
