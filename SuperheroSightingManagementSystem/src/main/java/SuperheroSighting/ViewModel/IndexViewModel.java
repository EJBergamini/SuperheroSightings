/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.ViewModel;

import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.Superperson;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class IndexViewModel {
    
    Sighting sighting;
    Location location;
    List<Superperson> superpersonList;

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

    public List<Superperson> getSuperpersonList() {
        return superpersonList;
    }

    public void setSuperpersonList(List<Superperson> superpersonList) {
        this.superpersonList = superpersonList;
    }

}