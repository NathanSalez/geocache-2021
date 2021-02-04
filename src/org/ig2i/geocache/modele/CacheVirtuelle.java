package org.ig2i.geocache.modele;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("virtuelle")
public class CacheVirtuelle extends Cache
{
    public CacheVirtuelle() {}

    public CacheVirtuelle(int id, int idProprietaire, String description, String lieu, String etat, String type, String url) {
        super(id,idProprietaire,description,lieu,etat,type);
        setUrl(url);
    }

    private String url;

    @Column(name = "url", length = 255)
    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CacheVirtuelle)) return false;
        if (!super.equals(o)) return false;
        CacheVirtuelle that = (CacheVirtuelle) o;
        return this.getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

}
