package org.ig2i.geocache.dao;


/**
 * Représente une frabrique DAO de type JPA.
 * @author user
 */
public class DaoFactoryJpa extends DaoFactory {

    @Override
    public CacheDao getCacheDao() {
        return JpaCacheDao.getInstance();
    }

    @Override
    public VisiteDao getVisiteDao() {
        return JpaVisiteDao.getInstance();
    }

    @Override
    public UtilisateurDao getUtilisateurDao() {
        return JpaUtilisateurDao.getInstance();
    }

    @Override
    public CacheVirtuelleDao getCacheVirtuelleDao() {
        return JpaCacheVirtuelleDao.getInstance();
    }

    @Override
    public CachePhysiqueDao getCachePhysiqueDao() {
        return JpaCachePhysiqueDao.getInstance();
    }

}
