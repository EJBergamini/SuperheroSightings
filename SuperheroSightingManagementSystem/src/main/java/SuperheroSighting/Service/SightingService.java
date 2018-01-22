/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dao.SightingDaoInterface;
import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.SightingSuperperson;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.User;
import SuperheroSighting.ViewModel.IndexViewModel;
import SuperheroSighting.ViewModel.SightingViewModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class SightingService implements SightingServiceInterface {

    SightingDaoInterface sightingDao;
    LocationServiceInterface locationService;
    SightingSuperpersonServiceInterface sightingSuperpersonService;
    PersonServiceInterface personService;
    SuperpersonServiceInterface superpersonService;
    AddressServiceInterface addressService;
    UserServiceInterface userService;

    public SightingService(SightingDaoInterface sightingDao) {
        this.sightingDao = sightingDao;
    }
    
    public void setLocationService(LocationServiceInterface locationService) {
        this.locationService = locationService;
    }
    
    public void setSightingSuperpersonService (SightingSuperpersonServiceInterface sightingSuperpersonService) {
        this.sightingSuperpersonService = sightingSuperpersonService;
    }
    
    public void setPersonService(PersonServiceInterface personService) {
        this.personService = personService;
    }
    
    public void setSuperpersonService(SuperpersonServiceInterface superpersonService) {
        this.superpersonService = superpersonService;
    }
    
    public void setAddressService(AddressServiceInterface addressService) {
        this.addressService = addressService;
    }
    
    public void setUserService(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public Sighting createSighting(Sighting sighting, List<Integer> superpersonIds) {
        Sighting newSighting = sightingDao.createSighting(sighting);
        for(int spId : superpersonIds){
            Superperson sp = superpersonService.readSuperperson(spId);
            SightingSuperperson ssp = new SightingSuperperson();
            ssp.setSighting(newSighting);
            ssp.setSuperperson(sp);
            sightingSuperpersonService.createSightingSuperperson(ssp);
        }
        return newSighting;
    }

    @Override
    public Sighting readSighting(int sightingId) {
        return sightingDao.readSighting(sightingId);
    }

    @Override
    public List<Sighting> listSighting(int limit, int offset) {
        return sightingDao.listSighting(limit, offset);
    }

    @Override
    public List<Sighting> listSightingBySuperperson(Superperson superperson, int limit, int offset) {
        return sightingDao.listSightingBySuperperson(superperson, limit, offset);
    }
    
    @Override
    public List<Sighting> listSightingBySuperperson(int superpersonId, int limit, int offset) {
        return sightingDao.listSightingBySuperperson(superpersonService.readSuperperson(superpersonId), limit, offset);
    }

    @Override
    public List<Sighting> listSightingByLocation(Location location, int limit, int offset) {
        return sightingDao.listSightingByLocation(location, limit, offset);
    }
    
    @Override
    public List<Sighting> listSightingByLocation(int locationId, int limit, int offset) {
        return sightingDao.listSightingByLocation(locationService.readLocation(locationId), limit, offset);
    }

    @Override
    public List<Sighting> listSightingByUser(User user, int limit, int offset) {
        return sightingDao.listSightingByUser(user, limit, offset);
    }
    
    @Override
    public List<Sighting> listSightingByUser(int userId, int limit, int offset) {
        return sightingDao.listSightingByUser(userService.readUser(userId), limit, offset);
    }

    @Override
    public List<Sighting> listSightingByDate(LocalDate sightingDate, int limit, int offset) {
        return sightingDao.listSightingByDate(sightingDate, limit, offset);
    }

    @Override
    public List<SightingViewModel> listSightingViewModel(int limit, int offset) {
        List<Sighting> sighting = listSighting(limit, offset);
        List<SightingViewModel> result  = new ArrayList();
        for(Sighting s: sighting) {
            SightingViewModel svm = new SightingViewModel();
            List<Superperson> spList = superpersonService.listSuperpersonsBySighting(s, limit, offset);
            for(Superperson sp : spList){
                Person  p = personService.readPerson(sp.getPerson().getPersonId());
                Person alias = personService.readPerson(sp.getAlias().getPersonId());
                sp.setPerson(p);
                sp.setAlias(alias);
            }
            Location l = locationService.readLocation(s.getLocation().getLocationId());
            l.setAddress(addressService.readAddress(l.getAddress().getAddressId()));
            svm.setSighting(s);
            svm.setLocation(l);
            svm.setSuperpersonList(spList);
            result.add(svm);
        }  
        return result;
    }          
    
    @Override
    public List<IndexViewModel> listIndexViewModel(int limit, int offset) {
        List<Sighting> sighting = listSighting(limit, offset);
        List<IndexViewModel> result  = new ArrayList();
        for(Sighting s: sighting) {
            IndexViewModel ivm = new IndexViewModel();
            List<Superperson> spList = superpersonService.listSuperpersonsBySighting(s, limit, offset);
            for(Superperson sp : spList){
                Person  p = personService.readPerson(sp.getPerson().getPersonId());
                Person alias = personService.readPerson(sp.getAlias().getPersonId());
                sp.setPerson(p);
                sp.setAlias(alias);
            }
            Location l = locationService.readLocation(s.getLocation().getLocationId());
            ivm.setSighting(s);
            ivm.setLocation(l);
            ivm.setSuperpersonList(spList);
            result.add(ivm);
        }  
        return result;
    }        
    
    @Override
    public SightingViewModel getSightingViewModelBySighting(Sighting sighting) {
            SightingViewModel svm = new SightingViewModel();
            List<Superperson> spList = superpersonService.listSuperpersonsBySighting(sighting, Integer.MAX_VALUE, 0);
            for(Superperson sp : spList){
                Person  p = personService.readPerson(sp.getPerson().getPersonId());
                Person alias = personService.readPerson(sp.getAlias().getPersonId());
                sp.setPerson(p);
                sp.setAlias(alias);
            }                      
            User u = userService.readUser(sighting.getUser().getUserId());
            Person user = personService.readPerson(u.getPerson().getPersonId());
            u.setPerson(user);
            Location l = locationService.readLocation(sighting.getLocation().getLocationId());
            l.setAddress(addressService.readAddress(l.getAddress().getAddressId()));
            svm.setUser(u);
            svm.setSighting(sighting);
            svm.setLocation(l);
            svm.setSuperpersonList(spList);
            svm.setDisplaySightingDetailsBool(true);
        return svm;
    } 
    
    @Override
    public void updateSighting(Sighting sighting, List<Integer> superpersonId) {
        sightingDao.updateSighting(sighting);        
        if (superpersonId != null) {
            for (int spId : superpersonId) {
                SightingSuperperson sspNew = new SightingSuperperson();
                sspNew.setSighting(sighting);
                sspNew.setSuperperson(superpersonService.readSuperperson(spId));
                sightingSuperpersonService.createSightingSuperperson(sspNew);
            }
        }
    }

    @Override
    public void deleteSighting(Sighting sighting) {
        sightingSuperpersonService.deleteSuperpersonFromSighting(sighting);
        sightingDao.deleteSighting(sighting.getSightingId());
    }

    @Override
    public SightingViewModel displayCreateSightingForm() {
        SightingViewModel svm = new SightingViewModel();
        List<Location> allLocations = locationService.listLocation(Integer.MAX_VALUE, 0);
        List<Superperson> allSuperpersons = superpersonService.listSuperperson(Integer.MAX_VALUE, 0);   
        for (Superperson sp: allSuperpersons) {
            Person p = personService.readPerson(sp.getPerson().getPersonId());
            Person alias = personService.readPerson(sp.getAlias().getPersonId());
            sp.setPerson(p);
            sp.setAlias(alias);
            }
        svm.setDisplayCreateSightingFormBool(true);
        svm.setAllLocationList(allLocations);
        svm.setAllSuperpersonList(allSuperpersons);
        
        return svm;
    }
    
    @Override
    public SightingViewModel displayEditSightingForm(Sighting sighting) {
            SightingViewModel svm = new SightingViewModel();
            List<Superperson> spList = superpersonService.listSuperpersonsBySighting(sighting, Integer.MAX_VALUE, 0);
            List<Superperson> allSpList = superpersonService.listSuperperson(Integer.MAX_VALUE, 0);
            List<Location> allLocations = locationService.listLocation(Integer.MAX_VALUE, 0);
            for(Superperson sp : spList){
                Person  p = personService.readPerson(sp.getPerson().getPersonId());
                Person alias = personService.readPerson(sp.getAlias().getPersonId());
                sp.setPerson(p);
                sp.setAlias(alias);
            } 
            for(int i = 0; i<spList.size(); i++){
                for(int j = 0; j<allSpList.size(); j++){
                    if(spList.get(i).getSuperpersonId().equals(allSpList.get(j).getSuperpersonId())){
                        allSpList.remove(j);
                    }
                }                
            }           
            for(Superperson sp : allSpList){
                Person  p = personService.readPerson(sp.getPerson().getPersonId());
                Person alias = personService.readPerson(sp.getAlias().getPersonId());
                sp.setPerson(p);
                sp.setAlias(alias);
            }  
            for(Location l: allLocations) {
                Address a = addressService.readAddress(l.getAddress().getAddressId());
                l.setAddress(a);
            }
            User u = userService.readUser(sighting.getUser().getUserId());
            Person user = personService.readPerson(u.getPerson().getPersonId());
            u.setPerson(user);
            Location l = locationService.readLocation(sighting.getLocation().getLocationId());
            l.setAddress(addressService.readAddress(l.getAddress().getAddressId()));
            svm.setAllSuperpersonList(allSpList);
            svm.setUser(u);
            svm.setSighting(sighting);
            svm.setLocation(l);
            svm.setAllLocationList(allLocations);
            svm.setSuperpersonList(spList);
            svm.setDisplayEditSightingFormBool(true);
        return svm;
    } 
    
    @Override
    public List<Integer> getListPageNumbers(int limit, int offset){
        List<Sighting> sightings = listSighting(Integer.MAX_VALUE,offset);
        List<Integer> pageNumbers = new ArrayList();
        for(int i=1; i<=sightings.size(); i++){
            if(i%limit==0){
                pageNumbers.add(((i-1)/limit)+1);
            }
        }
        if(sightings.size()%limit>0){
                pageNumbers.add(pageNumbers.size()+1);
            }
        return pageNumbers;
    }
    
}
