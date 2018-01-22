/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.MoralityType;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Service.AddressServiceInterface;
import SuperheroSighting.Service.OrganizationServiceInterface;
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
public class OrganizationServiceInterfaceTest {
    
    private OrganizationServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public OrganizationServiceInterfaceTest() {
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
        
        service = ctx.getBean("organizationService", OrganizationServiceInterface.class);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createOrganization method, of class OrganizationServiceInterface.
     */
    @Test
    public void testCreateOrganization() {
    }

    /**
     * Test of readOrganization method, of class OrganizationServiceInterface.
     */
    @Test
    public void testReadOrganization() {
    }

    /**
     * Test of listOrganizationByMoralityType method, of class OrganizationServiceInterface.
     */
    @Test
    public void testListOrganizationByMoralityType_int() {
    }

    /**
     * Test of listOrganizationByMoralityType method, of class OrganizationServiceInterface.
     */
    @Test
    public void testListOrganizationByMoralityType_MoralityType() {
    }

    /**
     * Test of listOrganizationByPerson method, of class OrganizationServiceInterface.
     */
    @Test
    public void testListOrganizationByPerson_int() {
    }

    /**
     * Test of listOrganizationByPerson method, of class OrganizationServiceInterface.
     */
    @Test
    public void testListOrganizationByPerson_Person() {
    }

    /**
     * Test of listOrganizationBySuperperson method, of class OrganizationServiceInterface.
     */
    @Test
    public void testListOrganizationBySuperperson() {
    }

    /**
     * Test of listOrganizationBySuperPerson method, of class OrganizationServiceInterface.
     */
    @Test
    public void testListOrganizationBySuperPerson() {
    }

    /**
     * Test of listOrganizationByContact method, of class OrganizationServiceInterface.
     */
    @Test
    public void testListOrganizationByContact_int() {
    }

    /**
     * Test of listOrganizationByContact method, of class OrganizationServiceInterface.
     */
    @Test
    public void testListOrganizationByContact_Contact() {
    }

    /**
     * Test of updateOrganization method, of class OrganizationServiceInterface.
     */
    @Test
    public void testUpdateOrganization() {
    }

    /**
     * Test of removeOrganization method, of class OrganizationServiceInterface.
     */
    @Test
    public void testRemoveOrganization() {
    }

 
    
}
