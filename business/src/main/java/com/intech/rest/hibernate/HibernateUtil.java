package com.intech.rest.hibernate;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Session getSession() throws HibernateException {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
		return sessionFactory.openSession();

	}

	public static <T> void save(T object) {

		Session session = getSession();
		Transaction transaction = session.beginTransaction();

		try {

			session.save(object);
			transaction.commit();

		} finally {
			session.close();
			shutdown();
		}

	}

	public static <T> void saveAll(List<T> objects) {

		Session session = getSession();
		Transaction transaction = session.beginTransaction();

		try {
			for (Object obj : objects) {
				session.save(obj);
			}
			transaction.commit();

		} finally {
			session.close();
			shutdown();
		}

	}

	public static <T> Object get(Class<T> clazz, Integer id) {

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Object obj = null;
		try {
			obj = session.get(clazz, id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			shutdown();
			return obj;
		}

	}

	public static <T> Object get(Class<T> clazz, UUID id) {

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Object obj = null;
		try {
			obj = session.get(clazz, id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			shutdown();
			return obj;
		}

	}

	public static <T> void delete(T object) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(object);
			transaction.commit();
		} finally {
			session.close();
			shutdown();
		}

	}

	public static <T> void update(T object) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(object);
			transaction.commit();
		} finally {
			session.close();
			shutdown();
		}

	}

	public static <T> List<T> findAll(T object) {
		Session session = getSession();
		// Transaction transaction = session.beginTransaction();
		// List<T> list = new ArrayList<T>();
		List<T> list = null;
		// Object obj = null;
		try {
			list = session.createCriteria(object.getClass()).list();
			// obj = session.get(clazz, id);
			// transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			shutdown();
			return list;
		}

	}

	public static void shutdown() {
		sessionFactory.close();
	}
}
