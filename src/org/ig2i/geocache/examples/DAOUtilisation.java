package org.ig2i.geocache.examples;

import org.ig2i.geocache.dao.DaoFactory;
import org.ig2i.geocache.dao.PersistenceType;
import org.ig2i.geocache.dao.VisiteDao;
import org.ig2i.geocache.modele.Visite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class DAOUtilisation
{
    public static void main(String[] args) throws ParseException {
        DaoFactory jpaFactory = DaoFactory.getDaoFactory(PersistenceType.JPA);
        if (jpaFactory != null) {
            VisiteDao visiteManager = jpaFactory.getVisiteDao();
            Collection<Visite> visites =  visiteManager.findAll();
            for(Visite v: visites) {
                System.out.println(v);
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateString = "01/01/2020";
            Date date = simpleDateFormat.parse(dateString);
            visites = visiteManager.findVisitesByDate(date);
            for(Visite v: visites) {
                System.out.println(v);
            }
            Visite v = visiteManager.find(1);
            v.setReussi(false);
            visiteManager.update(v);
            //visiteManager.deleteAll(); // !!!!
        }
    }
}
