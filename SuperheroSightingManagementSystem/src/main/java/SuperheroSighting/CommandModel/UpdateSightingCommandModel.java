/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.CommandModel;

import SuperheroSighting.Dto.Sighting;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author EJB Laptop
 */
public class UpdateSightingCommandModel {
    
     private Integer locationId;
    private List<Integer> superpersonBySightingId;
    private String sightingDescription;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate sightingDate;
    
    @DateTimeFormat(pattern="HH:mm")
    private LocalTime sightingTime;
    private Integer userId;
    private Sighting sighting;
    
    private Integer sightingId;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public List<Integer> getSuperpersonBySightingId() {
        return superpersonBySightingId;
    }

    public void setSuperpersonBySightingId(List<Integer> superpersonBySightingId) {
        this.superpersonBySightingId = superpersonBySightingId;
    }

    public String getSightingDescription() {
        return sightingDescription;
    }

    public void setSightingDescription(String sightingDescription) {
        this.sightingDescription = sightingDescription;
    }

    public LocalDate getSightingDate() {
        return sightingDate;
    }

    public void setSightingDate(LocalDate sightingDate) {
        this.sightingDate = sightingDate;
    }

    public LocalTime getSightingTime() {
        return sightingTime;
    }

    public void setSightingTime(LocalTime sightingTime) {
        this.sightingTime = sightingTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Sighting getSighting() {
        return sighting;
    }

    public void setSighting(Sighting sighting) {
        this.sighting = sighting;
    }

    public Integer getSightingId() {
        return sightingId;
    }

    public void setSightingId(Integer sightingId) {
        this.sightingId = sightingId;
    }
    
    
    
}
