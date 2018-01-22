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
public class MoralityType {
    
    private Integer moralityTypeId;
    
    private String moralityDescription;

    public Integer getMoralityTypeId() {
        return moralityTypeId;
    }

    public void setMoralityTypeId(Integer moralityTypeId) {
        this.moralityTypeId = moralityTypeId;
    }

    public String getMoralityDescription() {
        return moralityDescription;
    }

    public void setMoralityDescription(String moralityDescription) {
        this.moralityDescription = moralityDescription;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.moralityTypeId);
        hash = 97 * hash + Objects.hashCode(this.moralityDescription);
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
        final MoralityType other = (MoralityType) obj;
        if (!Objects.equals(this.moralityDescription, other.moralityDescription)) {
            return false;
        }
        if (!Objects.equals(this.moralityTypeId, other.moralityTypeId)) {
            return false;
        }
        return true;
    }
    
    
}
