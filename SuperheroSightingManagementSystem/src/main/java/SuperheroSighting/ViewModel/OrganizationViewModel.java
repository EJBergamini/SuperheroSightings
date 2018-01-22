/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.ViewModel;

import SuperheroSighting.Dto.Organization;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class OrganizationViewModel {
    
    Organization organization;
    
    List<Organization> organizationList;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
    
    
}
