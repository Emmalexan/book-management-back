package gr.hua.dit.entity;

public class response {
	User user;
	String message;
	
	
	public response() {
		
	}
	public response(User user, String message) {
		super();
		this.user = user;
		this.message = message;
	}
	public response(String message) {
		super();
	
		this.message = message;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

