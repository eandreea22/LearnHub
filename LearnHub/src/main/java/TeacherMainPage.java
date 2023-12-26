

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
 * Servlet implementation class TeacherMainPage
 */

@WebServlet("/TeacherMainPage")
public class TeacherMainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String submitValue = request.getParameter("submit");
		request.setAttribute("courseNameP", " ");
		int idcourse = 0;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnhub", "root", "root");
			
			if("Load Courses".equals(submitValue)) {
				
				request.setAttribute("mesajhw", "");
				
				String query = "SELECT * FROM courses";
		        PreparedStatement statement = connection.prepareStatement(query);
		        ResultSet resultSet = statement.executeQuery();
		        
		        StringBuilder htmlTable = new StringBuilder();
	            htmlTable.append("<table>");
	            htmlTable.append("<tr>");
	            htmlTable.append("<th>Name</th>");
	            htmlTable.append("</tr>");

		            while (resultSet.next()) {
		            	
		                String name = resultSet.getString("name");
		                
		                htmlTable.append("<tr>");
		                htmlTable.append("<td>").append(name).append("</td>");
		                htmlTable.append("</tr>");
		            	
		            }
		          
		            htmlTable.append("</table>");
		            request.setAttribute("htmlTable", htmlTable.toString());
			        request.getRequestDispatcher("teacher_mainPage.jsp").forward(request, response);
			       
			        
			}else if("Show course".equals(submitValue)) {
				
				//show course name
				
				HttpSession session = request.getSession();
			    int idTeacher = (int) session.getAttribute("idteacher");
			    
			    
				String query1 = "SELECT * FROM courses WHERE idTeacher=" + idTeacher + " and name='" + request.getParameter("nameCourse")+ "';";
				PreparedStatement statement1 = connection.prepareStatement(query1);
		        ResultSet resultSet1 = statement1.executeQuery();
		        

		        
		        
		        if(idTeacher!=0) {
		        	while (resultSet1.next()) {
		            	
		        		idcourse = resultSet1.getInt("id");
					    request.setAttribute("courseNameP", resultSet1.getString("name"));
					    
		            }
		        }else {
		        	response.sendRedirect("errorPage.jsp");
		        	
		        }
		        
		     
		        //show students in course
		        
		        String q1 = "SELECT * FROM coursestudents WHERE idcourse=" + idcourse + ";";
				PreparedStatement st1 = connection.prepareStatement(q1);
		        ResultSet rs1 = st1.executeQuery();
		        
		        
		        StringBuilder tableStudents = new StringBuilder();
	        	tableStudents.append("<table>");
	        	tableStudents.append("<tr>");
	        	tableStudents.append("<th>Name student</th>");
	        	tableStudents.append("</tr>");
	        	
		        while(rs1.next()) {
		        	
		        	String q2 = "select * from users where id=" + rs1.getInt("idstudent") + ";";
		        	PreparedStatement st2 = connection.prepareStatement(q2);
		        	ResultSet rs2 = st2.executeQuery();
		        	
		        	while(rs2.next()) {
		        		
		        		String name1 = rs2.getString("last_name") + " " + rs2.getString("first_name");
		        		tableStudents.append("<tr>");
		        		tableStudents.append("<td>").append(name1).append("</td>");
		        		tableStudents.append("</tr>");
		        	}
		        	
		        	tableStudents.append("</table>");
		            request.setAttribute("tableStudents", tableStudents.toString());
		        	
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
//		        RequestDispatcher dispatcher = request.getRequestDispatcher("teacher_mainPage.jsp");
//				dispatcher.forward(request, response);
		        request.setAttribute("divCourse", true);
		        request.getRequestDispatcher("teacher_mainPage.jsp").forward(request, response);
			}
			
			
//			String linkSupport = request.getParameter("support");
//			if(linkSupport !=null && linkSupport.equals("Support")) {
//				HttpSession session = request.getSession();
//			    int idTeacher = (int) session.getAttribute("idteacher");
//			    
//			    session.setAttribute("iduser", idTeacher);	
////				
//				request.setAttribute("iduser", idTeacher);
////
//				RequestDispatcher dispatcher = request.getRequestDispatcher("support.jsp");
//				dispatcher.forward(request, response);
//				
//			}
//			
//			
					
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
