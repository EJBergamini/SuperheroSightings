/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

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
public interface SuperpersonServiceInterface {
    
    public Superperson createSuperperson(Superperson superperson);
    
    public Superperson readSuperperson(int superpersonId);
    
    public List<Superperson> listSuperperson(int limit, int offset);    

    public List<Superperson> listSuperpersonByMoralityType(MoralityType moralityType, int limit, int offset);

    public List<Superperson> listSuperpersonByMoralityType(int moralityTypeId, int limit, int offset);
    
    public List<Superperson> listSuperpersonByAliasId(Person alias, int limit, int offset);

    public List<Superperson> listSuperpersonByAliasId(int aliasId, int limit, int offset);
    
    public List<Superperson> listSuperpersonByLocation(Location location, int limit, int offset);

    public List<Superperson> listSuperpersonByLocation(int locationId, int limit, int offset);
    
    public List<Superperson> listSuperpersonsBySighting(Sighting sighting, int limit, int offset);

    public List<Superperson> listSuperpersonsBySighting(int sightingId, int limit, int offset);
    
    public List<Superperson> listSuperpersonsByPower(Power power, int limit, int offset);

    public List<Superperson> listSuperpersonsByPower(int powerId, int limit, int offset);
    
    public List<Superperson> listSuperpersonsByOrganization(Organization organization, int limit, int offset);
    
    public List<Superperson> listSuperpersonsByOrganization(int organizationId, int limit, int offset);
    
    public List<Superperson> listSuperpersonsByPerson(Person person, int limit, int offset);

    public List<Superperson> listSuperpersonsByPerson(int personId, int limit, int offset);
    
    public void updateSuperperson(Superperson superperson);

    public void deleteSuperperson(Superperson superperson);
    
}
