/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dao.ContactDaoInterface;
import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class ContactService implements ContactServiceInterface {

    ContactDaoInterface contactDao;
    AddressServiceInterface addressService;
    PersonServiceInterface personService;
    OrganizationServiceInterface organizationService;

    public ContactService(ContactDaoInterface contactDao) {
        this.contactDao = contactDao;
    }
    
    public void setAddressService(AddressServiceInterface addressService) {
        this.addressService = addressService;
    }
    
    public void setPersonService(PersonServiceInterface personService) {
        this.personService = personService;
    }
    
    public void setOrganizationService(OrganizationServiceInterface organizationService) {
        this.organizationService = organizationService;
    }

    @Override
    public Contact createContact(Contact contact) {
        return contactDao.createContact(contact);
    }

    @Override
    public Contact readContact(int contactId) {
        return contactDao.readContact(contactId);
    }

    @Override
    public List<Contact> listContact(int limit, int offset) {
        return contactDao.listContact(limit, offset);
    }

    @Override
    public List<Contact> listContactByOrganization(Organization organization, int limit, int offset) {
        return contactDao.listContactByOrganization(organization, limit, offset);
    }
    
    @Override
    public List<Contact> listContactByOrganization(int organizationId, int limit, int offset) {
        return contactDao.listContactByOrganization(organizationService.readOrganization(organizationId), limit, offset);
    }
    
    @Override
    public List<Contact> listContactByAddress(Address address, int limit, int offset) {
        return contactDao.listContactByAddress(address, limit, offset);
    }

    @Override
    public List<Contact> listContactByAddress(int addressId, int limit, int offset) {
        return contactDao.listContactByAddress(addressService.readAddress(addressId), limit, offset);
    }
    
    @Override
    public List<Contact> listContactByPerson(Person person, int limit, int offset) {
        return contactDao.listContactByPerson(person, limit, offset);
    }  
    
    @Override
    public List<Contact> listContactByPerson(int personId, int limit, int offset) {
        return contactDao.listContactByPerson(personService.readPerson(personId), limit, offset);
    }  
    
    @Override
    public void updateContact(Contact contact) {
        contactDao.updateContact(contact);
    }

    @Override
    public void deleteContact(Contact contact) throws SuperheroSightingServiceException {
        
        
        List<Organization> organizationList = organizationService.listOrganizationByContact(contact, Integer.MAX_VALUE, 0);
        
        if(organizationList.size() > 0) {
            throw new SuperheroSightingServiceException("Warning: this contact is assigned to an address elsewhere in the system. You must delete the address first.");
        }   else {
            contactDao.deleteContact(contact.getContactId());
        }
    }



}
