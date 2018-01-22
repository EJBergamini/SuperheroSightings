/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Service.SuperpersonPowerServiceInterface;
import SuperheroSighting.Service.SightingSuperpersonServiceInterface;
import SuperheroSighting.Service.LocationServiceInterface;
import SuperheroSighting.Service.MoralityTypeServiceInterface;
import SuperheroSighting.Service.OrganizationServiceInterface;
import SuperheroSighting.Dao.PersonDaoInterface;
import SuperheroSighting.Service.PowerServiceInterface;
import SuperheroSighting.Service.SightingServiceInterface;
import SuperheroSighting.Dao.SuperpersonDaoInterface;
import SuperheroSighting.Dao.SuperpersonPowerDaoInterface;
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
public class SuperpersonService implements SuperpersonServiceInterface {

    SuperpersonDaoInterface superpersonDao;
    SuperpersonPowerServiceInterface superpersonPowerService;
    SightingSuperpersonServiceInterface sightingSuperpersonService;
    MoralityTypeServiceInterface moralityTypeService;
    PersonServiceInterface personService;
    LocationServiceInterface locationService;
    SightingServiceInterface sightingService;
    PowerServiceInterface powerService;
    OrganizationServiceInterface organizationService;

    public SuperpersonService(SuperpersonDaoInterface superpersonDao) {
        this.superpersonDao = superpersonDao;
    }
    
    public void setSuperpersonPowerService(SuperpersonPowerServiceInterface superpersonPowerService) {
        this.superpersonPowerService = superpersonPowerService;
    }
    
    public void setSightingSuperpersonService(SightingSuperpersonServiceInterface sightingSuperpersonService) {
        this.sightingSuperpersonService = sightingSuperpersonService;
    }
    
    public void setMoralityTypeService(MoralityTypeServiceInterface moralityTypeService) {
        this.moralityTypeService = moralityTypeService;
    }
    
    public void setPersonService(PersonServiceInterface personService) {
        this.personService = personService;
    }
    
    public void setLocationService(LocationServiceInterface locationService) {
        this.locationService = locationService;
    }
    
    public void setSightingService(SightingServiceInterface sightingService) {
        this.sightingService = sightingService;
    }

    public void setPowerService(PowerServiceInterface powerService) {
        this.powerService = powerService;
    }
    
    public void setOrganizationService(OrganizationServiceInterface organizationService) {
        this.organizationService = organizationService;
    }
    
    @Override
    public Superperson createSuperperson(Superperson superperson) {
        return superpersonDao.createSuperperson(superperson);
    }

    @Override
    public Superperson readSuperperson(int superpersonId) {
        return superpersonDao.readSuperperson(superpersonId);
    }

    @Override
    public List<Superperson> listSuperperson(int limit, int offset) {
        return superpersonDao.listSuperperson(limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonByMoralityType(MoralityType moralityType, int limit, int offset) {
        return superpersonDao.listSuperpersonByMoralityType(moralityType, limit, offset);
    }
    
    @Override
    public List<Superperson> listSuperpersonByMoralityType(int moralityTypeId, int limit, int offset) {
        return superpersonDao.listSuperpersonByMoralityType(moralityTypeService.readMoralityType(moralityTypeId), limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonByAliasId(Person alias, int limit, int offset) {
        return superpersonDao.listSuperpersonByAlias(alias, limit, offset);
    }
    
    @Override
    public List<Superperson> listSuperpersonByAliasId(int aliasId, int limit, int offset) {
        return superpersonDao.listSuperpersonByAlias(personService.readPerson(aliasId), limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonByLocation(Location location, int limit, int offset) {
        return superpersonDao.listSuperpersonByLocation(location, limit, offset);
    }
    
    @Override
    public List<Superperson> listSuperpersonByLocation(int locationId, int limit, int offset) {
        return superpersonDao.listSuperpersonByLocation(locationService.readLocation(locationId), limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonsBySighting(Sighting sighting, int limit, int offset) {
        return superpersonDao.listSuperpersonBySighting(sighting, limit, offset);
    }
    
    @Override
    public List<Superperson> listSuperpersonsBySighting(int sightingId, int limit, int offset) {
        return superpersonDao.listSuperpersonBySighting(sightingService.readSighting(sightingId), limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonsByPower(Power power, int limit, int offset) {
        return superpersonDao.listSuperpersonByPower(power, limit, offset);
    }
    
    @Override
    public List<Superperson> listSuperpersonsByPower(int powerId, int limit, int offset) {
        return superpersonDao.listSuperpersonByPower(powerService.readPower(powerId), limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonsByOrganization(Organization organization, int limit, int offset) {
        return superpersonDao.listSuperpersonByOrganization(organization, limit, offset);
    }
    
    @Override
    public List<Superperson> listSuperpersonsByOrganization(int organizationId, int limit, int offset) {
        return superpersonDao.listSuperpersonByOrganization(organizationService.readOrganization(organizationId), limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonsByPerson(Person person, int limit, int offset) {
        return superpersonDao.listSuperpersonByPerson(person, limit, offset);
    }
    
    @Override
    public List<Superperson> listSuperpersonsByPerson(int personId, int limit, int offset) {
        return superpersonDao.listSuperpersonByPerson(personService.readPerson(personId), limit, offset);
    }
    
    @Override
    public void updateSuperperson(Superperson superperson) {
        superpersonDao.updateSuperperson(superperson);
    }

    @Override
    public void deleteSuperperson(Superperson superperson) { //bridge table does not need checks, foreign keys do...
        superpersonPowerService.deleteSuperpersonPowerBySuperperson(superperson);
        sightingSuperpersonService.deleteSightingFromSuperperson(superperson);
        superpersonDao.deleteSuperperson(superperson.getSuperpersonId());
    }

}
