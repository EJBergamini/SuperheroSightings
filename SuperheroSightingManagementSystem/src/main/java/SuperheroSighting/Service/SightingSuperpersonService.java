/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Service.SightingServiceInterface;
import SuperheroSighting.Dao.SightingSuperpersonDaoInterface;
import SuperheroSighting.Service.SuperpersonServiceInterface;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.SightingSuperperson;
import SuperheroSighting.Dto.Superperson;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class SightingSuperpersonService implements SightingSuperpersonServiceInterface {

    SightingSuperpersonDaoInterface sightingSuperpersonDao;
    SuperpersonServiceInterface superpersonService;
    SightingServiceInterface sightingService;

    public SightingSuperpersonService(SightingSuperpersonDaoInterface sightingSuperpersonDao) {
        this.sightingSuperpersonDao = sightingSuperpersonDao;
    }

    public void setSuperpersonService(SuperpersonServiceInterface superpersonService) {
        this.superpersonService = superpersonService;
    }
    
    public void setSightingService(SightingServiceInterface sightingService) {
        this.sightingService = sightingService;
    }
    
    @Override
    public SightingSuperperson createSightingSuperperson(SightingSuperperson sightingSuperperson) {
        return sightingSuperpersonDao.createSightingSuperperson(sightingSuperperson);
    }

    @Override
    public SightingSuperperson readSightingSuperperson(SightingSuperperson sightingSuperperson) {
        return sightingSuperpersonDao.readSightingSuperperson(sightingSuperperson.getSightingSuperpersonId());
    }

    @Override
    public List<SightingSuperperson> listSightingSuperperson(int limit, int offset) {
        return sightingSuperpersonDao.listSightingSuperperson(limit, offset);
    }

    @Override
    public List<SightingSuperperson> listSightingSuperpersonBySuperperson(Superperson superperson, int limit, int offset) {
        return sightingSuperpersonDao.listSightingSuperpersonBySuperperson(superperson, limit, offset);
    }
    
    @Override
    public List<SightingSuperperson> listSightingSuperpersonBySuperperson(int superpersonId, int limit, int offset) {
        return sightingSuperpersonDao.listSightingSuperpersonBySuperperson(superpersonService.readSuperperson(superpersonId), limit, offset);
    }

    @Override
    public List<SightingSuperperson> listSightingSuperpersonBySighting(Sighting sighting, int limit, int offset) {
        return sightingSuperpersonDao.listSightingSuperpersonBySighting(sighting, limit, offset);
    }
    
    @Override
    public List<SightingSuperperson> listSightingSuperpersonBySighting(int sightingId, int limit, int offset) {
        return sightingSuperpersonDao.listSightingSuperpersonBySighting(sightingService.readSighting(sightingId), limit, offset);
    }

    @Override
    public void updateSightingSuperperson(SightingSuperperson sightingSuperperson) {
        sightingSuperpersonDao.updateSightingSuperperson(sightingSuperperson);
    }

    @Override
    public void deleteSightingSuperperson(SightingSuperperson sightingSuperperson) {
        sightingSuperpersonDao.deleteSightingSuperperson(sightingSuperperson.getSightingSuperpersonId());
    }

    @Override
    public void deleteSuperpersonFromSighting(Sighting sighting) {
        sightingSuperpersonDao.deleteSightingSuperpersonBySighting(sighting);
    }

    @Override
    public void deleteSightingFromSuperperson(Superperson superperson) {
        sightingSuperpersonDao.deleteSightingSuperpersonBySuperperson(superperson);
    }
   
}
