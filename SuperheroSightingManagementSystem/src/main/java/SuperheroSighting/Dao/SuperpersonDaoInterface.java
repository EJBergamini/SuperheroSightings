/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.MoralityType;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.Superperson;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface SuperpersonDaoInterface {
    
    public Superperson createSuperperson(Superperson superperson);
    
    public Superperson readSuperperson(Integer superpersonId);
    
    public List<Superperson> listSuperperson(int limit, int offset);
    
    public void updateSuperperson(Superperson superperson);
    
    public void deleteSuperperson(Integer superpersonId);
    
    public List<Superperson> listSuperpersonByPerson(Person person, int limit, int offset);
    
    public List<Superperson> listSuperpersonByAlias(Person person, int limit, int offset);    
    
    public List<Superperson> listSuperpersonByMoralityType(MoralityType moralityType, int limit, int offset);
    
    public List<Superperson> listSuperpersonByLocation(Location location, int limit, int offset);
    
    public List<Superperson> listSuperpersonBySighting(Sighting sighting, int limit, int offset);
    
    public List<Superperson> listSuperpersonByPower(Power power, int limit, int offset);
    
    public List<Superperson> listSuperpersonByOrganization(Organization organization, int limit, int offset);
    
}
