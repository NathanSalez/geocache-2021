package org.ig2i.geocache.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;
import org.ig2i.geocache.modele.Visite;

/**
 * Représente un DAO de type Visite utilisant comme source de données une bdd.
 * @author user
 */
public class JpaVisiteDao extends JpaDao<Visite> implements VisiteDao {

    private static JpaVisiteDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaVisiteDao() {
        super(Visite.class);
    }

    /**
     * Retourne une instance de JpaVisiteDao.
     * @return JpaVisiteDao
     */
    public static JpaVisiteDao getInstance() {
        if (instance == null) {
            instance = new JpaVisiteDao();
        }
        return instance;
    }

    @Override
    public Collection<Visite> findVisitesByDate(Date d) {
        Query query = session.createNamedQuery("findVisitesByDate", Visite.class);
        query.setParameter("date",d);
        return query.getResultList();
    }
}

