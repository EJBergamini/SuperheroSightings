/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author EJB Laptop
 */
public class Sighting {
    
    private Integer sightingId;
    
    private User user;
    
    private Location location;
    
    private String sightingDescription;
    
    private LocalDateTime sightingDateTime;

    public Integer getSightingId() {
        return sightingId;
    }

    public void setSightingId(Integer sightingId) {
        this.sightingId = sightingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getSightingDescription() {
        return sightingDescription;
    }

    public void setSightingDescription(String sightingDescription) {
        this.sightingDescription = sightingDescription;
    }

    public LocalDateTime getSightingDateTime() {
        return sightingDateTime;
    }

    public void setSightingDateTime(LocalDateTime sightingDateTime) {
        this.sightingDateTime = sightingDateTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.sightingId);
        hash = 23 * hash + Objects.hashCode(this.user);
        hash = 23 * hash + Objects.hashCode(this.location);
        hash = 23 * hash + Objects.hashCode(this.sightingDescription);
        hash = 23 * hash + Objects.hashCode(this.sightingDateTime);
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
        final Sighting other = (Sighting) obj;
        if (!Objects.equals(this.sightingDescription, other.sightingDescription)) {
            return false;
        }
        if (!Objects.equals(this.sightingId, other.sightingId)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.sightingDateTime, other.sightingDateTime)) {
            return false;
        }
        return true;
    }
    

    
}
