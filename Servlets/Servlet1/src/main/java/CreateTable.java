

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateTable")
public class CreateTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static Connection connect = null;
	static PreparedStatement pst = null;
    static ResultSet rs = null;
    
    public CreateTable() 
    {
        super();
    }
    

    public  void init()
    {
   	 try
     {
   		// System.out.println("getConnection");
         Class.forName("oracle.jdbc.driver.OracleDriver");
         connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123");
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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		
		
		
	}

}
