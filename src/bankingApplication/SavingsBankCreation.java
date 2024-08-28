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
		String createTbl = "CREATE TABLE Accounts ("
		        + "    AccountNumber VARCHAR(20) PRIMARY KEY,"
		        + "    CustomerID INT,"
		        + "    AccountType VARCHAR(20),"
		        + "    AccountBalance DECIMAL(15, 2),"
		        + "    DateOfAccountCreation DATE,"
		        + "    BranchID INT,"
		        + "    AccountStatus VARCHAR(10),"
		        + "    InterestRate DECIMAL(5, 2),"
		        + "    MinimumBalanceRequirement DECIMAL(15, 2),"
		        + "    OverdraftLimit DECIMAL(15, 2),"
		        + "    NomineeName VARCHAR(100),"
		        + "    LastTransactionDate DATE,"
		        + "    CurrencyType VARCHAR(3),"
		        + "    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)"
		        + ")";
		stat.execute(createTbl);

	}

	public static void main(String[] args) throws SQLException
	
	{
		createTable();
	}

}
