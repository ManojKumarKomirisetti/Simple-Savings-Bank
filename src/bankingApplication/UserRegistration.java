package bankingApplication;

import java.util.*;
import java.sql.*;

public class UserRegistration {
	
	/* CREATE TABLE Accounts (
    AccountNumber VARCHAR(20) PRIMARY KEY,
    CustomerID VARCHAR(20),
    AccountType VARCHAR(20),
    AccountBalance DECIMAL(15, 2),
    DateOfAccountCreation DATE,
    BranchID INT,
    AccountStatus VARCHAR(10),
    InterestRate DECIMAL(5, 2),
    MinimumBalanceRequirement DECIMAL(15, 2),
    OverdraftLimit DECIMAL(15, 2),
    NomineeName VARCHAR(100),
    LastTransactionDate DATE,
    CurrencyType VARCHAR(3),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
    
); */

	static Connection connect;
	static PreparedStatement pst;
	static Scanner sc = new Scanner(System.in);
	//static CustomerId ci = new CustomerId();
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

		public static void  userData() throws SQLException
		{
			String Query = "INSERT INTO Accounts (AccountNumber, CustomerID, AccountType, NomineeName) VALUES (?,?,?,?)";
	    	PreparedStatement pst = connect.prepareStatement(Query);
	    	
	    	
	    	
	    	for(int j =0; j<3;j++)
	    	{
	    		 
	    	        
	    	       String AccountNum = AccountNumber.NumberAcc();
	    	       
	    	        int  CustomerID = CustomerId.customerIdVal();
	    	        
	    	        System.out.println("Enter AccountType:");
	    	        String AccountType = sc.nextLine();
	    	        
	    	        System.out.println("Enter Customer Nominee Name:");
	    	        String NomineeName = sc.nextLine();
	    	        sc.nextLine();
	    	        
	    	        pst.setString(1, AccountNum);
	    	        pst.setInt(2, CustomerID);
	    	        pst.setString(3, AccountType);
	    	        pst.setString(4, NomineeName);
	    	        int i = pst.executeUpdate();
	    	        
	        		System.out.println("Added Successfully! and Records Updated::"+i);
	    	        
	    	}
	    	sc.close();
	        
		}
		
	public static void main(String[] args) throws SQLException
	{
	
		System.out.println("Welcome to Registration:"+"\n");
		userData();

	}
	

}
