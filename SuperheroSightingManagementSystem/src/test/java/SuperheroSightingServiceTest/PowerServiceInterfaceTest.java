/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Service.AddressServiceInterface;
import SuperheroSighting.Service.PowerServiceInterface;
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
public class PowerServiceInterfaceTest {
    
    private PowerServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public PowerServiceInterfaceTest() {
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
        
        service = ctx.getBean("powerService", PowerServiceInterface.class);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createPower method, of class PowerServiceInterface.
     */
    @Test
    public void testCreatePower() {
    }

    /**
     * Test of readPower method, of class PowerServiceInterface.
     */
    @Test
    public void testReadPower() {
    }

    /**
     * Test of listPowers method, of class PowerServiceInterface.
     */
    @Test
    public void testListPowers() {
    }

    /**
     * Test of listPowerBySuperPerson method, of class PowerServiceInterface.
     */
    @Test
    public void testListPowerBySuperPerson() {
    }

    /**
     * Test of updatePower method, of class PowerServiceInterface.
     */
    @Test
    public void testUpdatePower() {
    }

    /**
     * Test of deletePower method, of class PowerServiceInterface.
     */
    @Test
    public void testDeletePower() {
    }

   
    
}
