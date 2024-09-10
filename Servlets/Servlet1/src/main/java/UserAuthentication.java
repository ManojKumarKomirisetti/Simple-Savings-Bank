

import java.io.IOException;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;

@WebServlet("/UserAuthentication")

public class UserAuthentication  extends HttpServlet {
    
    public UserAuthentication () {
        super();
        
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter User Name:");
		String Uname = sc.nextLine();
		System.out.println("Enter Password:");
		String Pass = sc.nextLine();
		//System.out.println("Sucessfull:"+Pass);
		sc.close();
//		RequestDispatcher rd = request.getRequestDispatcher("/Login");
//		request.setAttribute("P",Pass);
//		request.setAttribute("UN", Uname);
//		rd.include(request, response);
		
		ServletContext context = request.getServletContext();
		context.setAttribute("UN",Uname);
		context.setAttribute("P",Pass);
				
		
	}

}
