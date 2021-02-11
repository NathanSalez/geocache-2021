package org.ig2i.geocache.examples;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.ig2i.geocache.modele.Cache;
import org.ig2i.geocache.modele.Utilisateur;
import org.ig2i.geocache.modele.Visite;

import java.util.Date;

/**
 * Afin de pouvoir exécuter ces tests à l'infini, on n'effectue pas de transaction.
 * Par conséquent, notre base de données revient à son état initial après ce test.
 */
public class CRUDVisite {
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
            Utilisateur leMaitre = session.load(Utilisateur.class,1);
            Utilisateur lEsclave = session.load(Utilisateur.class, 2);
            Cache leCache = session.load(Cache.class, 2);
            System.out.println("Avant création de la nouvelle visite:");
            System.out.println(leMaitre);
            System.out.println(leCache);
            Date lHeure = new Date();
            String lUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
            String leCommentaire = "Bonjour de Ouagadougou !";
            // Utilisateur visiteur, Cache cacheVisitee, Date dateHeure, String urlPhoto, String commentaire, Boolean reussi
            Visite laVisite = new Visite(leMaitre, leCache, lHeure, lUrl, leCommentaire, true);
            session.persist(laVisite);
            System.out.println("Après création de la nouvelle visite");
            System.out.println(leMaitre);
            System.out.println(leCache);
            System.out.println(laVisite);
            System.out.println("Nouveau visiteur: " + lEsclave);
            laVisite.setVisiteurSecure(lEsclave);
            System.out.println("Après changement de visiteur:");
            System.out.println("Ancien visiteur: " + leMaitre);
            System.out.println(leCache);
            System.out.println(laVisite);
            System.out.println("Nouveau visiteur: " + lEsclave);
            //tx.commit();
        } finally {
            session.close();
        }
    }
}
