/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.User;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface SightingDaoInterface {
    
    public Sighting createSighting(Sighting sighting);
    
    public Sighting readSighting(Integer sightingId);
    
    public List<Sighting> listSighting(int limit, int offset);
    
    public void updateSighting(Sighting sighting);
    
    public void deleteSighting(Integer sightingId);
    
    public List<Sighting> listSightingByUser(User user, int limit, int offset);
    
    public List<Sighting> listSightingByLocation(Location location, int limit, int offset);
    
    public List<Sighting> listSightingByDate(LocalDate sightingDate, int limit, int offset);
    
    public List<Sighting> listSightingBySuperperson(Superperson superperson, int limit, int offset);
    
}
