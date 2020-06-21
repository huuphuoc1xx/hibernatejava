package myproject.QuanLySinhVien.entities;

import org.hibernate.HibernateException;
import org.hibernate.Session;


public class AccountDAO {

	public static Account getAccount(String user) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			Account res=session.get(Account.class, user);
			return res;
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}
		return null;
	}

}
