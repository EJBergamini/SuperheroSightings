/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dao.SightingDaoInterface;
import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.User;
import SuperheroSightingApplicationContextHelper.ApplicationContextHelper;
import java.util.Date;
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
public class SightingDaoInterfaceTest {
    
    private SightingDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public SightingDaoInterfaceTest() {
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

        dao = ctx.getBean("sightingDao", SightingDaoInterface.class);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createSighting method, of class SightingDaoInterface.
     */
    @Test
    public void testCreateSighting() {
    }

    /**
     * Test of readSightingById method, of class SightingDaoInterface.
     */
    @Test
    public void testReadSightingById() {
    }

    /**
     * Test of listSighting method, of class SightingDaoInterface.
     */
    @Test
    public void testListSighting() {
    }

    /**
     * Test of updateSighting method, of class SightingDaoInterface.
     */
    @Test
    public void testUpdateSighting() {
    }

    /**
     * Test of deleteSighting method, of class SightingDaoInterface.
     */
    @Test
    public void testDeleteSighting() {
    }

    /**
     * Test of listSightingByUser method, of class SightingDaoInterface.
     */
    @Test
    public void testListSightingByUser() {
    }

    /**
     * Test of listSightingByLocation method, of class SightingDaoInterface.
     */
    @Test
    public void testListSightingByLocation() {
    }

    /**
     * Test of listSightingByDate method, of class SightingDaoInterface.
     */
    @Test
    public void testListSightingByDate() {
    }

    /**
     * Test of listSightingBySuperperson method, of class SightingDaoInterface.
     */
    @Test
    public void testListSightingBySuperperson() {
    }

    
}
