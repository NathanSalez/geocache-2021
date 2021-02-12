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

}
