/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dao.LocationDaoInterface;
import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Superperson;
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
public class LocationDaoInterfaceTest {
    
    private LocationDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public LocationDaoInterfaceTest() {
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

        dao = ctx.getBean("locationDao", LocationDaoInterface.class);

    }
    
    
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createLocation method, of class LocationDaoInterface.
     */
    @Test
    public void testCreateLocation() {
    }

    /**
     * Test of readLocationById method, of class LocationDaoInterface.
     */
    @Test
    public void testReadLocationById() {
    }

    /**
     * Test of listLocation method, of class LocationDaoInterface.
     */
    @Test
    public void testListLocation() {
    }

    /**
     * Test of updateLocation method, of class LocationDaoInterface.
     */
    @Test
    public void testUpdateLocation() {
    }

    /**
     * Test of deleteLocation method, of class LocationDaoInterface.
     */
    @Test
    public void testDeleteLocation() {
    }

    /**
     * Test of readLocationsBySuperperson method, of class LocationDaoInterface.
     */
    @Test
    public void testReadLocationsBySuperperson() {
    }

    
    
}
