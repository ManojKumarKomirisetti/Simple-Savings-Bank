

import java.io.IOException;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/AnnotationServlet")

public class AnnotationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection connect = null;
	static PreparedStatement pst = null;
    static ResultSet rs = null;
    
    public AnnotationServlet() {
        super();


        
    }
    public  void init()
    {
   	 try
     {
   		 System.out.println("getConnection");
         Class.forName("oracle.jdbc.driver.OracleDriver");
         //Creating the Connection
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

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		init();
		PrintWriter out = response.getWriter();		
		out.println(connect);
		out.println("Manoj Kumar");
		
		String Query = "select * from student ";
		try {
			
			pst = connect.prepareStatement(Query);
			rs = pst.executeQuery();
			while(rs.next())
			{
				out.print(rs.getString(1)+" ");
				out.print(rs.getString(2)+" ");
				out.print(rs.getString(3)+" ");
				out.print(rs.getInt(4));
				out.flush();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
