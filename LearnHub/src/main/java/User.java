
public abstract class User {
	
	
	private int id;
    private String last_name;
    private String first_name;
    private String email;
    private String password;
    private String userType;
    
    
    
    public User() {
    }
    
    
    public User(int id, String email, String first_name,  String last_name) {
    	this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
    }
    
    //getter setter
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	

	
    
}
