/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dao.AddressDaoInterface;
import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Organization;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class AddressService implements AddressServiceInterface {

    AddressDaoInterface addressDao;
    ContactServiceInterface contactService;
    LocationServiceInterface locationService;
    OrganizationServiceInterface organizationService;

    public AddressService(AddressDaoInterface addressDao) {
        this.addressDao = addressDao;
    }
    
    public void setContactService(ContactServiceInterface contactService) {
        this.contactService = contactService;
    }
    
    public void setLocationService(LocationServiceInterface locationService) {
        this.locationService = locationService;
    }
    
    public void setOrganizationService(OrganizationServiceInterface organizationService) {
        this.organizationService = organizationService;
    }
    
    @Override
    public Address createAddress(Address address) {
        return addressDao.createAddress(address);
    }

    @Override
    public Address readAddress(int addressId) {
        return addressDao.readAddress(addressId);
    }

    @Override
    public List<Address> listAddress(int limit, int offset) {
        return addressDao.listAddress(limit, offset);
    }

    @Override
    public void updateAddress(Address address) {
        addressDao.updateAddress(address);
    }

    @Override
    public List<Address> listAddressByContact(Contact contact, int limit, int offset) {
        return addressDao.listAddressByContact(contact, limit, offset);
    }
    
    @Override
    public void deleteAddress(Address address) throws SuperheroSightingServiceException {
        
        List<Contact> contactList = contactService.listContactByAddress(address, Integer.MAX_VALUE, 0);
        List<Location> locationList = locationService.listLocationByAddress(address, Integer.MAX_VALUE, 0);
        List<Organization> organizationList = organizationService.listOrganizationByAddress(address, Integer.MAX_VALUE, 0);
        
        if(contactList.size() > 0) {
            throw new SuperheroSightingServiceException("Warning: this address is associated with a contact in the system, the contact must be deleted first.");
        }   else if(locationList.size() > 0) {
            throw new SuperheroSightingServiceException("Warning: this address is associated with a location in the system, the location must be deleted first.");
        }   else if(organizationList.size() > 0) {
            throw new SuperheroSightingServiceException("Warning: this address is associated with an organization in the system, the organization must be deleted first.");
        }   else {
            addressDao.deleteAddress(address.getAddressId());
        }
    }
    
}
