

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DatabaseOperations
 */
@WebServlet("/DatabaseOperations")
public class DatabaseOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;

    static Connection connect = null;
	static PreparedStatement pst = null;
    static ResultSet rs = null;
    
    public DatabaseOperations() 
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
		
		init();
		PrintWriter out = response.getWriter();
		String Name = request.getParameter("uname");
		String Roll = request.getParameter("roll");
		String City = request.getParameter("city");
		String Pin = request.getParameter("pin");
		
		
		
		String Query = "insert into student values(?,?,?,?)";
		
		try {
			pst = connect.prepareStatement(Query);
			pst.setString(1,Name);
			pst.setString(2,Roll);
			pst.setString(3,City);
			pst.setString(4,Pin);
			
			pst.executeUpdate();
			
		} 
		
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			 
		}
		
				
		
		
		
	}

}
