
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();



		try {

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			if(email.equals("admin@gmail.com") && password.equals("admin")) {
				
				response.sendRedirect("admin_mainPage.jsp");
				
			}else {
				
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnhub", "root", "root");

				PreparedStatement statement = connection.prepareStatement("select * from users " +
		                "where email='" + email + "' "
		                + "and password='" + password + "';");
				
				ResultSet rs = statement.executeQuery();
				
				
				if (rs.next()) {
					
					if(rs.getString("userType").equals("teacher")) {
						
						HttpSession ses = request.getSession();
						
						ses.setAttribute("idteacher", rs.getInt("id"));	
						ses.setAttribute("iduser", rs.getInt("id"));	
//					
//						// Setează email-ul ca atribut în cadrul cererii
						request.setAttribute("idteacher", rs.getInt("id"));
						request.setAttribute("iduser", rs.getInt("id"));
//
//						// Redirectează către pagina principală
						RequestDispatcher dispatcher = request.getRequestDispatcher("teacher_mainPage.jsp");
						dispatcher.forward(request, response);
						
						
					}else if(rs.getString("userType").equals("student")) {
						
						HttpSession ses = request.getSession();
						
						ses.setAttribute("idstudent", rs.getInt("id"));		
						ses.setAttribute("iduser", rs.getInt("id"));
//					
//						// Setează email-ul ca atribut în cadrul cererii
						request.setAttribute("idstudent", rs.getInt("id"));
						request.setAttribute("iduser", rs.getInt("id"));
//
//						// Redirectează către pagina principală
						RequestDispatcher dispatcher = request.getRequestDispatcher("student_mainPage.jsp");
						dispatcher.forward(request, response);
						
					}
					
					
					
				}else{
					response.sendRedirect("errorPage.jsp");
				}
			}

		

		}catch (Exception e){
            out.println("error: " + e.getMessage());
        }


	}
}


