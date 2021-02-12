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
}
