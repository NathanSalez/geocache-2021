package org.ig2i.geocache.examples;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.ig2i.geocache.modele.CacheVirtuelle;
import org.ig2i.geocache.modele.Utilisateur;

public class CRUDProprietaire {
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
            // Utilisateur proprietaire, String description, String lieu, String etat, String type, String url
            CacheVirtuelle cv = new CacheVirtuelle(null,"Cache accessible sur le site de l'architecte claud", "INternet français", "fermée", "traditionnelle","http://localhost");
            session.persist(cv);
            System.out.println("Après persistance:");
            System.out.println(cv);
            Utilisateur proprio = session.load(Utilisateur.class,1);
            Utilisateur proprio2 = session.load(Utilisateur.class,2);
            proprio.addCache(cv);
            System.out.println("Après ajout de cache sur utilisateur 1");
            System.out.println(proprio);
            System.out.println(proprio2);
            System.out.println(cv);
            proprio2.addCache(cv);
            System.out.println("Nouveau proprio (utilisateur 2):");
            System.out.println(proprio);
            System.out.println(proprio2);
            System.out.println(cv);
            //tx.commit();
        } finally {
            session.close();
        }
    }
}
