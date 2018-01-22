/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dao.PowerDaoInterface;
import SuperheroSighting.Dto.Power;
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
public class PowerDaoInterfaceTest {
    
    private PowerDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public PowerDaoInterfaceTest() {
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

        dao = ctx.getBean("powerDao", PowerDaoInterface.class);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createPower method, of class PowerDaoInterface.
     */
    @Test
    public void testCreatePower() {
    }

    /**
     * Test of readPowerById method, of class PowerDaoInterface.
     */
    @Test
    public void testReadPowerById() {
    }

    /**
     * Test of listPower method, of class PowerDaoInterface.
     */
    @Test
    public void testListPower() {
    }

    /**
     * Test of updatePower method, of class PowerDaoInterface.
     */
    @Test
    public void testUpdatePower() {
    }

    /**
     * Test of deletePower method, of class PowerDaoInterface.
     */
    @Test
    public void testDeletePower() {
    }

    /**
     * Test of listPowerBySuperperson method, of class PowerDaoInterface.
     */
    @Test
    public void testListPowerBySuperperson() {
    }

    
    
}
