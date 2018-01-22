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
public class Address {
    
    private Integer addressId;
    
    private String streetAddress;
    
    private String cityName;
    
    private String stateName;
    
    private String zipCode;
    
    private String countryName;
    
    private String planetName;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.addressId);
        hash = 53 * hash + Objects.hashCode(this.streetAddress);
        hash = 53 * hash + Objects.hashCode(this.cityName);
        hash = 53 * hash + Objects.hashCode(this.stateName);
        hash = 53 * hash + Objects.hashCode(this.zipCode);
        hash = 53 * hash + Objects.hashCode(this.countryName);
        hash = 53 * hash + Objects.hashCode(this.planetName);
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
        final Address other = (Address) obj;
        if (!Objects.equals(this.streetAddress, other.streetAddress)) {
            return false;
        }
        if (!Objects.equals(this.cityName, other.cityName)) {
            return false;
        }
        if (!Objects.equals(this.stateName, other.stateName)) {
            return false;
        }
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        if (!Objects.equals(this.countryName, other.countryName)) {
            return false;
        }
        if (!Objects.equals(this.planetName, other.planetName)) {
            return false;
        }
        if (!Objects.equals(this.addressId, other.addressId)) {
            return false;
        }
        return true;
    }

    
    
}
