package org.ig2i.geocache.dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.ig2i.geocache.modele.Cache;

/**
 * Représente un DAO de type Cache utilisant comme source de données une bdd.
 * @author user
 */
public class JpaCacheDao extends JpaDao<Cache> implements CacheDao {

    private static JpaCacheDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaCacheDao() {
        super(Cache.class);
    }

    /**
     * Retourne une instance de JpaCacheDao.
     * @return JpaCacheDao
     */
    public static JpaCacheDao getInstance() {
        if (instance == null) {
            instance = new JpaCacheDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    @Override
    public Collection<Cache> findAll() {
        return super.findAll();
    }

    @Override
    public Cache find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(Cache obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(Cache obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(Cache obj) {
        return super.create(obj);
    }



}
