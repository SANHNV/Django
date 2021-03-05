package com.django.Models;

public class User {
    
    //#region Private Properties

	private Integer idUser;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String salt;
    private String role;

    //#endregion
    
    //#region Constructor

	/**
	 * @param idUser
	 * @param firstName
	 * @param lastName
	 * @param login
	 * @param password
	 * @param role
	 */
	public User(Integer idUser, String firstName, String lastName, String login, String password, String salt, String role) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.salt = salt;
		this.role = role;
	}

    //#endregion

    //#region Getter & Setter

	/**
	 * @return the idUser
	 */
	public Integer getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
    //#endregion
    
}
