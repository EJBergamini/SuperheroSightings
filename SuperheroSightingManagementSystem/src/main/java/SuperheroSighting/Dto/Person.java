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
public class Person {
    
    private Integer personId;
    
    private String personFirstName;
    
    private String personLastName;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.personId);
        hash = 83 * hash + Objects.hashCode(this.personFirstName);
        hash = 83 * hash + Objects.hashCode(this.personLastName);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.personFirstName, other.personFirstName)) {
            return false;
        }
        if (!Objects.equals(this.personLastName, other.personLastName)) {
            return false;
        }
        if (!Objects.equals(this.personId, other.personId)) {
            return false;
        }
        return true;
    }
    
    
}
