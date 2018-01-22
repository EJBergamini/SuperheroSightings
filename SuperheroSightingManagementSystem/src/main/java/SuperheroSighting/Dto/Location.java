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
public class Location {
    
    private Integer locationId;
    
    private String locationName;
    
    private String locationDescription;
    
    private Address address;
    
    private String cardinalDirectionLongitude;
    
    private String cardinalDirectionLatitude;
    
    private float latitudinalCoordinate;
    
    private float longitudinalCoordinate;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCardinalDirectionLongitude() {
        return cardinalDirectionLongitude;
    }

    public void setCardinalDirectionLongitude(String cardinalDirectionLongitude) {
        this.cardinalDirectionLongitude = cardinalDirectionLongitude;
    }

    public String getCardinalDirectionLatitude() {
        return cardinalDirectionLatitude;
    }

    public void setCardinalDirectionLatitude(String cardinalDirectionLatitude) {
        this.cardinalDirectionLatitude = cardinalDirectionLatitude;
    }

    public float getLatitudinalCoordinate() {
        return latitudinalCoordinate;
    }

    public void setLatitudinalCoordinate(float latitudinalCoordinate) {
        this.latitudinalCoordinate = latitudinalCoordinate;
    }

    public float getLongitudinalCoordinate() {
        return longitudinalCoordinate;
    }

    public void setLongitudinalCoordinate(float longitudinalCoordinate) {
        this.longitudinalCoordinate = longitudinalCoordinate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.locationId);
        hash = 47 * hash + Objects.hashCode(this.locationName);
        hash = 47 * hash + Objects.hashCode(this.locationDescription);
        hash = 47 * hash + Objects.hashCode(this.address);
        hash = 47 * hash + Objects.hashCode(this.cardinalDirectionLongitude);
        hash = 47 * hash + Objects.hashCode(this.cardinalDirectionLatitude);
        hash = 47 * hash + Float.floatToIntBits(this.latitudinalCoordinate);
        hash = 47 * hash + Float.floatToIntBits(this.longitudinalCoordinate);
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
        final Location other = (Location) obj;
        if (Float.floatToIntBits(this.latitudinalCoordinate) != Float.floatToIntBits(other.latitudinalCoordinate)) {
            return false;
        }
        if (Float.floatToIntBits(this.longitudinalCoordinate) != Float.floatToIntBits(other.longitudinalCoordinate)) {
            return false;
        }
        if (!Objects.equals(this.locationName, other.locationName)) {
            return false;
        }
        if (!Objects.equals(this.locationDescription, other.locationDescription)) {
            return false;
        }
        if (!Objects.equals(this.cardinalDirectionLongitude, other.cardinalDirectionLongitude)) {
            return false;
        }
        if (!Objects.equals(this.cardinalDirectionLatitude, other.cardinalDirectionLatitude)) {
            return false;
        }
        if (!Objects.equals(this.locationId, other.locationId)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }
    
    
}
