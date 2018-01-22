/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Controller;

import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Service.LocationServiceInterface;
import SuperheroSighting.Service.SightingServiceInterface;
import SuperheroSighting.Service.SuperpersonServiceInterface;
import SuperheroSighting.ViewModel.SightingViewModel;
import SuperheroSighting.ViewModel.IndexViewModel;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author EJB Laptop
 */

@Controller
public class IndexController {
    
    SightingServiceInterface service;
    SuperpersonServiceInterface superperson;
    LocationServiceInterface location;
    
    public IndexController(SightingServiceInterface service, SuperpersonServiceInterface superperson, LocationServiceInterface location) {
        this.service = service;
        this.superperson = superperson;
        this.location = location;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayIndex(HttpServletRequest request, Model model) {       
        List<IndexViewModel> ivm = service.listIndexViewModel(10, 0);               
        model.addAttribute("ivm", ivm);   
        return "Index";
    }
    
}