package org.ig2i.geocache.dao;

import org.ig2i.geocache.modele.Cache;
import org.ig2i.geocache.modele.Utilisateur;

import java.util.Collection;

public interface CacheDao extends DAO<Cache> {

    Collection<Cache> getCachesByPlace(String lieu);

    Collection<Cache> getCachesByOwner(Utilisateur proprietaire);

}
