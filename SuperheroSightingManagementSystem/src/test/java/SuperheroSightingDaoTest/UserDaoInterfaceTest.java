/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dao.UserDaoInterface;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.User;
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
public class UserDaoInterfaceTest {
    
    private UserDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public UserDaoInterfaceTest() {
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

        dao = ctx.getBean("userDao", UserDaoInterface.class);

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createUser method, of class UserDaoInterface.
     */
    @Test
    public void testCreateUser() {
    }

    /**
     * Test of readUserById method, of class UserDaoInterface.
     */
    @Test
    public void testReadUserById() {
    }

    /**
     * Test of listUser method, of class UserDaoInterface.
     */
    @Test
    public void testListUser() {
    }

    /**
     * Test of updateUser method, of class UserDaoInterface.
     */
    @Test
    public void testUpdateUser() {
    }

    /**
     * Test of deleteUser method, of class UserDaoInterface.
     */
    @Test
    public void testDeleteUser() {
    }

    /**
     * Test of listUserByPerson method, of class UserDaoInterface.
     */
    @Test
    public void testListUserByPerson() {
    }

   
}
