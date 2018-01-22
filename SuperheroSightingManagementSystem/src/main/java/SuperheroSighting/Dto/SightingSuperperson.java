/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dto;

import java.util.Objects;

/**
 *
 * @author EJB Laptop
 */
public class SightingSuperperson {
    
    private Integer sightingSuperpersonId;
    
    private Sighting sighting;
    
    private Superperson superperson;

    public Integer getSightingSuperpersonId() {
        return sightingSuperpersonId;
    }

    public void setSightingSuperpersonId(Integer sightingSuperpersonId) {
        this.sightingSuperpersonId = sightingSuperpersonId;
    }

    public Sighting getSighting() {
        return sighting;
    }

    public void setSighting(Sighting sighting) {
        this.sighting = sighting;
    }

    public Superperson getSuperperson() {
        return superperson;
    }

    public void setSuperperson(Superperson superperson) {
        this.superperson = superperson;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.sightingSuperpersonId);
        hash = 97 * hash + Objects.hashCode(this.sighting);
        hash = 97 * hash + Objects.hashCode(this.superperson);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SightingSuperperson other = (SightingSuperperson) obj;
        if (!Objects.equals(this.sightingSuperpersonId, other.sightingSuperpersonId)) {
            return false;
        }
        if (!Objects.equals(this.sighting, other.sighting)) {
            return false;
        }
        if (!Objects.equals(this.superperson, other.superperson)) {
            return false;
        }
        return true;
    }
    
    
}
