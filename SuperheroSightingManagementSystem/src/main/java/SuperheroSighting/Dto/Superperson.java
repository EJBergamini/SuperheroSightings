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
public class Superperson {
    
    private Integer superpersonId;
    
    private Person person;
    
    private Person alias;
    
    private MoralityType moralityType;
    
    private String superpersonDescription;

    public Integer getSuperpersonId() {
        return superpersonId;
    }

    public void setSuperpersonId(Integer superpersonId) {
        this.superpersonId = superpersonId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getAlias() {
        return alias;
    }

    public void setAlias(Person alias) {
        this.alias = alias;
    }

    public MoralityType getMoralityType() {
        return moralityType;
    }

    public void setMoralityType(MoralityType moralityType) {
        this.moralityType = moralityType;
    }

    public String getSuperpersonDescription() {
        return superpersonDescription;
    }

    public void setSuperpersonDescription(String superPersonDescription) {
        this.superpersonDescription = superPersonDescription;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.superpersonId);
        hash = 67 * hash + Objects.hashCode(this.person);
        hash = 67 * hash + Objects.hashCode(this.alias);
        hash = 67 * hash + Objects.hashCode(this.moralityType);
        hash = 67 * hash + Objects.hashCode(this.superpersonDescription);
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
        final Superperson other = (Superperson) obj;
        if (!Objects.equals(this.superpersonDescription, other.superpersonDescription)) {
            return false;
        }
        if (!Objects.equals(this.superpersonId, other.superpersonId)) {
            return false;
        }
        if (!Objects.equals(this.person, other.person)) {
            return false;
        }
        if (!Objects.equals(this.alias, other.alias)) {
            return false;
        }
        if (!Objects.equals(this.moralityType, other.moralityType)) {
            return false;
        }
        return true;
    }
    
    
}
