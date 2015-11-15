package org.thinkadv.d2dzone.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The Class UserInfo.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)	
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserInfoKey userInfoKey;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The password. */
	private String password;

	/**
	 * Instantiates a new user info.
	 */
	public UserInfo() {

	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public UserInfoKey getUserInfoKey() {
		return userInfoKey;
	}

	public void setUserInfoKey(UserInfoKey userInfoKey) {
		this.userInfoKey = userInfoKey;
	}

}
