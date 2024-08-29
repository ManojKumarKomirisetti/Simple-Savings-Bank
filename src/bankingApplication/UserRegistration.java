package bankingApplication;

import java.util.*;
import java.sql.*;
import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;

public class UserRegistration {
	
	static Connection connect;
	static PreparedStatement pst;
	static Scanner sc = new Scanner(System.in);
	
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
			String Query = "INSERT INTO Customers (CustomerID,FirstName,LastName,DateofBirth,Address,PhoneNumber, Email, Gender, AccountType) VALUES (?,?,?,?,?,?,?,?,?)";
	    	 pst = connect.prepareStatement(Query);
	    	
	    
	    	       
	    	        int  CustID = CustomerId.customerIdVal();
	    	        
	    	        System.out.println("Enter FirstName:");
	    	        String FName = sc.nextLine();
	    	        
	    	        System.out.println("Enter  LastName:");
	    	        String LName = sc.nextLine();
	    	        
	    	        System.out.println("Enter  DataOfBirth:");
	    	        String DOB = sc.nextLine();
	    	  
	    	        System.out.println("Enter   Address:");
	    	        String Addr = sc.nextLine();
	    	        
	    	        System.out.println("Enter   PhoneNumber:");
	    	        String PNumber = sc.nextLine();
	    	        
	    	        System.out.println("Enter Email:");
	    	        String Email = sc.nextLine();
	    	        
	    	        System.out.println("Enter Gender:");
	    	        String Gender = sc.nextLine();
	    	        
	    	        System.out.println("Enter AccountType:");
	    	        String AccType = sc.nextLine();
	    	        
	    	        
	    	        pst.setInt(1, CustID);
	    	        pst.setString(2, FName);
	    	        pst.setString(3, LName);
	    	        pst.setDate(4, Date.valueOf(DOB));
	    	        pst.setString(5, Addr);
	    	        pst.setString(6, PNumber);
	    	        pst.setString(7, Email);
	    	        pst.setString(8, Gender);
	    	        pst.setString(9, AccType);
	    	        
	    	        pst.executeUpdate();
	    	        
	    	        String AccQuery ="insert into Accounts (AccountNumber,CustomerId) values(?,?)" ;
	    	        
	    	        pst=null;
	    	        
	    	        pst = connect.prepareStatement(AccQuery);
	    	        
	    	        String AccNum = AccountNumber.NumberAcc();
	    	        pst.setString(1, AccNum);
	    	        pst.setInt(2, CustID);
	    	        
	    	          pst.executeUpdate();
	    	        
	    	        
	      
	        		System.out.println("Customers CustomerId, please store it = "+CustID);
	        		
	        		ResultSet Rs = null;
	          	 
	          	 String DataQuery = "Select  CustomerId, AccountNumber from Accounts ";
	          	 
	          	  pst = connect.prepareStatement(DataQuery);
	          	 
	          	  Rs = pst.executeQuery();
	          	 
	          	  while(Rs.next()) 
	          	  {
	          		  if(Rs.getInt("CustomerId") == CustID)
	          		
	          		System.out.print("AccountNumber, Please Save it :    "+Rs.getString("AccountNumber"));
	          		  
	          	  }
	          	  
	          	  String Passwrd = PasswordGenerator.pass();
	          	  
	          	String QueryPass = "INSERT INTO  Authentication (AccountNumber,CustomerId,SystemPassword) VALUES (?,?,?)";
		    	
	          	pst = null; 
	          	
	          	pst = connect.prepareStatement(QueryPass);
	          	
		    	pst.setString(1, AccNum);
		    	pst.setInt(2, CustID);
		    	pst.setString(3, Passwrd);
		    	 
		    	pst.executeUpdate();
		    	
	          System.out.println("\n"+"Password, Please Save it :    "+Passwrd);
	          		  
	       
		    	System.out.println("\n"+"THANKYOU!");
	        		connect.close();
	    	sc.close();
	        
		}
		
	public static void main(String[] args) throws SQLException
	{
	
		System.out.println("Welcome to Registration:"+"\n");
		userData();

	}
	

}
