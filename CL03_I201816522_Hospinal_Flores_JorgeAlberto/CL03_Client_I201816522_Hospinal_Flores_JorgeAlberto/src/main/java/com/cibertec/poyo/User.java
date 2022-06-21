package com.cibertec.poyo;

import java.io.Serializable;

/**
 * @author Josue
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String picture;
	private String userName;

	public User() {
	}
	

	public User(Integer id, String email, String firstName, String lastName, String password, String picture,
			String userName) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.picture = picture;
		this.userName = userName;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}