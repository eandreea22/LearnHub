

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

@WebServlet("/AdminCourses")
public class AdminCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		

		request.setAttribute("mesaj", " ");
		request.setAttribute("mesaj1", " ");
		
		PrintWriter out = response.getWriter();
		
		String submitValue = request.getParameter("submit");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnhub", "root", "root");
			
			String query = "SELECT * FROM courses";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
	        
	        StringBuilder htmlTable = new StringBuilder();
            htmlTable.append("<table>");
            htmlTable.append("<tr>");
            htmlTable.append("<th>ID</th>");
            htmlTable.append("<th>Name</th>");
            htmlTable.append("<th>Name Teacher</th>");
            htmlTable.append("</tr>");

	            while (resultSet.next()) {
	            	
	            	int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                String teacher = resultSet.getString("teacher");
	                
	                htmlTable.append("<tr>");
	                htmlTable.append("<td>").append(id).append("</td>");
	                htmlTable.append("<td>").append(name).append("</td>");
	                htmlTable.append("<td>").append(teacher).append("</td>");
	                htmlTable.append("</tr>");
	            	
	            }
	          
	            htmlTable.append("</table>");

	            request.setAttribute("htmlTable", htmlTable.toString());
	            
	            
			
			
			if ("Delete".equals(submitValue)) {
				
				int id = Integer.parseInt(request.getParameter("id"));
	            
				PreparedStatement st1 = connection.prepareStatement("delete from courses where id=?");
				st1.setInt(1, id);
				int rowCount1 = st1.executeUpdate();
				if(rowCount1>0) {
					request.setAttribute("mesaj1", "Done");
				}else {
					request.setAttribute("mesaj1", "Error! Try again");
				}
				
	        } else if ("Add".equals(submitValue)) {
	        	

	    		String name = request.getParameter("name");
	    		String teacher = request.getParameter("teacher");
	    		
	            
	        	PreparedStatement st = connection.prepareStatement("insert into courses(`name`, `teacher`)"
						+ "values (?, ?) ");
				st.setString(1, name);
				st.setString(2, teacher);
				
				int rowCount = st.executeUpdate();
				if(rowCount>0) {
					request.setAttribute("mesaj", "Done");


			        
				}else {
					request.setAttribute("mesaj", "Error! Try again");
				}
	        }
			
	        request.getRequestDispatcher("admin_courses.jsp").forward(request, response);

			
		}catch(Exception e){
			out.println("error: " + e.getMessage());
			
		}
		
		
		
		
		
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
