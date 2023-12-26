

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
import java.sql.ResultSet;

/**
 * Servlet implementation class StudentProfile
 */

@WebServlet("/StudentProfile")
public class StudentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
try{
			
			HttpSession session = request.getSession();
		    int iduser = (int) session.getAttribute("iduser");
		    System.out.print(iduser);
		    
		    Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnhub", "root", "root");
			
			String query = "SELECT * FROM users where id="
					+ iduser + ";";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
		    
	        String pass = "";
	        while(resultSet.next()) {
	        	
	        	pass = resultSet.getString("password"); 
	        	
	        	String email = resultSet.getString("email");
	        	request.setAttribute("email", "Email:  " + email);
	        	
	        	String name = resultSet.getString("last_name") + " " + resultSet.getString("first_name");
	        	request.setAttribute("name", "Name:  " + name);
	        	
	        	String uni = resultSet.getString("university");
	        	request.setAttribute("university", "University:  " + uni);
	        	
	        	String specialisation = resultSet.getString("specialisation");
	        	request.setAttribute("specialisation", "Specialisation:  " + specialisation);
	        	
	        	String year = resultSet.getString("uni_year");
	        	request.setAttribute("year", "Year:  " + year);
	        	
	        	String group = resultSet.getString("group");
	        	request.setAttribute("group", "Group:  " + group);
	        	
	        	
	        }
	        
	        String oldpass = request.getParameter("password");
	        String newpass = request.getParameter("newpassword");
	        
	        if(oldpass.length()!=0 && newpass.length()!=0) {
	        		        	
	        	if(pass.equals(oldpass)) {
	        		
	        		System.out.print("ok");
	        		
	        		PreparedStatement st1 = connection.prepareStatement("update users "
		        			+ "set password=? "
		        			+ "where id=?;");
	        		st1.setString(1, newpass);
					st1.setInt(2, iduser);
					int rowCount1 = st1.executeUpdate();
					
					
					if(rowCount1>0) {
						request.setAttribute("mesaj", "Done!");
					}else {
						request.setAttribute("mesaj", "Error! Try again");
					}
					
	        	}else {
	        		request.setAttribute("mesaj", "current password wrong! Try again");
	        	}
	        	
	        	 
	        }
			
	        request.getRequestDispatcher("student_profile.jsp").forward(request, response);
	       
	        
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
