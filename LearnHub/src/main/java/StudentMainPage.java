

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
 * Servlet implementation class StudentMainPage
 */

@WebServlet("/StudentMainPage")
public class StudentMainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String submitValue = request.getParameter("submit");
		request.setAttribute("courseNameP", " ");
		int idcourse = 0;
		HttpSession session = request.getSession();
	    int idStudent = (int) session.getAttribute("idstudent");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnhub", "root", "root");
			
			if("Load Courses".equals(submitValue)) {
				
				String q1 = "SELECT * FROM coursestudents WHERE idstudent=" + idStudent + ";";
				PreparedStatement st1 = connection.prepareStatement(q1);
		        ResultSet rs1 = st1.executeQuery();
		        
		        
		        StringBuilder tableCourses = new StringBuilder();
		        tableCourses.append("<table>");
		        tableCourses.append("<tr>");
		        tableCourses.append("<th>Name Course</th>");
		        tableCourses.append("</tr>");
	        	
		        while(rs1.next()) {
		        	
		        	String q2 = "select * from courses where id=" + rs1.getInt("idcourse") + ";";
		        	PreparedStatement st2 = connection.prepareStatement(q2);
		        	ResultSet rs2 = st2.executeQuery();
		        	
		        	while(rs2.next()) {
		        		
		        		tableCourses.append("<tr>");
		        		tableCourses.append("<td>").append(rs2.getString("name")).append("</td>");
		        		tableCourses.append("</tr>");
		        	}
		        	
		        	tableCourses.append("</table>");
		            request.setAttribute("tableCourses", tableCourses.toString());
		        	
		        }
			    
		        request.getRequestDispatcher("student_mainPage.jsp").forward(request, response);
			       
			        
			}else if("Show course".equals(submitValue)) {
				
				//show course name
			    
				String query1 = "SELECT * FROM courses WHERE" + " name='" + request.getParameter("nameCourse")+ "';";
				PreparedStatement statement1 = connection.prepareStatement(query1);
		        ResultSet resultSet1 = statement1.executeQuery();
		        
		        
		        while (resultSet1.next()) {
	            	
	        		idcourse = resultSet1.getInt("id");
				    request.setAttribute("courseNameP", resultSet1.getString("name"));
				    
	            }
		        
		        
		        
		        //show links
		        
		        String q2 = "SELECT * FROM courselinks WHERE idcourse=" + idcourse + ";";
				PreparedStatement st2 = connection.prepareStatement(q2);
		        ResultSet rs2 = st2.executeQuery();
		        
		        StringBuilder links = new StringBuilder();
		        
		        while(rs2.next()) {
		        	
		        	
		        	 String link = "<a href='" +  rs2.getString("link") + "'>" + rs2.getString("namelink") + "</a><br>";
		             links.append(link);
		        }
		        request.setAttribute("links", links.toString());
		        
		        
		        //show homework
		        
		        String q3 = "SELECT * FROM coursehw WHERE idcourse=" + idcourse + ";";
				PreparedStatement st3 = connection.prepareStatement(q3);
		        ResultSet rs3 = st3.executeQuery();
		        
		        StringBuilder hw = new StringBuilder();
		        
		        while(rs3.next()) {
		        	
		        	 String hw1 = "<p>" + rs3.getString("namehw") + ": "+ rs3.getString("hw") + "</p>";
		             hw.append(hw1);
		        }
		        request.setAttribute("hw", hw.toString());
		        
		        
		        //add hw
		        
		        //show div course
		        request.setAttribute("divCourse", true);
		        request.getRequestDispatcher("student_mainPage.jsp").forward(request, response);
			}
			
			
					
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
