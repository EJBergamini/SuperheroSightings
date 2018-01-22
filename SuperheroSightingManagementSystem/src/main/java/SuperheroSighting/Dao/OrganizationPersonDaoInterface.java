/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.OrganizationPerson;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.Superperson;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface OrganizationPersonDaoInterface {
    
    public OrganizationPerson createOrganizationPerson(OrganizationPerson organizationPerson);
    
    public OrganizationPerson readOrganizationPerson(Integer organizationPersonId); 
    
    public List<OrganizationPerson> listOrganizationPerson(int limit, int offset);
    
    public void updateOrganizationPerson(OrganizationPerson organizationPerson);
            
    public void deleteOrganizationPerson(Integer organizationPersonId);
    
    public List<OrganizationPerson> listOrganizationPersonByOrganization(Organization organization, int limit, int offset);
    
    public List<OrganizationPerson> listOrganizationPersonByPerson(Person person, int limit, int offset);
    
    public void deleteOrganizationPersonByOrganization(Organization organization);
    
    public void deleteOrganizationPersonByPerson(Person person);
    
}
