package org.ig2i.geocache.dao;

import java.util.Collection;
import org.ig2i.geocache.modele.Utilisateur;

/**
 * Représente un DAO de type Utilisateur utilisant comme source de données une bdd.
 * @author user
 */
public class JpaUtilisateurDao extends JpaDao<Utilisateur> implements UtilisateurDao {

    private static JpaUtilisateurDao instance;

    /**
     * Constrcuteur par défault.
     */
    private JpaUtilisateurDao() {
        super(Utilisateur.class);
    }

    /**
     * Retourne une instance de JpaUtilisateurDao.
     * @return JpaUtilisateurDao
     */
    public static JpaUtilisateurDao getInstance() {
        if (instance == null) {
            instance = new JpaUtilisateurDao();
        }
        return instance;
    }

    @Override
    public boolean deleteAll() {
        return super.deleteAll();
    }

    @Override
    public Collection<Utilisateur> findAll() {
        return super.findAll();
    }

    @Override
    public Utilisateur find(Integer id) {
        return super.find(id);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public boolean delete(Utilisateur obj) {
        return super.delete(obj);
    }

    @Override
    public boolean update(Utilisateur obj) {
        return super.update(obj);
    }

    @Override
    public boolean create(Utilisateur obj) {
        return super.create(obj);
    }

}
