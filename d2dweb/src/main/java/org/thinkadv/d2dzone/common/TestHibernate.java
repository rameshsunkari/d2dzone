package org.thinkadv.d2dzone.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thinkadv.d2dzone.dao.UserInfoDAO;
import org.thinkadv.d2dzone.model.UserInfo;
import org.thinkadv.d2dzone.model.UserInfoKey;

public class TestHibernate {
	public static void main(String[] args) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Retreivee
		UserInfoDAO userInfoDao = new UserInfoDAO();
		UserInfoKey userKey = new UserInfoKey();
		userKey.setEmailId("rameshsunkari@gmail.com");
		UserInfo userInfo = new UserInfo();
		userInfo.setUserInfoKey(userKey);
		UserInfo employee = userInfoDao.getUserInfo(userInfo);
		System.out.println(employee.getFirstName());
	}
}
