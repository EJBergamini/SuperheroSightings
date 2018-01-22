/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.SuperpersonPower;
import SuperheroSighting.Service.AddressServiceInterface;
import SuperheroSighting.Service.SuperpersonPowerServiceInterface;
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
public class SuperpersonPowerServiceInterfaceTest {
    
    private SuperpersonPowerServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public SuperpersonPowerServiceInterfaceTest() {
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
        
        service = ctx.getBean("superpersonPowerService", SuperpersonPowerServiceInterface.class);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createSuperPersonPower method, of class SuperpersonPowerServiceInterface.
     */
    @Test
    public void testCreateSuperPersonPower() {
    }

    /**
     * Test of listSuperpersonPowerById method, of class SuperpersonPowerServiceInterface.
     */
    @Test
    public void testListSuperpersonPowerById() {
    }

    /**
     * Test of listSuperpersonPowerBySuperperson method, of class SuperpersonPowerServiceInterface.
     */
    @Test
    public void testListSuperpersonPowerBySuperperson_int() {
    }

    /**
     * Test of listSuperpersonPowerBySuperperson method, of class SuperpersonPowerServiceInterface.
     */
    @Test
    public void testListSuperpersonPowerBySuperperson_Superperson() {
    }

    /**
     * Test of listSuperpersonPowerByPower method, of class SuperpersonPowerServiceInterface.
     */
    @Test
    public void testListSuperpersonPowerByPower_int() {
    }

    /**
     * Test of listSuperpersonPowerByPower method, of class SuperpersonPowerServiceInterface.
     */
    @Test
    public void testListSuperpersonPowerByPower_Power() {
    }

    /**
     * Test of listSuperpersonPowers method, of class SuperpersonPowerServiceInterface.
     */
    @Test
    public void testListSuperpersonPowers() {
    }

    /**
     * Test of updateSuperpersonPower method, of class SuperpersonPowerServiceInterface.
     */
    @Test
    public void testUpdateSuperpersonPower() {
    }

    /**
     * Test of removeSuperpersonPower method, of class SuperpersonPowerServiceInterface.
     */
    @Test
    public void testRemoveSuperpersonPower() {
    }

    /**
     * Test of removePowerFromSuperperson method, of class SuperpersonPowerServiceInterface.
     */
    @Test
    public void testRemovePowerFromSuperperson() {
    }

    /**
     * Test of removeSuperpersonFromPower method, of class SuperpersonPowerServiceInterface.
     */
    @Test
    public void testRemoveSuperpersonFromPower() {
    }


    
}
