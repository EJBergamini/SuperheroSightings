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
public class OrganizationPerson {
    
    private Integer organizationPersonId;
    
    private Person person;
    
    private Organization organization;

    public Integer getOrganizationPersonId() {
        return organizationPersonId;
    }

    public void setOrganizationPersonId(Integer organizationPersonId) {
        this.organizationPersonId = organizationPersonId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.organizationPersonId);
        hash = 47 * hash + Objects.hashCode(this.person);
        hash = 47 * hash + Objects.hashCode(this.organization);
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
        final OrganizationPerson other = (OrganizationPerson) obj;
        if (!Objects.equals(this.organizationPersonId, other.organizationPersonId)) {
            return false;
        }
        if (!Objects.equals(this.person, other.person)) {
            return false;
        }
        if (!Objects.equals(this.organization, other.organization)) {
            return false;
        }
        return true;
    }
    
    
}
