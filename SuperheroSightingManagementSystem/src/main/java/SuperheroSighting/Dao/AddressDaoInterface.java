/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface AddressDaoInterface {
    
    public Address createAddress(Address address);
    
    public Address readAddress(Integer addressId);
    
    public List<Address> listAddress(int limit, int offset);
    
    public void updateAddress(Address address);
    
    public void deleteAddress(Integer addressId);
    
    public List<Address> listAddressByContact(Contact contact, int limit, int offset);
    
}
