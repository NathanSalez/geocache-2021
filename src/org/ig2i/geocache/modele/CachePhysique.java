package org.ig2i.geocache.modele;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DiscriminatorValue("physique")
public class CachePhysique extends Cache
{
    private double latitude;
    private double longitude;

    public CachePhysique() {}

    public CachePhysique(Utilisateur proprietaire, String description, String lieu, String etat, String type, double latitude, double longitude) {
        super(proprietaire,description,lieu,etat,type);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    @Column(name = "latitude")
    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    @Column(name = "longitude")
    public double getLongitude() { return longitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CachePhysique)) return false;
        if (!super.equals(o)) return false;
        CachePhysique that = (CachePhysique) o;
        return this.getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
