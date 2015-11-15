package org.thinkadv.d2dzone.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONObject;
import org.thinkadv.d2dzone.dao.UserInfoDAO;
import org.thinkadv.d2dzone.model.UserInfo;
import org.thinkadv.d2dzone.model.UserInfoKey;

/**
 * The Class UserInfoController.
 */
@Path("user")
public class UserInfoController {

	/** The user info dao. */
	private UserInfoDAO userInfoDao;

	/**
	 * Check login.
	 *
	 * @param loginStr
	 *            the login str
	 * @return the response
	 */
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkLogin(String loginStr) {

		String output = null;
		int status = 200;
		UserInfo userInfo = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JSONObject jsonObj = new JSONObject(loginStr);
			String emailId = jsonObj.has("emailId")?jsonObj.getString("emailId"):null;
			String mobile = jsonObj.has("mobile")?jsonObj.getString("mobile"):null;
			UserInfoKey userKey = new UserInfoKey(emailId,mobile);
			userInfo = objectMapper.readValue(loginStr, UserInfo.class);
			userInfo.setUserInfoKey(userKey);
			UserInfo userInDB = getUserInfoDao().getUserInfo(userInfo);
			if (userInDB == null) {
				status = 404;
				output = "User with given email/mobile doesn't exist in the system";
			} else if (userInfo.getPassword().equals(userInDB.getPassword())) {
				output = "User login successful";
			} else {
				status = 401;
			}

		} catch (Exception e) {
			e.printStackTrace();
			status = 500;
			output = "Exception processing the user signup";
		}
		return processOutput(status, output);

	}

	/**
	 * Sign up.
	 *
	 * @param loginStr
	 *            the login str
	 * @return the response
	 */
	@POST
	@Path("/signup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response signUp(String loginStr) {

		String output = null;
		int status = 200;
		UserInfo userInfo = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JSONObject jsonObj = new JSONObject(loginStr);
			String emailId = jsonObj.has("emailId")?jsonObj.getString("emailId"):null;
			String mobile = jsonObj.has("mobile")?jsonObj.getString("mobile"):null;
			UserInfoKey userKey = new UserInfoKey(emailId,mobile);
			userInfo = objectMapper.readValue(loginStr, UserInfo.class);
			userInfo.setUserInfoKey(userKey);
			if (getUserInfoDao().checkIfUserExists(userInfo)) {
				status = 409;
				output = "User Exists already with the given info";
			} else {
				getUserInfoDao().save(userInfo);
				status = 200;
				output = "User is successfully signed up";
			}

		} catch (Exception e) {
			e.printStackTrace();
			status = 500;
			output = "Exception processing the user signup";
		}
		return processOutput(status, output);

	}

	/**
	 * Process output.
	 *
	 * @param status
	 *            the status
	 * @param output
	 *            the output
	 * @return the response
	 */
	private Response processOutput(int status, String output) {
		return Response.status(status).entity(output).build();
	}

	/**
	 * Gets the user info dao.
	 *
	 * @return the user info dao
	 */
	public UserInfoDAO getUserInfoDao() {
		if (userInfoDao ==  null) {
			userInfoDao = new UserInfoDAO();
		}
		return userInfoDao;
	}

	/**
	 * Sets the user info dao.
	 *
	 * @param userInfoDao
	 *            the new user info dao
	 */
	public void setUserInfoDao(UserInfoDAO userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

}
