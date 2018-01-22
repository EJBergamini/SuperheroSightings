/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dto.Address;
import SuperheroSightingApplicationContextHelper.ApplicationContextHelper;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;

/**
 *
 * @author EJB Laptop
 */
public class AddressDaoInterfaceTest {
    
    private AddressDaoInterface dao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public AddressDaoInterfaceTest() {
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

        dao = ctx.getBean("addressDao", AddressDaoInterface.class);

    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of createAddress method, of class AddressDaoInterface.
     */
    @Test
    @Rollback(true)
    public void testCreateAndReadAddress() {
        
        Address address1 = new Address();
        address1.setStreetAddress("2221 Main Street");
        address1.setCityName("Akron");
        address1.setStateName("OH");
        address1.setZipCode("23456");
        address1.setCountryName("Mjurricuh");
        address1.setPlanetName("X");
        dao.createAddress(address1);
        
        Address address2 = new Address();
        address2.setStreetAddress("1080 West Mapledale Avenue");
        address2.setCityName("Minneapolis");
        address2.setStateName("MN");
        address2.setZipCode("12345");
        address2.setCountryName("America");
        address2.setPlanetName("Earth");
        dao.createAddress(address2);
        
        Address address3 = new Address();
        address3.setStreetAddress("2370 Dongmun 3-Gil");
        address3.setCityName("Sacheon");
        address3.setStateName("GY");
        address3.setZipCode("276724");
        address3.setCountryName("Republic of Korea");
        address3.setPlanetName("Earth");
        dao.createAddress(address3);
        
        Address fromDb1 = dao.readAddress(address1.getAddressId());
        Address fromDb2 = dao.readAddress(address2.getAddressId());
        Address fromDb3 = dao.readAddress(address3.getAddressId());
        
        assertEquals(fromDb1.getStreetAddress(),"2221 Main Street");
        assertEquals(fromDb2.getStreetAddress(),"1080 West Mapledale Avenue");
        assertEquals(fromDb3.getStreetAddress(),"2370 Dongmun 3-Gil");
    }

    /**
     * Test of listAddress method, of class AddressDaoInterface.
     */
    @Test
    @Rollback(true)
    public void testListAddress() {
        
        Address address1 = new Address();
        address1.setStreetAddress("2221 Main Street");
        address1.setCityName("Akron");
        address1.setStateName("OH");
        address1.setZipCode("23456");
        address1.setCountryName("Mjurricuh");
        address1.setPlanetName("X");
        dao.createAddress(address1);
        
        Address address2 = new Address();
        address2.setStreetAddress("1080 West Mapledale Avenue");
        address2.setCityName("Minneapolis");
        address2.setStateName("MN");
        address2.setZipCode("12345");
        address2.setCountryName("America");
        address2.setPlanetName("Earth");
        dao.createAddress(address2);
        
        Address address3 = new Address();
        address3.setStreetAddress("2370 Dongmun 3-Gil");
        address3.setCityName("Sacheon");
        address3.setStateName("GY");
        address3.setZipCode("276724");
        address3.setCountryName("Republic of Korea");
        address3.setPlanetName("Earth");
        dao.createAddress(address3);
        
        List<Address> addresses = dao.listAddress(10,0);
        
        Address fromList1 = addresses.get(5);
        Address fromList2 = addresses.get(6);
        Address fromList3 = addresses.get(7);
        
        assertEquals(fromList1, address1);
        assertEquals(fromList2, address2);
        assertEquals(fromList3, address3);
        
    }

    /**
     * Test of updateAddress method, of class AddressDaoInterface.
     */
    @Test
    @Rollback(true)
    public void testUpdateAddress() {
        
        Address address1 = dao.readAddress(4);
        address1.setCityName("Akron");
        dao.updateAddress(address1);
        
        Address address2 = dao.readAddress(1);
        address2.setCityName("Akron");
        dao.updateAddress(address2);
        
        Address address3 = dao.readAddress(3);
        address3.setCityName("Akron");
        dao.updateAddress(address3);
        
        Address fromDb1 = dao.readAddress(address1.getAddressId());
        Address fromDb2 = dao.readAddress(address2.getAddressId());
        Address fromDb3 = dao.readAddress(address3.getAddressId());
        
        assertEquals(fromDb1.getCityName(), address1.getCityName());
        assertEquals(fromDb2.getCityName(), address2.getCityName());
        assertEquals(fromDb3.getCityName(), address3.getCityName());
    }

    /**
     * Test of deleteAddress method, of class AddressDaoInterface.
     */
    @Test
    @Rollback(true)
    public void testDeleteAddress() {
        
        Address address1 = new Address();
        address1.setStreetAddress("2221 Main Street");
        address1.setCityName("Akron");
        address1.setStateName("OH");
        address1.setZipCode("23456");
        address1.setCountryName("Mjurricuh");
        address1.setPlanetName("X");
        dao.createAddress(address1);
        
        dao.deleteAddress(address1.getAddressId());
        assertNull(dao.readAddress(address1.getAddressId())); 
    }
  
}
