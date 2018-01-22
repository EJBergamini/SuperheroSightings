/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.MoralityType;
import SuperheroSighting.Service.AddressServiceInterface;
import SuperheroSighting.Service.MoralityTypeServiceInterface;
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
public class MoralityTypeServiceInterfaceTest {
    
    private MoralityTypeServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public MoralityTypeServiceInterfaceTest() {
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
        
        service = ctx.getBean("moralityTypeService", MoralityTypeServiceInterface.class);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createMoralityType method, of class MoralityTypeServiceInterface.
     */
    @Test
    public void testCreateMoralityType() {
    }

    /**
     * Test of readMoralityType method, of class MoralityTypeServiceInterface.
     */
    @Test
    public void testReadMoralityType_int() {
    }

    /**
     * Test of readMoralityType method, of class MoralityTypeServiceInterface.
     */
    @Test
    public void testReadMoralityType_MoralityType() {
    }

    /**
     * Test of listMoralityType method, of class MoralityTypeServiceInterface.
     */
    @Test
    public void testListMoralityType() {
    }

    /**
     * Test of updateMoralityType method, of class MoralityTypeServiceInterface.
     */
    @Test
    public void testUpdateMoralityType() {
    }

    /**
     * Test of deleteMoralityType method, of class MoralityTypeServiceInterface.
     */
    @Test
    public void testDeleteMoralityType() {
    }


    
}
