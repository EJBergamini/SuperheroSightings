/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.SightingSuperperson;
import SuperheroSighting.Dto.Superperson;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface SightingSuperpersonServiceInterface {
    
    public SightingSuperperson createSightingSuperperson(SightingSuperperson sightingSuperperson);
    
    public SightingSuperperson readSightingSuperperson(SightingSuperperson sightingSuperperson);
    
    public List<SightingSuperperson> listSightingSuperperson(int limit, int offset);
  
    public List<SightingSuperperson> listSightingSuperpersonBySuperperson(Superperson superperson, int limit, int offset);

    public List<SightingSuperperson> listSightingSuperpersonBySuperperson(int superpersonId, int limit, int offset);
    
    public List<SightingSuperperson> listSightingSuperpersonBySighting(Sighting sighting, int limit, int offset);

    public List<SightingSuperperson> listSightingSuperpersonBySighting(int sightingId, int limit, int offset);
    
    public void updateSightingSuperperson(SightingSuperperson sightingSuperperson);

    public void deleteSightingSuperperson(SightingSuperperson sightingSuperperson);

    public void deleteSuperpersonFromSighting(Sighting sighting);

    public void deleteSightingFromSuperperson(Superperson superperson);
    
}
