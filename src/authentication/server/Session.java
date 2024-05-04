package authentication.server;

public class Session {

	private String login;
	private long lastAccessLTime;
	
	
	public Session(String login,long lastAccessTime) {
		this.login= login;
		this.lastAccessLTime=lastAccessTime;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public long getLastAccesssTime() {
		return this.lastAccessLTime;
	}
	
	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessLTime=lastAccessTime;
	}

}
