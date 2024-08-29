package bankingApplication;
import java.util.*;
import java.sql.*;

public class LoginPage {
	static Scanner sc = new Scanner(System.in);
	static Connection connect;
	static PreparedStatement pst;
	
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
	
	
	public static void rePageLogin() throws SQLException
	{
		System.out.println("Enter New Password:");
		String Pass = sc.nextLine();
		
		System.out.println("ReEnter New Password:");
		String Pass1 = sc.nextLine();
		
		if(Pass.equals(Pass1))
		{
			String QueryPass = " insert into Authentication (UserPassword) values(?) where SystemPassword = ?";
			pst=connect.prepareStatement(QueryPass);
			pst.setString(4,Pass1);
			
		}
		
	}
	

	public static void pageLogin() throws SQLException
	{
		System.out.println("Login/New User:");
		String NewAcc = sc.nextLine();
		
		if(NewAcc.equals("Login"))
		{
			System.out.println("Enter CustomerId:");
			int CustID = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter Password:");
			String SystemPass = sc.nextLine();
			
			String Query = " Select SystemPassword from Authentication where CustomerId ="+ "";
			pst = connect.prepareStatement(Query);
			ResultSet rs = null;
			rs=pst.executeQuery();
			String Pass = rs.getString(2,CustID);
			
			if(SystemPass.equals(Pass))
			{
				rePageLogin();
			}
			else
			{
				System.out.println("Wrong Password:");
			}
			
		}
		else if(NewAcc.equals("New User"))
		{
//			UserRegistration us = new UserRegistration();
			UserRegistration.userData();
		}
		
sc.close();
	}
	
	public static void main(String[] args)throws SQLException {
		
		System.out.println("Welcome to SimpleSavings Bank"+"\n"+"\n"+"\n");
		
		pageLogin();
	}

}
