/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface PersonDaoInterface {
    
    public Person createPerson(Person person);
    
    public Person readPerson(Integer personId);
    
    public List<Person> listPerson(int limit, int offset);
    
    public void updatePerson(Person person);
    
    public void deletePerson(Integer personId);
    
    public List<Person> listPersonByOrganization(Organization organization, int limit, int offset);
    
    public List<Person> listPersonByContact(Contact contact, int limit, int offset);
    
}
