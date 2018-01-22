/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dao.OrganizationDaoInterface;
import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.MoralityType;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
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
public class OrganizationDaoInterfaceTest {
    private OrganizationDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public OrganizationDaoInterfaceTest() {
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

        dao = ctx.getBean("organizationDao", OrganizationDaoInterface.class);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createOrganization method, of class OrganizationDaoInterface.
     */
    @Test
    public void testCreateOrganization() {
    }

    /**
     * Test of readOrganizationById method, of class OrganizationDaoInterface.
     */
    @Test
    public void testReadOrganizationById() {
    }

    /**
     * Test of listOrganization method, of class OrganizationDaoInterface.
     */
    @Test
    public void testListOrganization() {
    }

    /**
     * Test of updateOrganization method, of class OrganizationDaoInterface.
     */
    @Test
    public void testUpdateOrganization() {
    }

    /**
     * Test of deleteOrganization method, of class OrganizationDaoInterface.
     */
    @Test
    public void testDeleteOrganization() {
    }

    /**
     * Test of readOrganizationByMoralityType method, of class OrganizationDaoInterface.
     */
    @Test
    public void testReadOrganizationByMoralityType() {
    }

    /**
     * Test of readOrganizationByPerson method, of class OrganizationDaoInterface.
     */
    @Test
    public void testReadOrganizationByPerson() {
    }

    /**
     * Test of readOrganizationBySuperperson method, of class OrganizationDaoInterface.
     */
    @Test
    public void testReadOrganizationBySuperperson() {
    }

    /**
     * Test of readOrganizationByContact method, of class OrganizationDaoInterface.
     */
    @Test
    public void testReadOrganizationByContact() {
    }

    
    
}
