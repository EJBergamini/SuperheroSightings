/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.SightingSuperperson;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Service.AddressServiceInterface;
import SuperheroSighting.Service.SightingSuperpersonServiceInterface;
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
public class SightingSuperpersonServiceInterfaceTest {
    
    private SightingSuperpersonServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public SightingSuperpersonServiceInterfaceTest() {
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
        
        service = ctx.getBean("sightingSuperpersonService", SightingSuperpersonServiceInterface.class);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createSightingSuperPerson method, of class SightingSuperpersonServiceInterface.
     */
    @Test
    public void testCreateSightingSuperPerson() {
    }

    /**
     * Test of listSightingSuperpersonById method, of class SightingSuperpersonServiceInterface.
     */
    @Test
    public void testListSightingSuperpersonById() {
    }

    /**
     * Test of listSightingSuperpersonBySuperPerson method, of class SightingSuperpersonServiceInterface.
     */
    @Test
    public void testListSightingSuperpersonBySuperPerson_int() {
    }

    /**
     * Test of listSightingSuperpersonBySuperPerson method, of class SightingSuperpersonServiceInterface.
     */
    @Test
    public void testListSightingSuperpersonBySuperPerson_Superperson() {
    }

    /**
     * Test of listSightingSuperpersonBySighting method, of class SightingSuperpersonServiceInterface.
     */
    @Test
    public void testListSightingSuperpersonBySighting_int() {
    }

    /**
     * Test of listSightingSuperpersonBySighting method, of class SightingSuperpersonServiceInterface.
     */
    @Test
    public void testListSightingSuperpersonBySighting_Sighting() {
    }

    /**
     * Test of listAllSightingSuperperson method, of class SightingSuperpersonServiceInterface.
     */
    @Test
    public void testListAllSightingSuperperson() {
    }

    /**
     * Test of updateSightingSuperPerson method, of class SightingSuperpersonServiceInterface.
     */
    @Test
    public void testUpdateSightingSuperPerson() {
    }

    /**
     * Test of removeSightingSuperPerson method, of class SightingSuperpersonServiceInterface.
     */
    @Test
    public void testRemoveSightingSuperPerson() {
    }

    /**
     * Test of removeSuperPersonsFromSighting method, of class SightingSuperpersonServiceInterface.
     */
    @Test
    public void testRemoveSuperPersonsFromSighting() {
    }

    /**
     * Test of rmeoveSightingsFromSuperPerson method, of class SightingSuperpersonServiceInterface.
     */
    @Test
    public void testRmeoveSightingsFromSuperPerson() {
    }

 
    
}
