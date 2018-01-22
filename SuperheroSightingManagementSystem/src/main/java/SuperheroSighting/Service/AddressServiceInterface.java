/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface AddressServiceInterface {
    
    public Address createAddress(Address address);
    
    public Address readAddress(int addressId);

    public List<Address> listAddress(int limit, int offset);

    public void updateAddress(Address address);

    public void deleteAddress(Address address) throws SuperheroSightingServiceException;
    
    public List<Address> listAddressByContact(Contact contact, int limit, int offset);
    
}
