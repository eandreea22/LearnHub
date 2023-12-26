

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class AdminUsers
 */

@WebServlet("/AdminUsers")
public class AdminUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		request.setAttribute("mesaj", " ");
		request.setAttribute("mesaj1", " ");
		
		PrintWriter out = response.getWriter();
		
		String submitValue = request.getParameter("submit");
	
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnhub", "root", "root");
			
			String query = "SELECT * FROM users";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
	        
	        StringBuilder htmlTable = new StringBuilder();
            htmlTable.append("<table>");
            htmlTable.append("<tr>");
            htmlTable.append("<th>ID</th>");
            htmlTable.append("<th>Email</th>");
            htmlTable.append("<th>Name</th>");
            htmlTable.append("</tr>");

	            while (resultSet.next()) {
	            	
	            	if(resultSet.getString("userType").equals("student") || resultSet.getString("userType").equals("teacher")) {
	            		int id = resultSet.getInt("id");
		                String email = resultSet.getString("email");
		                String firstName = resultSet.getString("first_name");
		                String lastName = resultSet.getString("last_name");
		                String name = firstName + " " + lastName;
		                
		                htmlTable.append("<tr>");
		                htmlTable.append("<td>").append(id).append("</td>");
		                htmlTable.append("<td>").append(email).append("</td>");
		                htmlTable.append("<td>").append(name).append("</td>");
		                htmlTable.append("</tr>");
	            	}
	            }
	          
	            htmlTable.append("</table>");

	            // Adaugă codul HTML în atributul cererii
	            request.setAttribute("htmlTable", htmlTable.toString());
	            
	            
			
			
			if ("Delete".equals(submitValue)) {
				
				int id = Integer.parseInt(request.getParameter("id"));
	            
				PreparedStatement st1 = connection.prepareStatement("delete from users where id=?");
				st1.setInt(1, id);
				int rowCount1 = st1.executeUpdate();
				if(rowCount1>0) {
					request.setAttribute("mesaj1", "Done");
				}else {
					request.setAttribute("mesaj1", "Error! Try again");
				}
				
	        } else if ("Add".equals(submitValue)) {
	        	

	    		String last_name = request.getParameter("last_name");
	    		String first_name = request.getParameter("first_name");
	    		String email = request.getParameter("email");
	    		String user_type = request.getParameter("user_type");
	            
	        	PreparedStatement st = connection.prepareStatement("insert into users(`email`, `password`, `last_name`, `first_name`, `userType`, `uni_year`, `specialisation`, `group`, `university`)"
						+ "values (?, '', ?, ?, ?, 0 , '', '', '') ");
				st.setString(1, email);
				st.setString(2, last_name);
				st.setString(3, first_name);
				st.setString(4, user_type);
				
				int rowCount = st.executeUpdate();
				if(rowCount>0) {
					request.setAttribute("mesaj", "Done");


			        
				}else {
					request.setAttribute("mesaj", "Error! Try again");
				}
	        }
			
	        request.getRequestDispatcher("admin_users.jsp").forward(request, response);

			
		}catch(Exception e){
			out.println("error: " + e.getMessage());
			
		}
		
        
        
	}

	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	
}
