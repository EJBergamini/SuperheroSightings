/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface ContactDaoInterface {
    
    public Contact createContact(Contact contact);
    
    public Contact readContact(Integer contactId);
    
    public List<Contact> listContact(int limit, int offset);
    
    public void updateContact(Contact contact);
    
    public void deleteContact(Integer contactId);
    
    public List<Contact> listContactByOrganization(Organization organization, int limit, int offset);
    
    public List<Contact> listContactByAddress(Address address, int limit, int offset);
    
    public List<Contact> listContactByPerson(Person person, int limit, int offset);
    
}
