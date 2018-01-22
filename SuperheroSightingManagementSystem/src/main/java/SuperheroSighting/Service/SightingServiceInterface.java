/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.User;
import SuperheroSighting.ViewModel.IndexViewModel;
import SuperheroSighting.ViewModel.SightingViewModel;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface SightingServiceInterface {
    
    public Sighting createSighting(Sighting sighting, List<Integer> superpersonIds);

    public Sighting readSighting(int sightingId);
    
    public List<Sighting> listSighting(int limit, int offset);

    public List<Sighting> listSightingBySuperperson(Superperson superperson, int limit, int offset);

    public List<Sighting> listSightingBySuperperson(int superpersonId, int limit, int offset);
    
    public List<Sighting> listSightingByLocation(Location location, int limit, int offset);

    public List<Sighting> listSightingByLocation(int locationId, int limit, int offset);
    
    public List<Sighting> listSightingByUser(User user, int limit, int offset);

    public List<Sighting> listSightingByUser(int userId, int limit, int offset);
    
    public List<Sighting> listSightingByDate(LocalDate sightingDate, int limit, int offset);
    
    public List<SightingViewModel> listSightingViewModel(int limit, int offset);
   
    public List<IndexViewModel> listIndexViewModel(int limit, int offset);
    
    public SightingViewModel getSightingViewModelBySighting(Sighting sighting);
    
    public SightingViewModel displayEditSightingForm(Sighting sighting);
    
    public void updateSighting(Sighting sighting, List<Integer> superpersonId);

    public void deleteSighting(Sighting sighting);
    
    public SightingViewModel displayCreateSightingForm();
    
    public List<Integer> getListPageNumbers(int limit, int offset);
    
}
