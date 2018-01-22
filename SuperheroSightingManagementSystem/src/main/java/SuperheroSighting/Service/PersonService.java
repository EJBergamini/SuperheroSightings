/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Service.OrganizationServiceInterface;
import SuperheroSighting.Dao.PersonDaoInterface;
import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.User;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class PersonService implements PersonServiceInterface {

    PersonDaoInterface personDao;
    SuperpersonServiceInterface superpersonService;
    ContactServiceInterface contactService;
    UserServiceInterface userService;
    OrganizationPersonServiceInterface organizationPersonService;
    OrganizationServiceInterface organizationService;

    public PersonService(PersonDaoInterface personDao) {
        this.personDao = personDao;
    }

    public void setSuperpersonService(SuperpersonServiceInterface superpersonService) { 
        this.superpersonService = superpersonService;
    }
    
    public void setContactService(ContactServiceInterface contactService) {
        this.contactService = contactService;
    }
    
    public void setUserService(UserServiceInterface userService) {
        this.userService = userService;
    }
    
    public void setOrganizationPersonService(OrganizationPersonServiceInterface organizationPersonService) {
        this.organizationPersonService = organizationPersonService;
    }
    
    public void setOrganizationService(OrganizationServiceInterface organizationService) {
        this.organizationService = organizationService;
    }
    
    @Override
    public Person createPerson(Person person) {
        return personDao.createPerson(person);
    }

    @Override
    public Person readPerson(int personId) {
        return personDao.readPerson(personId);
    }

    @Override
    public List<Person> listPerson(int limit, int offset) {
        return personDao.listPerson(limit, offset);
    }

    @Override
    public List<Person> listPersonByOrganization(Organization organization, int limit, int offset) {
        return personDao.listPersonByOrganization(organization, limit, offset);
    }
    
    @Override
    public List<Person> listPersonByOrganization(int organizationId, int limit, int offset) {
        return personDao.listPersonByOrganization(organizationService.readOrganization(organizationId), limit, offset);
    }
    
    @Override 
    public List<Person> listPersonByContact(Contact contact, int limit, int offset) {
        return personDao.listPersonByContact(contact, limit, offset);
    }
    
    @Override
    public List<Person> listPersonByContact(int contactId, int limit, int offset) {
        return personDao.listPersonByContact(contactService.readContact(contactId), limit, offset);
    }
    
    @Override
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    public void deletePerson(Person person) throws SuperheroSightingServiceException {
        
        List<Superperson> superpersonList = superpersonService.listSuperpersonsByPerson(person, Integer.MAX_VALUE, 0);
        List<Contact> contactList = contactService.listContactByPerson(person, Integer.MAX_VALUE, 0);
        List<User> userList = userService.listUserByPerson(person, Integer.MAX_VALUE, 0);
        
        if(superpersonList.size() > 0) {
            throw new SuperheroSightingServiceException("Warning: there is a Superhero associated with this person. You cannot delete a person while it is associated with a Superhero, delete the Superhero first.");
        }   else if(contactList.size() > 0) {
            throw new SuperheroSightingServiceException("Warning: there is an Organization contact associated with this person. You cannot delete a person while it is associated with an Organization, delete the Organization association first.");
        }   else if (userList.size() > 0) {
            throw new SuperheroSightingServiceException("Warning: there is a User associated with this person, you must delete the User association before deleting the person.");
        }   else {
            organizationPersonService.deleteOrganizationPersonByPerson(person);
            personDao.deletePerson(person.getPersonId());
        } 
    }
       
}
