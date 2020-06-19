package myproject.QuanLySinhVien.entities;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MonHocDAO {
	
	public static boolean addSubject(List<MonHoc> list) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try {
			for(MonHoc mh:list)
				session.saveOrUpdate(mh);
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
	

	public static List<MonHoc> getByClass(String Lop){
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<MonHoc> ds = null;
		try {
			String hql = "select mh from ThoiKhoaBieu tkb left join MonHoc mh on tkb.id.maMon=mh.maMon where MaLop=:Lop";
			ds = session.createQuery(hql).setParameter("Lop", Lop).getResultList();
		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			session.close();
		}

		return ds;
	}
	

}
