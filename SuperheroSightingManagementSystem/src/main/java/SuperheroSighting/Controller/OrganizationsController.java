/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Controller;

import SuperheroSighting.Service.OrganizationServiceInterface;
import SuperheroSighting.ViewModel.OrganizationViewModel;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author EJB Laptop
 */
public class OrganizationsController {
    
    OrganizationServiceInterface service;

    public OrganizationsController(OrganizationServiceInterface service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/displayOrganizations", method = RequestMethod.GET)
    public String displayOrganizations(HttpServletRequest request, Model model) {        
        OrganizationViewModel ovm = service.organizationViewModel(100, 0);               
        model.addAttribute("ovm", ovm);   
        return "/Organizations";
    }
    
}
