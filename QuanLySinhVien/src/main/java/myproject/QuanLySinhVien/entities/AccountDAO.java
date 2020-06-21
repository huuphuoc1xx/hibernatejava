package myproject.QuanLySinhVien.entities;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AccountDAO {

	public static Account getAccount(String user) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			Account res=(Account) session.get("myproject.QuanLySinhVien.entities.Account", user);
			return res;
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public static boolean changeAccount(Account acc) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try {
				session.update(acc);
				transaction.commit();
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
		finally {
			session.close();
		}
		
		return true;
		
	}

}
