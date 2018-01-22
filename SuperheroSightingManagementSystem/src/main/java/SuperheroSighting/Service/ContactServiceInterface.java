/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface ContactServiceInterface {
    
    public Contact createContact(Contact contact);
    
    public Contact readContact(int contactId);

    public List<Contact> listContact(int limit, int offset);

    public List<Contact> listContactByOrganization(Organization organization, int limit, int offset);

    public List<Contact> listContactByOrganization(int organizationId, int limit, int offset);
    
    public List<Contact> listContactByAddress(Address address, int limit, int offset);
    
    public List<Contact> listContactByAddress(int addressId, int limit, int offset);

    public List<Contact> listContactByPerson(Person person, int limit, int offset);
 
    public List<Contact> listContactByPerson(int personId, int limit, int offset);
    
    public void updateContact(Contact contact);

    public void deleteContact(Contact contact) throws SuperheroSightingServiceException;
    
}
