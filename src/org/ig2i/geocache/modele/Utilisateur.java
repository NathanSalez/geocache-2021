package org.ig2i.geocache.modele;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Table(name="UTILISATEUR", schema = "geocache")
public class Utilisateur
{
    private int id;
    private String pseudo;
    private String description;
    private String urlPhoto;
    private Collection<Cache> caches;
    private Collection<Visite> visites;

    public Utilisateur() {}

    public Utilisateur(String pseudo, String description, String urlPhoto) {
        setPseudo(pseudo);
        setDescription(description);
        setUrlPhoto(urlPhoto);
        caches = new HashSet<>();
        visites = new HashSet<>();
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "pseudo", nullable = false, unique = true, length = 45)
    public String getPseudo() { return pseudo; }

    public void setPseudo(String pseudo) { this.pseudo = pseudo; }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "urlPhoto", nullable = false, length = 255)
    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    @OneToMany(mappedBy = "proprietaire")
    public Collection<Cache> getCaches() { return caches; }

    public void setCaches(Collection<Cache> caches) { this.caches = caches; }

    public boolean removeCache(Cache c) {
        if( caches.remove(c) ) {
            c.setProprietaire(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean addCache(Cache c) {
        if( c == null || this.equals(c.getProprietaire()))
            return false;

        Utilisateur ancienProprietaire = c.getProprietaire();
        if( ancienProprietaire != null && !ancienProprietaire.removeCache(c)) {
            System.out.println("Suppression de l'ancien propriétaire échouée.");
        }

        c.setProprietaire(this);
        return caches.add(c);
    }

    @OneToMany(mappedBy = "visiteur")
    public Collection<Visite> getVisites() { return visites; }

    public void setVisites(Collection<Visite> visites) { this.visites = visites; }

    public boolean removeVisite(Visite v) {
        if( visites.remove(v) ) {
            v.setVisiteur(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean addVisite(Visite v) {
        if( v == null || this.equals(v.getVisiteur()))
            return false;

        Utilisateur ancienVisiteur = v.getVisiteur();
        if( ancienVisiteur != null && !ancienVisiteur.removeVisite(v)) {
            System.out.println("Suppression de l'ancien visiteur échouée.");
        }

        v.setVisiteur(this);
        return visites.add(v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return getPseudo().equals(that.getPseudo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPseudo());
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
            "id=" + id +
            ", pseudo='" + pseudo + '\'' +
            ", description='" + description + '\'' +
            ", urlPhoto='" + urlPhoto + '\'' +
            ", nb de caches=" + caches.size() +
            ", nb de visites=" + visites.size() +
            '}';
    }
}
