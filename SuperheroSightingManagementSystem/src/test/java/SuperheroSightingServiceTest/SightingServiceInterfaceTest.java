/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.User;
import SuperheroSighting.Service.AddressServiceInterface;
import SuperheroSighting.Service.SightingServiceInterface;
import SuperheroSightingApplicationContextHelper.ApplicationContextHelper;
import SuperheroSightingDaoTest.TestingDataInjector;
import java.time.LocalDate;
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
public class SightingServiceInterfaceTest {
    
    private SightingServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public SightingServiceInterfaceTest() {
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
        
        service = ctx.getBean("sightingService", SightingServiceInterface.class);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createSighting method, of class SightingServiceInterface.
     */
    @Test
    public void testCreateSighting() {
    }

    /**
     * Test of readSighting method, of class SightingServiceInterface.
     */
    @Test
    public void testReadSighting() {
    }

    /**
     * Test of listSightingBySuperperson method, of class SightingServiceInterface.
     */
    @Test
    public void testListSightingBySuperperson_int() {
    }

    /**
     * Test of listSightingBySuperperson method, of class SightingServiceInterface.
     */
    @Test
    public void testListSightingBySuperperson_Superperson() {
    }

    /**
     * Test of listSightingByLocation method, of class SightingServiceInterface.
     */
    @Test
    public void testListSightingByLocation_int() {
    }

    /**
     * Test of listSightingByLocation method, of class SightingServiceInterface.
     */
    @Test
    public void testListSightingByLocation_Location() {
    }

    /**
     * Test of listSightingByUser method, of class SightingServiceInterface.
     */
    @Test
    public void testListSightingByUser_int() {
    }

    /**
     * Test of listSightingByUser method, of class SightingServiceInterface.
     */
    @Test
    public void testListSightingByUser_User() {
    }

    /**
     * Test of listSightingByDate method, of class SightingServiceInterface.
     */
    @Test
    public void testListSightingByDate() {
    }

    /**
     * Test of listAllSightings method, of class SightingServiceInterface.
     */
    @Test
    public void testListAllSightings() {
    }

    /**
     * Test of updateSighting method, of class SightingServiceInterface.
     */
    @Test
    public void testUpdateSighting() {
    }

    /**
     * Test of removeSighting method, of class SightingServiceInterface.
     */
    @Test
    public void testRemoveSighting() {
    }


    
}
