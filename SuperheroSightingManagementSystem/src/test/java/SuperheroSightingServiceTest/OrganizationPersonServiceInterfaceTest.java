/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.OrganizationPerson;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Service.AddressServiceInterface;
import SuperheroSighting.Service.OrganizationPersonServiceInterface;
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
public class OrganizationPersonServiceInterfaceTest {
    
    private OrganizationPersonServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public OrganizationPersonServiceInterfaceTest() {
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
        
        service = ctx.getBean("organizationPersonService", OrganizationPersonServiceInterface.class);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createOrganizationPerson method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testCreateOrganizationPerson() {
    }

    /**
     * Test of readOrganizationPerson method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testReadOrganizationPerson() {
    }

    /**
     * Test of listOrganizationPersonByPerson method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testListOrganizationPersonByPerson() {
    }

    /**
     * Test of listOrganizatinoPersonByPerson method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testListOrganizatinoPersonByPerson() {
    }

    /**
     * Test of listOrganizationPersonByOrganization method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testListOrganizationPersonByOrganization_int() {
    }

    /**
     * Test of listOrganizationPersonByOrganization method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testListOrganizationPersonByOrganization_Organization() {
    }

    /**
     * Test of listOrganizationPersonBySuperPerson method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testListOrganizationPersonBySuperPerson_int() {
    }

    /**
     * Test of listOrganizationPersonBySuperPerson method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testListOrganizationPersonBySuperPerson_Superperson() {
    }

    /**
     * Test of listAllOrganizationPerson method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testListAllOrganizationPerson() {
    }

    /**
     * Test of updateOrganizationPerson method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testUpdateOrganizationPerson() {
    }

    /**
     * Test of deleteOrganizationPerson method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testDeleteOrganizationPerson() {
    }

    /**
     * Test of deleteOrganizationFromPerson method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testDeleteOrganizationFromPerson() {
    }

    /**
     * Test of deletePersonFromOrganization method, of class OrganizationPersonServiceInterface.
     */
    @Test
    public void testDeletePersonFromOrganization() {
    }


}
