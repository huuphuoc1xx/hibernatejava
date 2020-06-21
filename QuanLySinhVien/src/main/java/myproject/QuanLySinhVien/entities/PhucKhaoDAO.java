package myproject.QuanLySinhVien.entities;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PhucKhaoDAO {
	public static boolean add(PhucKhao pk) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try {
				session.saveOrUpdate(pk);
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
