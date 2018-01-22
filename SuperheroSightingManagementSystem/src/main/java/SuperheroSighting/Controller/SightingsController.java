/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Controller;

import SuperheroSighting.CommandModel.CreateSightingCommandModel;
import SuperheroSighting.CommandModel.UpdateSightingCommandModel;
import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.User;
import SuperheroSighting.Service.LocationServiceInterface;
import SuperheroSighting.Service.SightingServiceInterface;
import SuperheroSighting.Service.SightingSuperpersonServiceInterface;
import SuperheroSighting.Service.SuperpersonServiceInterface;
import SuperheroSighting.ViewModel.IndexViewModel;
import SuperheroSighting.ViewModel.SightingViewModel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author EJB Laptop
 */

@Controller
@RequestMapping({"Sightings"})
public class SightingsController {
    
    SightingServiceInterface service;
    SuperpersonServiceInterface superperson;
    LocationServiceInterface location;
    SightingSuperpersonServiceInterface sightingSuperperson;
    
    public SightingsController(SightingServiceInterface service, SuperpersonServiceInterface superperson, LocationServiceInterface location, SightingSuperpersonServiceInterface sightingSuperperson) {
        this.service = service;
        this.superperson = superperson;
        this.location = location;
        this.sightingSuperperson = sightingSuperperson;
    }
    
    @RequestMapping(value = "/displaySightings", method = RequestMethod.GET)
    public String displaySightings(HttpServletRequest request, Model model) {        
        List<SightingViewModel> svm = service.listSightingViewModel(100, 0);               
        model.addAttribute("svm", svm);   
        return "/Sightings";
    }
    
//    @RequestMapping(value = "/displaySightings", method = RequestMethod.GET)
//    public String displaySightings(HttpServletRequest request, Model model) {
//        //String offsetParam = request.getParameter("offset");
//        //int offset = Integer.parseInt(offsetParam);
//        //int offset = 10; 
//        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
//        int offsetValue = ((pageNumber - 1) * 10) + 1;
//        List<SightingViewModel> svm = service.listSightingViewModel(10, offsetValue);
//        SightingViewModel pages = new SightingViewModel();
//        pages.setPageNumbers(service.getListPageNumbers(10, offset));
//        List<Integer> pageNumbers = service.getListPageNumbers(10, offset);
//        model.addAttribute("pageNumbers", pageNumbers);
//        model.addAttribute("svm", svm);
//        return "/Sightings";
//    }
    
    
    
    
    
    
    @RequestMapping(value="/displaySightingDetails", method=RequestMethod.GET)
    public String displaySightingDetails(HttpServletRequest request, @RequestParam(value="displaySightingDetailsBool", defaultValue="false") boolean displaySightingDetailsBool, Model model){
        String sightingIdParam = request.getParameter("sightingId");
        //String offsetParam = request.getParameter("offset");
        //int offset = Integer.parseInt(offsetParam);
        int sightingId = Integer.parseInt(sightingIdParam);       
        List<SightingViewModel> svm = service.listSightingViewModel(10,0);
        Sighting sighting = service.readSighting(sightingId);
        SightingViewModel svmSighting = service.getSightingViewModelBySighting(sighting);     
        model.addAttribute("svmSighting", svmSighting);
        model.addAttribute("svm", svm);
        return "/Sightings";
    }
    
    @RequestMapping(value="/displayCreateSightingForm", method=RequestMethod.GET)
    public String displayCreateSightingForm(HttpServletRequest request, @RequestParam(value="displayCreateSightingFormBool", defaultValue="false") boolean displayCreateSightingFormBool, Model model) {       
        List<SightingViewModel> svm = service.listSightingViewModel(Integer.MAX_VALUE, 0);
        SightingViewModel svmSighting = service.displayCreateSightingForm();
        model.addAttribute("svm", svm);
        model.addAttribute("svmSighting", svmSighting);
        return "/Sightings";                
    }
    
    @RequestMapping(value = "/addSighting", method = RequestMethod.POST)
        public String createSighting(@Valid @ModelAttribute CreateSightingCommandModel cscm, HttpServletRequest request, Model model, BindingResult result) {
        Sighting sg = new Sighting();
        Location l = new Location();
        l.setLocationId(cscm.getLocationId());
        sg.setSightingDescription(cscm.getSightingDescription());
        sg.setLocation(l);
        sg.setSightingDateTime(LocalDateTime.of(cscm.getSightingDate(), cscm.getSightingTime()));
        User user = new User();
        user.setUserId(1);
        sg.setUser(user);
        service.createSighting(sg, cscm.getSuperpersonBySightingId());
        List<SightingViewModel> svm = service.listSightingViewModel(10, 0);
        SightingViewModel svmSighting = service.displayCreateSightingForm();
        model.addAttribute("svm", svm);
        model.addAttribute("svmSighting", svmSighting);
        return "/Sightings";
  }
   
    @RequestMapping(value="/displayEditSightingForm", method=RequestMethod.GET)
    public String displayEditSightingForm(HttpServletRequest request, @RequestParam(value="displayEditSightingFormBool", defaultValue="false") boolean displayEditSightingFormBool, Model model) {
        String sightingIdParam = request.getParameter("sightingId");
        int sightingId = Integer.parseInt(sightingIdParam);       
        Sighting sighting = service.readSighting(sightingId);               
        List<SightingViewModel> svm = service.listSightingViewModel(10,0);        
        SightingViewModel svmSighting = service.displayEditSightingForm(sighting);     
        model.addAttribute("svmSighting", svmSighting);
        model.addAttribute("svm", svm);       
        return "/Sightings";
    }
    
    @RequestMapping(value="/editSighting", method=RequestMethod.POST)
    public String editSighting(@ModelAttribute UpdateSightingCommandModel uscm, Model model, BindingResult result) {
        Sighting sighting = service.readSighting(uscm.getSightingId());
        Location location = new Location();
        location.setLocationId(uscm.getLocationId());
        sighting.setLocation(location);
        sighting.setSightingDateTime(LocalDateTime.of(uscm.getSightingDate(), uscm.getSightingTime()));
        User user = new User();
        user.setUserId(uscm.getUserId());
        sighting.setUser(user);
        sighting.setSightingId(uscm.getSightingId());
        sighting.setSightingDescription(uscm.getSightingDescription());
        service.updateSighting(sighting, uscm.getSuperpersonBySightingId()); 
        List<SightingViewModel> svm = service.listSightingViewModel(10, 0);
        model.addAttribute("svm", svm);
        return "/Sightings";
    }
    
    @RequestMapping(value="/removeSuperPersonFromSighting", method=RequestMethod.GET)
    public String removeSuperPersonFromSighting(HttpServletRequest request,@RequestParam(value="displayEditSightingFormBool", defaultValue="false") boolean displayEditSightingFormBool , Model model){
        String superPersonIdParam = request.getParameter("superPersonId");
        String sightingIdParam = request.getParameter("sightingId");
        int superPersonId = Integer.parseInt(superPersonIdParam);
        int sightingId = Integer.parseInt(sightingIdParam);
        Superperson sp = new Superperson();
        sp.setSuperpersonId(superPersonId);
        sightingSuperperson.deleteSightingFromSuperperson(sp);
        List<SightingViewModel> svm = service.listSightingViewModel(10, 0);      
        Sighting sighting = service.readSighting(sightingId);
        SightingViewModel svmSighting = service.displayEditSightingForm(sighting);
        model.addAttribute("svmSighting", svmSighting);
        model.addAttribute("svm", svm);
        return "/Sightings";
    }
    
    @RequestMapping(value="/deleteSighting", method=RequestMethod.POST)
    public String deleteSighting() {
        return "/Sightings";
    }
    
}
    
        
                  