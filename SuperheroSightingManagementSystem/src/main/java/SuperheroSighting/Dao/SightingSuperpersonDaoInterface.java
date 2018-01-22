/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.SightingSuperperson;
import SuperheroSighting.Dto.Superperson;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface SightingSuperpersonDaoInterface {
    
    public SightingSuperperson createSightingSuperperson(SightingSuperperson sightingSuperperson);
    
    public SightingSuperperson readSightingSuperperson(Integer sightingSuperpersonId);
    
    public List<SightingSuperperson> listSightingSuperperson(int limit, int offset);
    
    public void updateSightingSuperperson(SightingSuperperson sightingSuperperson);
    
    public void deleteSightingSuperperson(Integer sightingSuperpersonId);
    
    public List<SightingSuperperson> listSightingSuperpersonBySuperperson(Superperson superperson, int limit, int offset);
    
    public List<SightingSuperperson> listSightingSuperpersonBySighting(Sighting sighting, int limit, int offset);
    
    public void deleteSightingSuperpersonBySuperperson(Superperson superperson);
    
    public void deleteSightingSuperpersonBySighting(Sighting sighting);
    
}
