
public class Student extends User{
	
	private int uni_year;
    private String specialisation;
    private String group;
    private String university;

  
    public Student() {
    	
    }
    
    public Student(int id, String email, String first_name, String last_name) {
		super(id, email, first_name, last_name);
		// TODO Auto-generated constructor stub
	}




	//getter setter
	public int getUni_year() {
		return uni_year;
	}



	public void setUni_year(int uni_year) {
		this.uni_year = uni_year;
	}



	public String getSpecialisation() {
		return specialisation;
	}



	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}


	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}
    
    
}
