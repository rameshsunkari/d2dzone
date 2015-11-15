package org.thinkadv.d2dzone.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserInfoKey  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The email id. */
	private String emailId;

	/** The mobile. */
	private String mobile;

	public UserInfoKey() {

	}

	public UserInfoKey(String emailId, String mobile) {
		super();
		this.emailId = emailId;
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfoKey other = (UserInfoKey) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}

	
}
