

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Support
 */

@WebServlet("/Support")
public class Support extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String problem = request.getParameter("problem");
        
		try {
			
			HttpSession session = request.getSession();
		    int iduser = (int) session.getAttribute("iduser");
		    System.out.print(iduser);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnhub", "root", "root");
			
	    	PreparedStatement st = connection.prepareStatement("insert into problems "
					+ "values (?,?);");
			st.setInt(1, iduser);
			st.setString(2, problem);
			
			st.executeUpdate();
			System.out.print("ok");
			request.setAttribute("mesaj", "done");
			request.getRequestDispatcher("support.jsp").forward(request, response);
			
		}catch(Exception e) {
			
		}
		
		
		
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
