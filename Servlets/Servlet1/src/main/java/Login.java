

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String OrgPass = "Manoj";
		PrintWriter out = response.getWriter();
//		String Pass = (String)request.getAttribute("P");
//		String Uname = (String)request.getAttribute("UN");
		
		ServletContext context = request.getServletContext();
		
		String Pass = (String)context.getAttribute("P");
		String Uname = (String)context.getAttribute("UN");
		
		if(OrgPass.equals(Pass))
		{
			out.println(Uname);
		}
		
		
	}

}
