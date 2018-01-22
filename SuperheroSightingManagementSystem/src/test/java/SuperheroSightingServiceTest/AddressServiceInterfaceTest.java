/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingServiceTest;

import SuperheroSighting.Dto.Address;
import SuperheroSighting.Service.AddressServiceInterface;
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
import org.springframework.test.annotation.Rollback;

/**
 *
 * @author EJB Laptop
 */
public class AddressServiceInterfaceTest {
    
    private AddressServiceInterface service;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();
    
    public AddressServiceInterfaceTest() {
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
        
        service = ctx.getBean("addressService", AddressServiceInterface.class);
        
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
        service.createAddress(address1);
        
        Address address2 = new Address();
        address2.setStreetAddress("1080 West Mapledale Avenue");
        address2.setCityName("Minneapolis");
        address2.setStateName("MN");
        address2.setZipCode("12345");
        address2.setCountryName("America");
        address2.setPlanetName("Earth");
        service.createAddress(address2);
        
        Address address3 = new Address();
        address3.setStreetAddress("2370 Dongmun 3-Gil");
        address3.setCityName("Sacheon");
        address3.setStateName("GY");
        address3.setZipCode("276724");
        address3.setCountryName("Republic of Korea");
        address3.setPlanetName("Earth");
        service.createAddress(address3);
        
        Address fromDb1 = service.readAddress(address1.getAddressId());
        Address fromDb2 = service.readAddress(address2.getAddressId());
        Address fromDb3 = service.readAddress(address3.getAddressId());
        
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
        service.createAddress(address1);
        
        Address address2 = new Address();
        address2.setStreetAddress("1080 West Mapledale Avenue");
        address2.setCityName("Minneapolis");
        address2.setStateName("MN");
        address2.setZipCode("12345");
        address2.setCountryName("America");
        address2.setPlanetName("Earth");
        service.createAddress(address2);
        
        Address address3 = new Address();
        address3.setStreetAddress("2370 Dongmun 3-Gil");
        address3.setCityName("Sacheon");
        address3.setStateName("GY");
        address3.setZipCode("276724");
        address3.setCountryName("Republic of Korea");
        address3.setPlanetName("Earth");
        service.createAddress(address3);
        
        List<Address> addresses = service.listAddress(10,0);
        
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
        
        Address address1 = new Address();
        address1.setStreetAddress("2221 Main Street");
        address1.setCityName("Akron");
        address1.setStateName("OH");
        address1.setZipCode("23456");
        address1.setCountryName("Mjurricuh");
        address1.setPlanetName("X");
        service.createAddress(address1);
        
        Address address2 = new Address();
        address2.setStreetAddress("1080 West Mapledale Avenue");
        address2.setCityName("Minneapolis");
        address2.setStateName("MN");
        address2.setZipCode("12345");
        address2.setCountryName("America");
        address2.setPlanetName("Earth");
        service.createAddress(address2);
        
        Address address3 = new Address();
        address3.setStreetAddress("2370 Dongmun 3-Gil");
        address3.setCityName("Sacheon");
        address3.setStateName("GY");
        address3.setZipCode("276724");
        address3.setCountryName("Republic of Korea");
        address3.setPlanetName("Earth");
        service.createAddress(address3);
        
        address1.setCityName("Akron");
        service.updateAddress(address1);
        address2.setCityName("Akron");
        service.updateAddress(address2);
        address3.setCityName("Akron");
        service.updateAddress(address3);
        
        Address fromDb1 = service.readAddress(address1.getAddressId());
        Address fromDb2 = service.readAddress(address2.getAddressId());
        Address fromDb3 = service.readAddress(address3.getAddressId());
        
        assertEquals(fromDb1, address1);
        assertEquals(fromDb2, address2);
        assertEquals(fromDb3, address3);
        
    }

    /**
     * Test of deleteAddress method, of class AddressDaoInterface.
     */
    @Test
    @Rollback(true)
    public void testDeleteAddress() throws Exception {
        
        Address address1 = new Address();
        address1.setStreetAddress("2221 Main Street");
        address1.setCityName("Akron");
        address1.setStateName("OH");
        address1.setZipCode("23456");
        address1.setCountryName("Mjurricuh");
        address1.setPlanetName("X");
        service.createAddress(address1);
        
        service.deleteAddress(address1);
        assertNull(service.readAddress(address1.getAddressId()));
        
    }
}
