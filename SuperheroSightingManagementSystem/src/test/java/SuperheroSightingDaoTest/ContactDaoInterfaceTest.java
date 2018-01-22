/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dao.ContactDaoInterface;
import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import SuperheroSightingApplicationContextHelper.ApplicationContextHelper;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author EJB Laptop
 */
public class ContactDaoInterfaceTest {
    
    private ContactDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public ContactDaoInterfaceTest() {
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
        
        dao = ctx.getBean("contactDao", ContactDaoInterface.class);
                
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of createContact method, of class ContactDaoInterface.
     */
    @Test
    @Rollback(true)
    public void testCreateAndReadContact() {
        
        Contact contact1 = new Contact();
        Address address1 = new Address();
        address1.setAddressId(1);
        contact1.setAddress(address1);
        Person person1 = new Person();
        person1.setPersonId(3);
        contact1.setPerson(person1);
        contact1.setPhoneNumber("206-354-2923");
        dao.createContact(contact1);
        
        Contact fromDb1 = dao.readContact(contact1.getContactId());
        
        assertEquals(fromDb1.getPhoneNumber(),"206-354-2923");
    
    }

    /**
     * Test of readContactById method, of class ContactDaoInterface.
     */
    @Test
    @Rollback(true)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testListContact() {
        
        Contact contact1 = new Contact();
        Address address1 = new Address();
        address1.setAddressId(1);
        contact1.setAddress(address1);
        Person person1 = new Person();
        person1.setPersonId(2);
        contact1.setPerson(person1);
        contact1.setPhoneNumber("206-354-2923");
        dao.createContact(contact1);
        
        Contact contact2 = new Contact();
        Address address2 = new Address();
        address2.setAddressId(2);
        contact2.setAddress(address2);
        Person person2 = new Person();
        person2.setPersonId(3);
        contact2.setPerson(person2);
        contact2.setPhoneNumber("330-555-6699");
        dao.createContact(contact2);
        
        Contact contact3 = new Contact();
        Address address3 = new Address();
        address3.setAddressId(3);
        contact3.setAddress(address1);
        Person person3 = new Person();
        person3.setPersonId(4);
        contact3.setPerson(person3);
        contact3.setPhoneNumber("216-543-4322");
        dao.createContact(contact3);
        
        List<Contact> contacts = dao.listContact(10,0);
        
        Contact fromList1 = contacts.get(5);
        Contact fromList2 = contacts.get(6);
        Contact fromList3 = contacts.get(7);
        
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
        dao.createContact(contact1);
        
        Contact fromDb1 = dao.readContact(contact1.getContactId());
        
        assertEquals(fromDb1, contact1);
        
    }

    /**
     * Test of updateContact method, of class ContactDaoInterface.
     */
    @Test
    @Rollback(true)
    public void testDeleteContact() {
        
        Contact contact1 = new Contact();
        Address address1 = new Address();
        address1.setAddressId(1);
        contact1.setAddress(address1);
        Person person1 = new Person();
        person1.setPersonId(3);
        contact1.setPerson(person1);
        contact1.setPhoneNumber("206-354-2923");
        dao.createContact(contact1);
        
        Contact contact = dao.readContact(contact1.getContactId());
        assertEquals("206-354-2923", contact.getPhoneNumber());
        
        
        dao.deleteContact(contact1.getContactId());
        assertNull(dao.readContact(contact1.getContactId()));
        
    }

    

    /**
     * Test of readContactByOrganization method, of class ContactDaoInterface.
     */
    @Ignore
    @Test
    @Rollback(true)
    public void testReadContactByOrganization() {
        
        Organization org = new Organization();

        org.setOrganizationId(1);

        List<Contact> contactList = dao.listContactByOrganization(org,0,0);

        //Contact fromDb = contactList.get(0);

        assertTrue(contactList.size() == 1);

        //assertTrue(fromDb.getAddress().getAddressId()== 1);

        //assertTrue(fromDb.getPerson().getPersonId()==2);

        //assertEquals(fromDb.getPhoneNumber(), "2164325561");
        
    }

    
}
