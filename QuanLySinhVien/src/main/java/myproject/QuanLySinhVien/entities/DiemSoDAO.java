package myproject.QuanLySinhVien.entities;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DiemSoDAO {

	public static boolean addScore(List<DiemSo> list) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try {
			for(DiemSo ds:list)
				session.saveOrUpdate(ds);
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
	

	public static boolean addScore(DiemSo ds) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try {
				session.save(ds);
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


	public static boolean deleteScore(DiemSo ds) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try {
				session.delete(ds);
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
