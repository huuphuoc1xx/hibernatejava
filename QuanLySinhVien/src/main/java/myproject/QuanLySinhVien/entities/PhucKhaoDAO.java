package myproject.QuanLySinhVien.entities;

import java.util.List;

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

	public static List<PhucKhao> getBySubject(String mon) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<PhucKhao> ds = null;
		try {
			String hql = "select pk from PhucKhao pk where pk.id.maMh=:maMon";
			ds = session.createQuery(hql).setParameter("maMon", mon).getResultList();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return ds;
	}
}
