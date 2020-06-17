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
 * Home object for domain model class DiemSo.
 * @see myproject.QuanLySinhVien.entities.DiemSo
 * @author Hibernate Tools
 */
public class DiemSoHome {

	private static final Logger logger = Logger.getLogger(DiemSoHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(DiemSo transientInstance) {
		logger.log(Level.INFO, "persisting DiemSo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DiemSo instance) {
		logger.log(Level.INFO, "attaching dirty DiemSo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(DiemSo instance) {
		logger.log(Level.INFO, "attaching clean DiemSo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(DiemSo persistentInstance) {
		logger.log(Level.INFO, "deleting DiemSo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public DiemSo merge(DiemSo detachedInstance) {
		logger.log(Level.INFO, "merging DiemSo instance");
		try {
			DiemSo result = (DiemSo) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public DiemSo findById(myproject.QuanLySinhVien.entities.DiemSoId id) {
		logger.log(Level.INFO, "getting DiemSo instance with id: " + id);
		try {
			DiemSo instance = (DiemSo) sessionFactory.getCurrentSession()
					.get("myproject.QuanLySinhVien.entities.DiemSo", id);
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

	public List findByExample(DiemSo instance) {
		logger.log(Level.INFO, "finding DiemSo instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("myproject.QuanLySinhVien.entities.DiemSo")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
