/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Service.AddressServiceInterface;
import SuperheroSighting.Service.LocationServiceInterface;
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
public class LocationServiceInterfaceTest {
    
    private LocationServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public LocationServiceInterfaceTest() {
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
        
        service = ctx.getBean("locationService", LocationServiceInterface.class);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addLocation method, of class LocationServiceInterface.
     */
    @Test
    public void testAddLocation() {
    }

    /**
     * Test of readLocation method, of class LocationServiceInterface.
     */
    @Test
    public void testReadLocation() {
    }

    /**
     * Test of listLocationBySuperperson method, of class LocationServiceInterface.
     */
    @Test
    public void testListLocationBySuperperson() {
    }

    /**
     * Test of listLocationBySuperPerson method, of class LocationServiceInterface.
     */
    @Test
    public void testListLocationBySuperPerson() {
    }

    /**
     * Test of listLocation method, of class LocationServiceInterface.
     */
    @Test
    public void testListLocation() {
    }

    /**
     * Test of updateLocation method, of class LocationServiceInterface.
     */
    @Test
    public void testUpdateLocation() {
    }

    /**
     * Test of deleteLocation method, of class LocationServiceInterface.
     */
    @Test
    public void testDeleteLocation() {
    }

    
}
