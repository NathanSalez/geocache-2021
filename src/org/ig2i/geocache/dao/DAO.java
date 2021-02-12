package org.ig2i.geocache.dao;

import java.util.Collection;

/**
 * Interface générique représentant un DAO.
 * @author user
 * @param <T>
 */

public interface DAO<T> {
    /**
     * Méthode permettant de créer un objet.
     * @param obj TODO
     * @return boolean
     */
    boolean create(T obj);

    /**
     * Méthode permettant de rechercher un objet.
     * @param id TODO
     * @return object
     */
    T find(Integer id);

    /**
     * Méthode permettant de rechercher une collection d'objet.
     * @return collection of object
     */
    Collection<T> findAll();

    /**
     * Méthode permettant de mettre à jour un objet.
     * @param obj TODO
     * @return boolean
     */
    boolean update(T obj);

    /**
     * Méthode permettant de supprimer un objet.
     * @param obj TODO
     * @return boolean
     */
    boolean delete(T obj);

    /**
     * Méthode permettant de supprimer un ensemble d'objet.
     * @return boolean
     */
    boolean deleteAll();

    /**
     * Méthode permettant de fermer la connexion à la source des données (bdd ou fichier).
     */
    void close();

}
