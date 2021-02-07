package org.ig2i.geocache.modele;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="VISITE", schema = "geocache")
public class Visite
{
    private int id;
    private Utilisateur visiteur;
    private Cache cacheVisitee;
    private Date dateHeure;
    private String urlPhoto;
    private String commentaire;
    private Boolean reussi;

    public Visite() {}

    public Visite(Utilisateur visiteur, Cache cacheVisitee, Date dateHeure, String urlPhoto, String commentaire, Boolean reussi) {
        setDateHeure(dateHeure);
        setUrlPhoto(urlPhoto);
        setCommentaire(commentaire);
        setReussi(reussi);
        if( !setVisiteurSecure(visiteur))
            System.out.println("Ajout du visiteur échoué.");
        if( !setCacheVisiteeSecure(cacheVisitee))
            System.out.println("Ajout de la cache échoué.");

    }

    public boolean setVisiteurSecure(Utilisateur visiteur) {
        if( visiteur != null) {
            return visiteur.addVisite(this);
        } else {
            return false;
        }
    }

    public boolean setCacheVisiteeSecure(Cache cacheVisitee) {
        if( cacheVisitee != null) {
            return cacheVisitee.addVisite(this);
        } else {
            return false;
        }
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idUtilisateur")
    public Utilisateur getVisiteur() { return visiteur; }

    public void setVisiteur(Utilisateur visiteur) { this.visiteur = visiteur; }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idCache")
    public Cache getCacheVisitee() { return cacheVisitee; }

    public void setCacheVisitee(Cache cacheVisitee) { this.cacheVisitee = cacheVisitee; }

    @Column(name= "dateHeure", nullable = false)
    public Date getDateHeure() { return dateHeure; }

    public void setDateHeure(Date dateHeure) { this.dateHeure = dateHeure; }

    @Column(name = "urlPhoto", nullable = false, length = 255)
    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    @Column(name = "commentaire", nullable = false)
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Column(name= "reussi", nullable = false)
    public Boolean getReussi() { return reussi; }

    public void setReussi(Boolean reussi) { this.reussi = reussi; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visite)) return false;
        Visite visite = (Visite) o;
        return getId() == visite.getId();
    }

    @Override
    public int hashCode() { return Objects.hash(getId()); }

    @Override
    public String toString() {
        return "Visite{" +
            "id=" + id +
            ", visiteur=" + visiteur +
            ", cacheVisitee=" + cacheVisitee +
            ", dateHeure=" + dateHeure +
            ", urlPhoto='" + urlPhoto + '\'' +
            ", commentaire='" + commentaire + '\'' +
            ", reussi=" + reussi +
            '}';
    }
}
