/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dao.SuperpersonDaoInterface;
import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.MoralityType;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Sighting;
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
public class SuperpersonDaoInterfaceTest {
    
    private SuperpersonDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public SuperpersonDaoInterfaceTest() {
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

        dao = ctx.getBean("superpersonDao", SuperpersonDaoInterface.class);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createSuperperson method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testCreateSuperperson() {
    }

    /**
     * Test of readSuperpersonById method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testReadSuperpersonById() {
    }

    /**
     * Test of listSuperperson method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testListSuperperson() {
    }

    /**
     * Test of updateSuperperson method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testUpdateSuperperson() {
    }

    /**
     * Test of deleteSuperperson method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testDeleteSuperperson() {
    }

    /**
     * Test of listSuperpersonByPerson method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testListSuperpersonByPerson() {
    }

    /**
     * Test of listSuperpersonByMoralityType method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testListSuperpersonByMoralityType() {
    }

    /**
     * Test of listSuperpersonByAlias method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testListSuperpersonByAlias() {
    }

    /**
     * Test of listSuperpersonByLocation method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testListSuperpersonByLocation() {
    }

    /**
     * Test of listSuperpersonBySighting method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testListSuperpersonBySighting() {
    }

    /**
     * Test of listSuperpersonByPower method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testListSuperpersonByPower() {
    }

    /**
     * Test of listSuperpersonByOrganization method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testListSuperpersonByOrganization() {
    }

    /**
     * Test of deleteSuperpersonByPower method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testDeleteSuperpersonByPower() {
    }

    /**
     * Test of deleteSuperpersonBySighting method, of class SuperpersonDaoInterface.
     */
    @Test
    public void testDeleteSuperpersonBySighting() {
    }

    
}
