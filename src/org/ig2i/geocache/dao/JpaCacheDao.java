package org.ig2i.geocache.dao;

import java.util.Collection;

import org.ig2i.geocache.modele.Cache;
import org.ig2i.geocache.modele.Utilisateur;

import javax.persistence.Query;

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
    public Collection<Cache> getCachesByPlace(String lieu) {
        Query query = session.createNamedQuery("getCachesByPlace", Cache.class);
        query.setParameter("place", lieu);
        return query.getResultList();
    }

    @Override
    public Collection<Cache> getCachesByOwner(Utilisateur proprietaire) {
        Query query = session.createNamedQuery("getCachesByOwnerName", Cache.class);
        query.setParameter("pseudo", proprietaire.getPseudo());
        return query.getResultList();
    }
}
