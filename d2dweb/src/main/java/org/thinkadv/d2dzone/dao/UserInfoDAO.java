package org.thinkadv.d2dzone.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Transaction;
import org.thinkadv.d2dzone.common.HibernateUtil;
import org.thinkadv.d2dzone.model.UserInfo;


/**
 * The Class UserInfoDAO.
 */
public class UserInfoDAO extends BaseDAO<UserInfo> {

	/**
	 * Instantiates a new user info dao.
	 */
	public UserInfoDAO() {
		super(UserInfo.class);
	}

	/**
	 * Check if user exists.
	 *
	 * @param userInfo the user info
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean checkIfUserExists(UserInfo userInfo) throws Exception {

		UserInfo userInDB = getUserInfo(userInfo);
		return userInDB != null;
	}

	/**
	 * Gets the user info.
	 *
	 * @param userInfo the user info
	 * @return the user info
	 * @throws Exception the exception
	 */
	public UserInfo getUserInfo(UserInfo userInfo) throws Exception {
		StringBuilder query = new  StringBuilder("select * from userinfo where ");
		String criteria = userInfo.getUserInfoKey().getEmailId();

		if (StringUtils.isBlank(criteria)) {
			criteria = userInfo.getUserInfoKey().getMobile();
			query.append("mobile = '").append(criteria);
		} else {
			query.append("emailId = '").append(criteria);
		}
		query.append("'");

		UserInfo userInDB = getEntityByQuery(query.toString());
		
		return userInDB;
	}

}
