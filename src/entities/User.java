package entities;

import java.io.Serializable;

public class User implements Serializable{

	private long    id;
	private String  firstName;
	private String  lastName;
	private String  login; //email or something else, to make simple
	private String  password;
	
	private String  sessionId=null;
	private boolean connected;
	
	
	// only login, to make it simple for User object creation in ChatClient.java
	public User(String login,String password,String firstName,String lastName,String sessionId,boolean connected) {
			this.id = 0;
			this.firstName = firstName;
			this.lastName = lastName;
			this.login = login;
			this.password = password;
			this.sessionId = sessionId;
			this.connected = connected;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSessionCode() {
		return sessionId;
	}

	public void setSessionCode(String sessionCode) {
		this.sessionId = sessionCode;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
	

}
