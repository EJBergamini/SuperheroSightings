/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.User;
import SuperheroSighting.Service.AddressServiceInterface;
import SuperheroSighting.Service.UserServiceInterface;
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
public class UserServiceInterfaceTest {
    
    private UserServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public UserServiceInterfaceTest() {
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
        
        service = ctx.getBean("userService", UserServiceInterface.class);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createUser method, of class UserServiceInterface.
     */
    @Test
    public void testCreateUser() {
    }

    /**
     * Test of readUser method, of class UserServiceInterface.
     */
    @Test
    public void testReadUser() {
    }

    /**
     * Test of listUser method, of class UserServiceInterface.
     */
    @Test
    public void testListUser() {
    }

    /**
     * Test of listUserByPerson method, of class UserServiceInterface.
     */
    @Test
    public void testListUserByPerson_int() {
    }

    /**
     * Test of listUserByPerson method, of class UserServiceInterface.
     */
    @Test
    public void testListUserByPerson_Person() {
    }

    /**
     * Test of updateUser method, of class UserServiceInterface.
     */
    @Test
    public void testUpdateUser() {
    }

    /**
     * Test of removeUser method, of class UserServiceInterface.
     */
    @Test
    public void testRemoveUser() {
    }

  
    
}
