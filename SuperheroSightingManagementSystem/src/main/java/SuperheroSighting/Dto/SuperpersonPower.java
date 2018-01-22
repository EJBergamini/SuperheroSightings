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
public class SuperpersonPower {
    
    private Integer superpersonPowerId;
    
    private Superperson superperson;
    
    private Power power;

    public Integer getSuperpersonPowerId() {
        return superpersonPowerId;
    }

    public void setSuperpersonPowerId(Integer superPersonPowerId) {
        this.superpersonPowerId = superPersonPowerId;
    }

    public Superperson getSuperperson() {
        return superperson;
    }

    public void setSuperperson(Superperson superperson) {
        this.superperson = superperson;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.superpersonPowerId);
        hash = 31 * hash + Objects.hashCode(this.superperson);
        hash = 31 * hash + Objects.hashCode(this.power);
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
        final SuperpersonPower other = (SuperpersonPower) obj;
        if (!Objects.equals(this.superpersonPowerId, other.superpersonPowerId)) {
            return false;
        }
        if (!Objects.equals(this.superperson, other.superperson)) {
            return false;
        }
        if (!Objects.equals(this.power, other.power)) {
            return false;
        }
        return true;
    }
    
    
}
