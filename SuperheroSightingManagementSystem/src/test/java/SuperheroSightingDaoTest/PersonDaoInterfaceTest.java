/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dao.PersonDaoInterface;
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
import org.springframework.context.ApplicationContext;

/**
 *
 * @author EJB Laptop
 */
public class PersonDaoInterfaceTest {
    
    private PersonDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public PersonDaoInterfaceTest() {
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

        dao = ctx.getBean("personDao", PersonDaoInterface.class);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createPerson method, of class PersonDaoInterface.
     */
    @Test
    public void testCreatePerson() {
    }

    /**
     * Test of readPersonById method, of class PersonDaoInterface.
     */
    @Test
    public void testReadPersonById() {
    }

    /**
     * Test of listPerson method, of class PersonDaoInterface.
     */
    @Test
    public void testListPerson() {
    }

    /**
     * Test of updatePerson method, of class PersonDaoInterface.
     */
    @Test
    public void testUpdatePerson() {
    }

    /**
     * Test of deletePerson method, of class PersonDaoInterface.
     */
    @Test
    public void testDeletePerson() {
    }

    /**
     * Test of listPersonByOrganization method, of class PersonDaoInterface.
     */
    @Test
    public void testListPersonByOrganization() {
    }

    /**
     * Test of deletePersonFromOrganization method, of class PersonDaoInterface.
     */
    @Test
    public void testDeletePersonFromOrganization() {
    }

    
}
