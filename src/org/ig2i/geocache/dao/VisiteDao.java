package org.ig2i.geocache.dao;
import org.ig2i.geocache.modele.Visite;

import java.util.Collection;
import java.util.Date;


public interface VisiteDao extends DAO<Visite> {

    Collection<Visite> findVisitesByDate(Date d);
}
