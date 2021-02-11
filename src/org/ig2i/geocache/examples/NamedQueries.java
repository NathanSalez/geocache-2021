package org.ig2i.geocache.examples;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ig2i.geocache.modele.Cache;
import org.ig2i.geocache.modele.Visite;

import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NamedQueries {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        //Transaction tx = session.beginTransaction();
        try {
            Query query = session.createNamedQuery("getCachesByOwnerName", Cache.class);
            query.setParameter("pseudo", "Naysson");
            List<Cache> cachesDuMaitre = query.getResultList();
            for(Cache c: cachesDuMaitre) {
                System.out.println(c);
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateString = "01/01/2020";
            Date date = simpleDateFormat.parse(dateString);
            query = session.createNamedQuery("findVisitesByDate", Visite.class);
            query.setParameter("date",date);
            List<Visite> visites = query.getResultList();
            for(Visite v: visites) {
                System.out.println(v);
            }

        } finally {
            session.close();
        }
    }
}
