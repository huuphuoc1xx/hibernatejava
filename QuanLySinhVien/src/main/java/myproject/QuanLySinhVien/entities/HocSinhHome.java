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
 * Home object for domain model class HocSinh.
 * @see myproject.QuanLySinhVien.entities.HocSinh
 * @author Hibernate Tools
 */
public class HocSinhHome {

	private static final Logger logger = Logger.getLogger(HocSinhHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(HocSinh transientInstance) {
		logger.log(Level.INFO, "persisting HocSinh instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HocSinh instance) {
		logger.log(Level.INFO, "attaching dirty HocSinh instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(HocSinh instance) {
		logger.log(Level.INFO, "attaching clean HocSinh instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(HocSinh persistentInstance) {
		logger.log(Level.INFO, "deleting HocSinh instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public HocSinh merge(HocSinh detachedInstance) {
		logger.log(Level.INFO, "merging HocSinh instance");
		try {
			HocSinh result = (HocSinh) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public HocSinh findById(int id) {
		logger.log(Level.INFO, "getting HocSinh instance with id: " + id);
		try {
			HocSinh instance = (HocSinh) sessionFactory.getCurrentSession()
					.get("myproject.QuanLySinhVien.entities.HocSinh", id);
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

	public List findByExample(HocSinh instance) {
		logger.log(Level.INFO, "finding HocSinh instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("myproject.QuanLySinhVien.entities.HocSinh").add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
