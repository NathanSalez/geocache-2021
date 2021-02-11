package org.ig2i.geocache.dao;

/**
 * Représente une frabrique DAO.
 * @author user
 */
public abstract class DaoFactory {

    /**
     * Peremt de retourner un DaoFactory.
     * @param type TODO.
     * @return DaoFactory
     */
    public static DaoFactory getDaoFactory(PersistenceType type) {
        if (type.equals(PersistenceType.JPA)) {
            return new DaoFactoryJpa();
        }
        return null;
    }

    /**
     * Retourne un CacheDao.
     * @return CacheDao
     */
    public abstract CacheDao getCacheDao();

    /**
     * Retourne un UtilisateurDao.
     * @return UtilisateurDao
     */
    public abstract UtilisateurDao getUtilisateurDao();

    /**
     * Retourne un VisiteDao.
     * @return VisiteDao
     */
    public abstract VisiteDao getVisiteDao();

    /**
     * Retourne un CachePhysiqueDao.
     * @return CachePhysiqueDao
     */
    public abstract CachePhysiqueDao getCachePhysiqueDao();

    /**
     * Retourne un CacheVirtuelleDao.
     * @return CacheVirtuelleDao
     */
    public abstract CacheVirtuelleDao getCacheVirtuelleDao();

}
