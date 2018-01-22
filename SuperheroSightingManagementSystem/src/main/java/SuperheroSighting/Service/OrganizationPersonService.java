/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dao.OrganizationPersonDaoInterface;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.OrganizationPerson;
import SuperheroSighting.Dto.Person;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class OrganizationPersonService implements OrganizationPersonServiceInterface {

    OrganizationPersonDaoInterface organizationPersonDao;
    PersonServiceInterface personService;
    OrganizationServiceInterface organizationService;
    
    public OrganizationPersonService(OrganizationPersonDaoInterface organizationPersonDao) {
        this.organizationPersonDao = organizationPersonDao;
    }
    
    public void setPersonService(PersonServiceInterface personService) {
        this.personService = personService;
    }
    
    public void setOrganizationService(OrganizationServiceInterface organizationService) {
        this.organizationService = organizationService;
    }

    @Override
    public OrganizationPerson createOrganizationPerson(OrganizationPerson organizationPerson) {
        return organizationPersonDao.createOrganizationPerson(organizationPerson);
    }

    @Override
    public OrganizationPerson readOrganizationPerson(int organizationPerson) {
        return organizationPersonDao.readOrganizationPerson(organizationPerson);
    }

    @Override
    public List<OrganizationPerson> listOrganizationPerson(int limit, int offset) {
        return organizationPersonDao.listOrganizationPerson(limit, offset);
    }

    @Override
    public List<OrganizationPerson> listOrganizationPersonByPerson(Person person, int limit, int offset) {
        return organizationPersonDao.listOrganizationPersonByPerson(person, limit, offset);
    }

    @Override
    public List<OrganizationPerson> listOrganizationPersonByPerson(int personId, int limit, int offset) {
        return organizationPersonDao.listOrganizationPersonByPerson(personService.readPerson(personId), limit, offset);
    }
    
    @Override
    public List<OrganizationPerson> listOrganizationPersonByOrganization(Organization organization, int limit, int offset) {
        return organizationPersonDao.listOrganizationPersonByOrganization(organization, limit, offset);
    }

    @Override
    public List<OrganizationPerson> listOrganizationPersonByOrganization(int organizationId, int limit, int offset) {
        return organizationPersonDao.listOrganizationPersonByOrganization(organizationService.readOrganization(organizationId), limit, offset);
    }
    
    @Override
    public void updateOrganizationPerson(OrganizationPerson organizationPerson) {
        organizationPersonDao.updateOrganizationPerson(organizationPerson);
    }

    @Override
    public void deleteOrganizationPerson(OrganizationPerson organizationPerson) {
        organizationPersonDao.deleteOrganizationPerson(organizationPerson.getOrganizationPersonId());
    }

    @Override
    public void deleteOrganizationPersonByPerson(Person person) {
        organizationPersonDao.deleteOrganizationPersonByPerson(person);
    }

    @Override
    public void deleteOrganizationPersonByOrganization(Organization organization) {
        organizationPersonDao.deleteOrganizationPersonByOrganization(organization);
    }  

}
