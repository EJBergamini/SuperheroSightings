/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dao.SuperpersonPowerDaoInterface;
import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.SuperpersonPower;
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
public class SuperpersonPowerDaoInterfaceTest {
    
    private SuperpersonPowerDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public SuperpersonPowerDaoInterfaceTest() {
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

        dao = ctx.getBean("superpersonPowerDao", SuperpersonPowerDaoInterface.class);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createSuperpersonPower method, of class SuperpersonPowerDaoInterface.
     */
    @Test
    public void testCreateSuperpersonPower() {
    }

    /**
     * Test of readSuperpersonPowerById method, of class SuperpersonPowerDaoInterface.
     */
    @Test
    public void testReadSuperpersonPowerById() {
    }

    /**
     * Test of listSuperpersonPower method, of class SuperpersonPowerDaoInterface.
     */
    @Test
    public void testListSuperpersonPower() {
    }

    /**
     * Test of updateSuperpersonPower method, of class SuperpersonPowerDaoInterface.
     */
    @Test
    public void testUpdateSuperpersonPower() {
    }

    /**
     * Test of deleteSuperpersonPower method, of class SuperpersonPowerDaoInterface.
     */
    @Test
    public void testDeleteSuperpersonPower() {
    }

    /**
     * Test of listSuperpersonPowerByPower method, of class SuperpersonPowerDaoInterface.
     */
    @Test
    public void testListSuperpersonPowerByPower() {
    }

    /**
     * Test of listSuperpersonPowerBySuperperson method, of class SuperpersonPowerDaoInterface.
     */
    @Test
    public void testListSuperpersonPowerBySuperperson() {
    }

    /**
     * Test of deleteSuperpersonPowerByPower method, of class SuperpersonPowerDaoInterface.
     */
    @Test
    public void testDeleteSuperpersonPowerByPower() {
    }

    /**
     * Test of deleteSuperpersonPowerBySuperperson method, of class SuperpersonPowerDaoInterface.
     */
    @Test
    public void testDeleteSuperpersonPowerBySuperperson() {
    }

    
}
