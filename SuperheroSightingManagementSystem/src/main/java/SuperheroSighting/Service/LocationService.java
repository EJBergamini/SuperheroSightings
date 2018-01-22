/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dao.LocationDaoInterface;
import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.Superperson;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class LocationService implements LocationServiceInterface {

    LocationDaoInterface locationDao;
    SightingServiceInterface sightingService;
    SuperpersonServiceInterface superpersonService;
    AddressServiceInterface addressService;
    
    public LocationService(LocationDaoInterface locationDao) {
        this.locationDao = locationDao;     
    }
    
    public void setSightingService(SightingServiceInterface sightingService){
        this.sightingService = sightingService;
    }
    
    public void setSuperpersonService(SuperpersonServiceInterface superpersonService) {
        this.superpersonService = superpersonService;
    }
    
    public void setAddressService(AddressServiceInterface addressService) {
        this.addressService = addressService;
    }
    
    @Override
    public Location createLocation(Location location) {
        return locationDao.createLocation(location);
    }

    @Override
    public Location readLocation(int locationId) {
        return locationDao.readLocation(locationId);
    }

    @Override
    public List<Location> listLocation(int limit, int offset) {
        return locationDao.listLocation(limit, offset);
    }
    
    @Override
    public List<Location> listLocationBySuperperson(Superperson superperson, int limit, int offset) {
        return locationDao.listLocationBySuperperson(superperson, limit, offset);
    }
       
    @Override
    public List<Location> listLocationBySuperperson(int superpersonId, int limit, int offset) {
        return locationDao.listLocationBySuperperson(superpersonService.readSuperperson(superpersonId), limit, offset);
    }
    
    @Override
    public List<Location> listLocationByAddress(Address address, int limit, int offset) {
        return locationDao.listLocationByAddress(address, limit, offset);
    }    
    
    @Override
    public List<Location> listLocationByAddress(int addressId, int limit, int offset) {
        return locationDao.listLocationByAddress(addressService.readAddress(addressId), limit, offset);
    }
    
    @Override
    public void updateLocation(Location location) {
        locationDao.updateLocation(location);
    }

    @Override
    public void deleteLocation(Location location) throws SuperheroSightingServiceException {
        
        List<Sighting> sightingList = sightingService.listSightingByLocation(location, Integer.MAX_VALUE, 0);
        
        if(sightingList.size() > 0) {
            throw new SuperheroSightingServiceException("Warning: there is a sighting associated with this location, you must delete the sighting first.");
        }   else {
            locationDao.deleteLocation(location.getLocationId());
        }
    }

}
