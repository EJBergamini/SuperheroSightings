/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Superperson;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface LocationDaoInterface {
    
    public Location createLocation(Location location);
    
    public Location readLocation(Integer locationId);
    
    public List<Location> listLocation(int limit, int offset);
    
    public void updateLocation(Location location);
    
    public void deleteLocation(Integer locationId);
    
    public List<Location> listLocationBySuperperson(Superperson superperson, int limit, int offset);
    
    public List<Location> listLocationByAddress(Address address, int limit, int offset);
    
}
