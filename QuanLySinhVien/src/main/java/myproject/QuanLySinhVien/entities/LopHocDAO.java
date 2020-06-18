package myproject.QuanLySinhVien.entities;
// Generated Jun 17, 2020 9:35:46 AM by Hibernate Tools 5.4.14.Final

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Home object for domain model class LopHoc.
 * @see LopHoc
 * @author Hibernate Tools
 */
public class LopHocDAO {
	
	@SuppressWarnings("unchecked")
	public static List<LopHoc> getAll() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<LopHoc> ds = null;
		try {
			String hql = "select lh from myproject.QuanLySinhVien.entities.LopHoc lh";
			ds = session.createQuery(hql).getResultList();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}

		return ds;
	}

	public static boolean addClass(List<LopHoc> list) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try {
			for(LopHoc hs:list)
				session.saveOrUpdate(hs);
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
	
	public static boolean addClass(LopHoc ls) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try {
				session.saveOrUpdate(ls);
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
