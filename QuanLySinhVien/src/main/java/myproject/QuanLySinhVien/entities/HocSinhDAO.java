package myproject.QuanLySinhVien.entities;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HocSinhDAO {
	@SuppressWarnings("unchecked")
	public static List<HocSinh> getByClass(String Lop){
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<HocSinh> ds = null;
		try {
			String hql = "select hs from HocSinh hs where MaLop=:Lop";
			ds = session.createQuery(hql).setParameter("Lop", Lop).getResultList();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}

		return ds;
	}

	public static boolean importSinhVien(List<HocSinh> list) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try {
			for(HocSinh hs:list)
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
	
	public static boolean addSinhVien(HocSinh hs) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try {
				session.save(hs);
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

	public static List<HocSinh> getBySubject(String mon) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<HocSinh> ds = null;
		try {
			String hql = "select hs from HocSinh hs, DiemSo ds where hs.mssv=ds.id.mssv and ds.id.maMh=:Mon";
			ds = session.createQuery(hql).setParameter("Mon", mon).getResultList();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}

		return ds;
	}
	
	public static HocSinh getByMssv(int mssv) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		HocSinh hs = null;
		try {
			String hql = "select hs from HocSinh hs where Mssv=:mssv";
			hs=session.get(HocSinh.class,mssv);
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}

		return hs;
	}
}