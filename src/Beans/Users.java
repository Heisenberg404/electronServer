package Beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "usersServer")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id_users;

	public Users(Integer id_users, String username, String pass, String complete_name, String last_name, String email,
			int number) {
		super();
		this.id_users = id_users;
		this.username = username;
		this.pass = pass;
		this.complete_name = complete_name;
		this.last_name = last_name;
		this.email = email;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Users [id_users=" + id_users + ", username=" + username + ", pass=" + pass + ", complete_name="
				+ complete_name + ", last_name=" + last_name + ", email=" + email + ", number=" + number + "]";
	}

	public Users() {

	}

	public Integer getId_users() {
		return id_users;
	}

	public void setId_users(Integer id_users) {
		this.id_users = id_users;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getComplete_name() {
		return complete_name;
	}

	public void setComplete_name(String complete_name) {
		this.complete_name = complete_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private String username;

	private String pass;

	private String complete_name;

	private String last_name;

	private String email;

	private int number;

}
