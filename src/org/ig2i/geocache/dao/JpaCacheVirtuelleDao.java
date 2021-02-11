package org.ig2i.geocache.dao;

import java.util.Collection;
import org.ig2i.geocache.modele.CacheVirtuelle;

/**
 * Représente un DAO de type CacheVirtuelle utilisant comme source de données une bdd.
 * @author user
 */
public class JpaCacheVirtuelleDao extends JpaDao<CacheVirtuelle> implements CacheVirtuelleDao {

    private static JpaCacheVirtuelleDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaCacheVirtuelleDao() {
        super(CacheVirtuelle.class);
    }

    /**
     * Retourne une instance de JpaCacheVirtuelleDao.
     * @return JpaCacheVirtuelleDao
     */
    public static JpaCacheVirtuelleDao getInstance() {
        if (instance == null) {
            instance = new JpaCacheVirtuelleDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    @Override
    public Collection<CacheVirtuelle> findAll() {
        return super.findAll();
    }

    @Override
    public CacheVirtuelle find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(CacheVirtuelle obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(CacheVirtuelle obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(CacheVirtuelle obj) {
        return super.create(obj);
    }

}
