/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.MoralityType;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Service.AddressServiceInterface;
import SuperheroSighting.Service.SuperpersonServiceInterface;
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
public class SuperpersonServiceInterfaceTest {
    
    private SuperpersonServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public SuperpersonServiceInterfaceTest() {
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
        
        service = ctx.getBean("superpersonService", SuperpersonServiceInterface.class);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createSuperperson method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testCreateSuperperson() {
    }

    /**
     * Test of listSuperpersonById method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperpersonById() {
    }

    /**
     * Test of listSuperpersonByMoralityType method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperpersonByMoralityType_int() {
    }

    /**
     * Test of listSuperpersonByMoralityType method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperpersonByMoralityType_MoralityType() {
    }

    /**
     * Test of listSuperpersonByAliasId method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperpersonByAliasId() {
    }

    /**
     * Test of listSuperperson method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperperson() {
    }

    /**
     * Test of listSuperpersonByLocation method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperpersonByLocation_Location() {
    }

    /**
     * Test of listSuperpersonByLocation method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperpersonByLocation_int() {
    }

    /**
     * Test of listSuperpersonsBySighting method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperpersonsBySighting_Sighting() {
    }

    /**
     * Test of listSuperpersonsBySighting method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperpersonsBySighting_int() {
    }

    /**
     * Test of listSuperpersonsByPower method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperpersonsByPower_Power() {
    }

    /**
     * Test of listSuperpersonsByPower method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperpersonsByPower_int() {
    }

    /**
     * Test of listSuperpersonsByOrganization method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperpersonsByOrganization_int() {
    }

    /**
     * Test of listSuperpersonsByOrganization method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testListSuperpersonsByOrganization_Organization() {
    }

    /**
     * Test of updateSuperperson method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testUpdateSuperperson() {
    }

    /**
     * Test of deleteSuperperson method, of class SuperpersonServiceInterface.
     */
    @Test
    public void testDeleteSuperperson() {
    }

 
}
