/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dao.SightingSuperpersonDaoInterface;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.SightingSuperperson;
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
public class SightingSuperpersonDaoInterfaceTest {
    
    private SightingSuperpersonDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public SightingSuperpersonDaoInterfaceTest() {
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

        dao = ctx.getBean("sightingSuperpersonDao", SightingSuperpersonDaoInterface.class);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createSightingSuperperson method, of class SightingSuperpersonDaoInterface.
     */
    @Test
    public void testCreateSightingSuperperson() {
    }

    /**
     * Test of readSightingSuperpersonById method, of class SightingSuperpersonDaoInterface.
     */
    @Test
    public void testReadSightingSuperpersonById() {
    }

    /**
     * Test of listSightingSuperperson method, of class SightingSuperpersonDaoInterface.
     */
    @Test
    public void testListSightingSuperperson() {
    }

    /**
     * Test of updateSightingSuperperson method, of class SightingSuperpersonDaoInterface.
     */
    @Test
    public void testUpdateSightingSuperperson() {
    }

    /**
     * Test of deleteSightingSuperperson method, of class SightingSuperpersonDaoInterface.
     */
    @Test
    public void testDeleteSightingSuperperson() {
    }

    /**
     * Test of listSightingSuperpersonBySuperperson method, of class SightingSuperpersonDaoInterface.
     */
    @Test
    public void testListSightingSuperpersonBySuperperson() {
    }

    /**
     * Test of listSightingSuperpersonBySighting method, of class SightingSuperpersonDaoInterface.
     */
    @Test
    public void testListSightingSuperpersonBySighting() {
    }

    /**
     * Test of deleteSightingSuperpersonBySuperperson method, of class SightingSuperpersonDaoInterface.
     */
    @Test
    public void testDeleteSightingSuperpersonBySuperperson() {
    }

    /**
     * Test of deleteSightingSuperpersonBySighting method, of class SightingSuperpersonDaoInterface.
     */
    @Test
    public void testDeleteSightingSuperpersonBySighting() {
    }

   
}
