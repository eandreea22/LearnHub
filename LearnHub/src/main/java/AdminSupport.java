

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class AdminSupport
 */
@WebServlet("/AdminSupport")
public class AdminSupport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnhub", "root", "root");
			
			String query = "SELECT * FROM problems";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
	        
	        StringBuilder htmlTable = new StringBuilder();
            htmlTable.append("<table>");
            htmlTable.append("<tr>");
            htmlTable.append("<th>ID User</th>");
            htmlTable.append("<th>Problem</th>");
            htmlTable.append("</tr>");

	            while (resultSet.next()) {
	            	
	            	int id = resultSet.getInt("iduser");
	                String problem = resultSet.getString("problem");
	                
	                htmlTable.append("<tr>");
	                htmlTable.append("<td>").append(id).append("</td>");
	                htmlTable.append("<td>").append(problem).append("</td>");
	                htmlTable.append("</tr>");
	            	
	            }
	          
	            htmlTable.append("</table>");

	            // Adaugă codul HTML în atributul cererii
	            request.setAttribute("htmlTable", htmlTable.toString());
	            
	            request.getRequestDispatcher("admin_support.jsp").forward(request, response);
			
			
		}catch(Exception e) {
			
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
