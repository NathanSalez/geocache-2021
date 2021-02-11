package org.ig2i.geocache.dao;

import java.util.Collection;
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
    public boolean deleteAll() {
        return super.deleteAll();
    }

    @Override
    public Collection<Visite> findAll() {
        return super.findAll();
    }

    @Override
    public Visite find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(Visite obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(Visite obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(Visite obj) {
        return super.create(obj);
    }

}

