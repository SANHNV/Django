package com.django.Models;

import javax.persistence.*;

@Entity
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = {"login"}))
public class User {
    
    //#region Private Properties

    @Id
	private Integer idUser;
    @Basic(optional = false)
    private String firstName;
    @Basic(optional = false)
    private String lastName;
    @Basic(optional = false)
    private String login;
    @Basic(optional = false)
    private String password;
    @Basic(optional = false)
    private String salt;
    @Basic(optional = false)
    private Roles role;

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
	public User(Integer idUser, String firstName, String lastName, String login, String password, String salt, Roles role) {
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
    @Column(name = "idUser", nullable = false)
	public Integer getIdUser() {
		return idUser;
	}

	/**
	 * @return the firstName
	 */
    @Column(name = "firstName", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
    @Column(name = "lastName", nullable = false)
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the login
	 */
    @Column(name = "login", nullable = false)
	public String getLogin() {
		return login;
	}

	/**
	 * @return the password
	 */
    @Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	/**
	 * @return the salt
	 */
    @Column(name = "salt", nullable = false)
	public String getSalt() {
		return salt;
	}

	/**
	 * @return the role
	 */
    @Column(name = "role", nullable = false, columnDefinition = "int default 0")
	public Roles getRole() {
		return role;
	}
	
    //#endregion

}
