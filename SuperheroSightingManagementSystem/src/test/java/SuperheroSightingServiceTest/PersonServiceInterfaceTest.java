/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Service.AddressServiceInterface;
import SuperheroSighting.Service.PersonServiceInterface;
import SuperheroSightingApplicationContextHelper.ApplicationContextHelper;
import SuperheroSightingDaoTest.TestingDataInjector;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author EJB Laptop
 */
public class PersonServiceInterfaceTest {
    
    private PersonServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public PersonServiceInterfaceTest() {
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
        
        service = ctx.getBean("personService", PersonServiceInterface.class);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createPerson method, of class PersonServiceInterface.
     */
    @Test
    public void testCreatePerson() {
    }

    /**
     * Test of readPerson method, of class PersonServiceInterface.
     */
    @Test
    public void testReadPerson() {
    }

    /**
     * Test of listPerson method, of class PersonServiceInterface.
     */
    @Test
    public void testListPerson() {
    }

    /**
     * Test of listPersonByOrganization method, of class PersonServiceInterface.
     */
    @Test
    public void testListPersonByOrganization() {
    }

    /**
     * Test of updatePerson method, of class PersonServiceInterface.
     */
    @Test
    public void testUpdatePerson() {
    }

    /**
     * Test of removePerson method, of class PersonServiceInterface.
     */
    @Test
    public void testRemovePerson() {
    }

   
    
}
