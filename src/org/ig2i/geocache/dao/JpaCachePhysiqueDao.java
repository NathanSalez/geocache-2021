package org.ig2i.geocache.dao;

import java.util.Collection;
import org.ig2i.geocache.modele.CachePhysique;

/**
 * Représente un DAO de type CachePhysique utilisant comme source de données une bdd.
 * @author user
 */
public class JpaCachePhysiqueDao extends JpaDao<CachePhysique> implements CachePhysiqueDao {

    private static JpaCachePhysiqueDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaCachePhysiqueDao() {
        super(CachePhysique.class);
    }

    /**
     * Retourne une instance de JpaCachePhysiqueDao.
     * @return JpaCachePhysiqueDao
     */
    public static JpaCachePhysiqueDao getInstance() {
        if (instance == null) {
            instance = new JpaCachePhysiqueDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    @Override
    public Collection<CachePhysique> findAll() {
        return super.findAll();
    }

    @Override
    public CachePhysique find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(CachePhysique obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(CachePhysique obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(CachePhysique obj) {
        return super.create(obj);
    }

}
