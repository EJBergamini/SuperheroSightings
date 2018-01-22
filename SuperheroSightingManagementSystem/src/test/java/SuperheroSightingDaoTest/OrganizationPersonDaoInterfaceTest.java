/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dao.OrganizationPersonDaoInterface;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.OrganizationPerson;
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
public class OrganizationPersonDaoInterfaceTest {
    
    private OrganizationPersonDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public OrganizationPersonDaoInterfaceTest() {
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

        dao = ctx.getBean("organizationPersonDao", OrganizationPersonDaoInterface.class);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createOrganizationPerson method, of class OrganizationPersonDaoInterface.
     */
    @Test
    public void testCreateOrganizationPerson() {
    }

    /**
     * Test of readOrganizationPersonById method, of class OrganizationPersonDaoInterface.
     */
    @Test
    public void testReadOrganizationPersonById() {
    }

    /**
     * Test of listOrganizationPerson method, of class OrganizationPersonDaoInterface.
     */
    @Test
    public void testListOrganizationPerson() {
    }

    /**
     * Test of updateOrganizationPerson method, of class OrganizationPersonDaoInterface.
     */
    @Test
    public void testUpdateOrganizationPerson() {
    }

    /**
     * Test of deleteOrganizationPerson method, of class OrganizationPersonDaoInterface.
     */
    @Test
    public void testDeleteOrganizationPerson() {
    }

    /**
     * Test of listOrganizationPersonByOrganization method, of class OrganizationPersonDaoInterface.
     */
    @Test
    public void testListOrganizationPersonByOrganization() {
    }

    /**
     * Test of listOrganizationPersonByPerson method, of class OrganizationPersonDaoInterface.
     */
    @Test
    public void testListOrganizationPersonByPerson() {
    }

    /**
     * Test of listOrganizationPersonBySuperperson method, of class OrganizationPersonDaoInterface.
     */
    @Test
    public void testListOrganizationPersonBySuperperson() {
    }

    /**
     * Test of deletePersonFromOrganization method, of class OrganizationPersonDaoInterface.
     */
    @Test
    public void testDeletePersonFromOrganization() {
    }

    
}
