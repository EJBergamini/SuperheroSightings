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
public class Organization {
    
    private Integer organizationId;
    
    private String organizationName;
    
    private String organizationDescription;
    
    private Address address;
    
    private MoralityType moralityType;
    
    private Contact contact;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public MoralityType getMoralityType() {
        return moralityType;
    }

    public void setMoralityType(MoralityType moralityType) {
        this.moralityType = moralityType;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.organizationId);
        hash = 71 * hash + Objects.hashCode(this.organizationName);
        hash = 71 * hash + Objects.hashCode(this.organizationDescription);
        hash = 71 * hash + Objects.hashCode(this.address);
        hash = 71 * hash + Objects.hashCode(this.moralityType);
        hash = 71 * hash + Objects.hashCode(this.contact);
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
        final Organization other = (Organization) obj;
        if (!Objects.equals(this.organizationName, other.organizationName)) {
            return false;
        }
        if (!Objects.equals(this.organizationDescription, other.organizationDescription)) {
            return false;
        }
        if (!Objects.equals(this.organizationId, other.organizationId)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.moralityType, other.moralityType)) {
            return false;
        }
        if (!Objects.equals(this.contact, other.contact)) {
            return false;
        }
        return true;
    }
    
    
}
