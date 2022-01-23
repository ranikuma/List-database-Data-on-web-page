package studyeasy.org.entity;

//Entity class is a class which depich the database table
public class Users {
	private int usersId;
	private String userName;
	private String email;

	public Users(int usersId, String userName, String email) {
		super();
		this.usersId = usersId;
		this.userName = userName;
		this.email = email;
	}

	public Users(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
