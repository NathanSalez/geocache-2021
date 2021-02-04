package org.ig2i.geocache.modele;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="CACHE", schema = "geocache")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "nature", discriminatorType = DiscriminatorType.STRING)
public abstract class Cache
{
    private int id;
    private Utilisateur proprietaire;
    private String description;
    private String lieu;
    private String etat;
    private String type;

    public Cache() {}

    public Cache(Utilisateur proprietaire, String description, String lieu, String etat, String type) {
        setProprietaire(proprietaire);
        setDescription(description);
        setLieu(lieu);
        setEtat(etat);
        setType(type);
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
    @JoinColumn(name="idProprietaire")
    public Utilisateur getProprietaire() { return proprietaire; }

    public void setProprietaire(Utilisateur proprietaire) { this.proprietaire = proprietaire; }

    @Column(name = "lieu", nullable = false, unique = true, length = 45)
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "etat", nullable = false, length = 45)
    public String getEtat() { return etat; }

    public void setEtat(String etat) { this.etat = etat; }

    @Column(name = "type", nullable = false, length = 45)
    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cache)) return false;
        Cache cache = (Cache) o;
        return getId() == cache.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Cache{" +
            "id=" + id +
            ", proprietaire=" + proprietaire +
            ", description='" + description + '\'' +
            ", lieu='" + lieu + '\'' +
            ", etat='" + etat + '\'' +
            ", type='" + type + '\'' +
            '}';
    }
}
