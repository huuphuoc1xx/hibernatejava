package myproject.QuanLySinhVien.entities;
// Generated Jun 17, 2020 9:35:46 AM by Hibernate Tools 5.4.14.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class LopHoc.
 * @see myproject.QuanLySinhVien.entities.LopHoc
 * @author Hibernate Tools
 */
public class LopHocHome {

	private static final Logger logger = Logger.getLogger(LopHocHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(LopHoc transientInstance) {
		logger.log(Level.INFO, "persisting LopHoc instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(LopHoc instance) {
		logger.log(Level.INFO, "attaching dirty LopHoc instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(LopHoc instance) {
		logger.log(Level.INFO, "attaching clean LopHoc instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(LopHoc persistentInstance) {
		logger.log(Level.INFO, "deleting LopHoc instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public LopHoc merge(LopHoc detachedInstance) {
		logger.log(Level.INFO, "merging LopHoc instance");
		try {
			LopHoc result = (LopHoc) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public LopHoc findById(java.lang.String id) {
		logger.log(Level.INFO, "getting LopHoc instance with id: " + id);
		try {
			LopHoc instance = (LopHoc) sessionFactory.getCurrentSession()
					.get("myproject.QuanLySinhVien.entities.LopHoc", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(LopHoc instance) {
		logger.log(Level.INFO, "finding LopHoc instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("myproject.QuanLySinhVien.entities.LopHoc")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
