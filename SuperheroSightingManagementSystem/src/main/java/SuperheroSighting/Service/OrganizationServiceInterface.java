/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.MoralityType;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.ViewModel.OrganizationViewModel;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface OrganizationServiceInterface {
    
    public Organization createOrganization(Organization organization);

    public Organization readOrganization(int organizationId);
    
    public List<Organization> listOrganization(int limit, int offset);
  
    public List<Organization> listOrganizationByMoralityType(MoralityType moralityType, int limit, int offset);
  
    public List<Organization> listOrganizationByMoralityType(int moralityTypeId, int limit, int offset);
    
    public List<Organization> listOrganizationByPerson(Person person, int limit, int offset);
   
    public List<Organization> listOrganizationByPerson(int PersonId, int limit, int offset);
    
    public List<Organization> listOrganizationBySuperPerson(Superperson superperson, int limit, int offset);

    public List<Organization> listOrganizationBySuperperson(int superpersonId, int limit, int offset);
    
    public List<Organization> listOrganizationByContact(Contact contact, int limit, int offset);

    public List<Organization> listOrganizationByContact(int contactId, int limit, int offset);
    
    public List<Organization> listOrganizationByAddress(Address address, int limit, int offset);
    
    public List<Organization> listOrganizationByAddress(int addressId, int limit, int offset);
    
    public void updateOrganization(Organization organization);

    public void deleteOrganization(Organization organization);
    
    public OrganizationViewModel organizationViewModel(int limit, int offset);
    
}
