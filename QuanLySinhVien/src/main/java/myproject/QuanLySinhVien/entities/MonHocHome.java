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
 * Home object for domain model class MonHoc.
 * @see myproject.QuanLySinhVien.entities.MonHoc
 * @author Hibernate Tools
 */
public class MonHocHome {

	private static final Logger logger = Logger.getLogger(MonHocHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MonHoc transientInstance) {
		logger.log(Level.INFO, "persisting MonHoc instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MonHoc instance) {
		logger.log(Level.INFO, "attaching dirty MonHoc instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(MonHoc instance) {
		logger.log(Level.INFO, "attaching clean MonHoc instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(MonHoc persistentInstance) {
		logger.log(Level.INFO, "deleting MonHoc instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public MonHoc merge(MonHoc detachedInstance) {
		logger.log(Level.INFO, "merging MonHoc instance");
		try {
			MonHoc result = (MonHoc) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public MonHoc findById(java.lang.String id) {
		logger.log(Level.INFO, "getting MonHoc instance with id: " + id);
		try {
			MonHoc instance = (MonHoc) sessionFactory.getCurrentSession()
					.get("myproject.QuanLySinhVien.entities.MonHoc", id);
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

	public List findByExample(MonHoc instance) {
		logger.log(Level.INFO, "finding MonHoc instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("myproject.QuanLySinhVien.entities.MonHoc")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
