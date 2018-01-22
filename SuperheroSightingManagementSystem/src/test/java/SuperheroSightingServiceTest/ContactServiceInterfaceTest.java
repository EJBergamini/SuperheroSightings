/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Service.ContactServiceInterface;
import SuperheroSightingApplicationContextHelper.ApplicationContextHelper;
import SuperheroSightingDaoTest.TestingDataInjector;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author EJB Laptop
 */
public class ContactServiceInterfaceTest {
    
    private ContactServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public ContactServiceInterfaceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        ApplicationContextHelper ach = new ApplicationContextHelper();
        
        TestingDataInjector dbInjection;
        
        ApplicationContext ctx = ach.getContext();
        
        dbInjection = ctx.getBean("dbInjection", TestingDataInjector.class);
        
        dbInjection.setUpDatabase();
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        ApplicationContextHelper ach = new ApplicationContextHelper();
        
        TestingDataInjector dbInjection;
        
        ApplicationContext ctx = ach.getContext();
        
        dbInjection = ctx.getBean("dbInjection", TestingDataInjector.class);
        
        dbInjection.tearDownDatabase();
        
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx= ach.getContext();
        
        service = ctx.getBean("contactService", ContactServiceInterface.class);
        
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of createContact method, of class ContactDaoInterface.
     */
    @Test
    @Rollback(true)
    public void testCreateAndReadContact() throws Exception {
        
        Contact contact1 = new Contact();
        Address address1 = new Address();
        address1.setAddressId(1);
        contact1.setAddress(address1);
        Person person1 = new Person();
        person1.setPersonId(3);
        contact1.setPerson(person1);
        contact1.setPhoneNumber("206-354-2923");
        service.createContact(contact1);
        
        Contact fromDb1 = service.readContact(contact1.getContactId());
        
        assertEquals(fromDb1.getPhoneNumber(),"206-354-2923");
        
        service.deleteContact(contact1);
    
    }

    /**
     * Test of readContactById method, of class ContactDaoInterface.
     */
    @Ignore
    @Test
    @Rollback(true)
    public void testListContact() {     
        
        List<Contact> contacts = service.listContact(10,0);
        
        assertEquals(contacts.size(), 5);
        
        
    }

    /**
     * Test of listContact method, of class ContactDaoInterface.
     */
    @Test
    @Rollback(true)
    public void testUpdateContact() {
        
        Contact contact1 = new Contact();
        Address address1 = new Address();
        address1.setAddressId(1);
        contact1.setAddress(address1);
        Person person1 = new Person();
        person1.setPersonId(3);
        contact1.setPerson(person1);
        contact1.setPhoneNumber("206-354-2923");
        service.createContact(contact1);
        
        Contact fromDb1 = service.readContact(contact1.getContactId());
        
        assertEquals(fromDb1, contact1);
        
    }

    /**
     * Test of updateContact method, of class ContactDaoInterface.
     */
    @Test
    @Rollback(true)
    public void testDeleteContact() throws Exception {
        
        Contact contact1 = new Contact();
        Address address1 = new Address();
        address1.setAddressId(1);
        contact1.setAddress(address1);
        Person person1 = new Person();
        person1.setPersonId(3);
        contact1.setPerson(person1);
        contact1.setPhoneNumber("206-354-2923");
        service.createContact(contact1);
        
        service.deleteContact(contact1);
        assertNull(service.readContact(contact1.getContactId()));
        
    }

    

    /**
     * Test of readContactByOrganization method, of class ContactDaoInterface.
     */

    @Test
    @Rollback(true)
    public void testReadContactByOrganization() {
        
        Organization org = new Organization();

        org.setOrganizationId(1);

        List<Contact> contactList = service.listContactByOrganization(org,10,0);

        Contact fromDb = contactList.get(0);

        assertTrue(contactList.size() == 1);

        assertTrue(fromDb.getAddress().getAddressId()== 1);

        assertTrue(fromDb.getPerson().getPersonId()==2);

        assertEquals(fromDb.getPhoneNumber(), "2164325561");
        
    }
    
}
