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


	public static boolean deleteScore(DiemSo ds) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try {
				if(session.get(DiemSo.class, ds.getId()) != null)
				{
					session.clear();
					session.delete(ds);
				}else
					throw new Exception("Student not join this subject");
				transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return false;
		}
		finally {
			session.close();
		}
		
		return true;
		
	}


	public static List<DiemSo> getBySubject(String Mon){
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<DiemSo> ds = null;
		try {
			String hql = "select ds from DiemSo ds where MaMh=:Mon";
			ds = session.createQuery(hql).setParameter("Mon", Mon).getResultList();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return ds;
	}


	public static List<DiemSo> getBySinhVien(int mssv) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<DiemSo> ds = null;
		try {
			String hql = "select ds from DiemSo ds where Mssv=:mssv";
			ds = session.createQuery(hql).setParameter("Mssv", mssv).getResultList();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return ds;
	}
}
