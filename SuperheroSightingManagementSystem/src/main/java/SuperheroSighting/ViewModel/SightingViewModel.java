/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.ViewModel;

import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.User;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class SightingViewModel {
    
    Sighting sighting;
    Location location;
    List<Superperson> superpersonList;
    User user;
    private List<Superperson> allSuperpersonList;
    private List<Location> allLocationList;
    private boolean displaySightingDetailsBool;
    private boolean displayCreateSightingFormBool;
    private boolean displayEditSightingFormBool;
    private List<Integer> allSuperpersonId;
    private List<Integer> pageNumbers;

    public List<Superperson> getAllSuperpersonList() {
        return allSuperpersonList;
    }

    public void setAllSuperpersonList(List<Superperson> allSuperpersonList) {
        this.allSuperpersonList = allSuperpersonList;
    }

    public List<Location> getAllLocationList() {
        return allLocationList;
    }

    public void setAllLocationList(List<Location> allLocationList) {
        this.allLocationList = allLocationList;
    }

    public boolean isDisplaySightingDetailsBool() {
        return displaySightingDetailsBool;
    }

    public void setDisplaySightingDetailsBool(boolean displaySightingDetailsBool) {
        this.displaySightingDetailsBool = displaySightingDetailsBool;
    }

    public boolean isDisplayCreateSightingFormBool() {
        return displayCreateSightingFormBool;
    }

    public void setDisplayCreateSightingFormBool(boolean displayCreateSightingFormBool) {
        this.displayCreateSightingFormBool = displayCreateSightingFormBool;
    }

    public boolean isDisplayEditSightingFormBool() {
        return displayEditSightingFormBool;
    }

    public void setDisplayEditSightingFormBool(boolean displayEditSightingFormBool) {
        this.displayEditSightingFormBool = displayEditSightingFormBool;
    }

    public List<Superperson> getSuperpersonList() {
        return superpersonList;
    }

    public void setSuperpersonList(List<Superperson> superpersonList) {
        this.superpersonList = superpersonList;
    }

    public Sighting getSighting() {
        return sighting;
    }

    public void setSighting(Sighting sighting) {
        this.sighting = sighting;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getAllSuperpersonId() {
        return allSuperpersonId;
    }

    public void setAllSuperpersonId(List<Integer> allSuperpersonId) {
        this.allSuperpersonId = allSuperpersonId;
    }

    public List<Integer> getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(List<Integer> pageNumbers) {
        this.pageNumbers = pageNumbers;
    }
    
    
    
    
}
