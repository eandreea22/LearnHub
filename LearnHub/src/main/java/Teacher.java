
public class Teacher extends User{

	
	private String degree;
	
	public Teacher() {
		
	}
	
	public Teacher(int id, String email, String first_name, String last_name) {
			super(id, email, first_name, last_name);
			// TODO Auto-generated constructor stub
		}
	
	//getter setter
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
}
