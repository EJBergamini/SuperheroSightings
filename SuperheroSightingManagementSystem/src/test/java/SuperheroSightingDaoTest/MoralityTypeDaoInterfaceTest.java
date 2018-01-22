/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dao.MoralityTypeDaoInterface;
import SuperheroSighting.Dto.MoralityType;
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
public class MoralityTypeDaoInterfaceTest {
    private MoralityTypeDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public MoralityTypeDaoInterfaceTest() {
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

        dao = ctx.getBean("moralityTypeDao", MoralityTypeDaoInterface.class);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createMoralityType method, of class MoralityTypeDaoInterface.
     */
    @Test
    public void testCreateMoralityType() {
    }

    /**
     * Test of readMoralityTypeById method, of class MoralityTypeDaoInterface.
     */
    @Test
    public void testReadMoralityTypeById() {
    }

    /**
     * Test of listMoralityType method, of class MoralityTypeDaoInterface.
     */
    @Test
    public void testListMoralityType() {
    }

    /**
     * Test of updateMoralityType method, of class MoralityTypeDaoInterface.
     */
    @Test
    public void testUpdateMoralityType() {
    }

    /**
     * Test of deleteMoralityType method, of class MoralityTypeDaoInterface.
     */
    @Test
    public void testDeleteMoralityType() {
    }

    
}
