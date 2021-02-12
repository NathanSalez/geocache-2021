package org.ig2i.geocache.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Collection;

/**
 * Représente un DAO utilisant comme source de données une bdd.
 * @author user
 * @param <T> TODO
 */
public abstract class JpaDao<T> implements DAO<T> {

    protected SessionFactory sessionFactory;

    protected Session session;

    protected Class<T> entite;

    /**
     * Constructeur par données.
     * @param
     */
    public JpaDao(Class<T> entite) {
        this.entite = entite;
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public boolean create(T obj) {
        try {
            Transaction t = session.beginTransaction();
            session.persist(obj);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean update(T obj) {
        try {
            Transaction t = session.beginTransaction();
            session.merge(obj);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(T obj) {
        try {
            Transaction t = session.beginTransaction();
            session.remove(obj);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public void close() {
        if (session != null) {
            session.close();
        }

        if (sessionFactory != null) {
            this.sessionFactory.close();
        }
    }

    @Override
    public T find(Integer id) {
        return session.find(entite, id);
    }

    @Override
    public Collection<T> findAll() {
        Query query = session.createQuery("FROM " + entite.getName());
        return query.getResultList();
    }

    @Override
    public boolean deleteAll() {
        try {
            Transaction t = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM " + entite.getName());
            query.executeUpdate();
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
