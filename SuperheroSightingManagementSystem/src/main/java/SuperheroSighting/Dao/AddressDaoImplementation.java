/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author EJB Laptop
 */
public class AddressDaoImplementation implements AddressDaoInterface {
    
    private static final String SQL_INSERT_ADDRESS = "insert into Addresses (streetAddress, cityName, stateName, zipCode, countryName, planetName) values (?,?,?,?,?,?)";
    
    private static final String SQL_SELECT_ADDRESS = "select * from Addresses where addressId = ?";
    
    private static final String SQL_LIST_ADDRESS = "select * from Addresses limit ? offset ?";
    
    private static final String SQL_UPDATE_ADDRESS = "update Addresses set streetAddress = ?, cityName = ?, stateName = ?, zipCode = ?, countryName = ?, planetName = ? where addressId = ?";
    
    private static final String SQL_DELETE_ADDRESS = "delete from Addresses where addressId = ?";
    
    private static final String SQL_LIST_ADDRESS_BY_CONTACT = "select * from Addresses where contactId = ? limit ? offset ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Address createAddress(Address address) {
        jdbcTemplate.update(SQL_INSERT_ADDRESS, 
            address.getStreetAddress(),
            address.getCityName(),
            address.getStateName(),
            address.getZipCode(),
            address.getCountryName(),
            address.getPlanetName());
        int addressId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        address.setAddressId(addressId);
        return address;
    }
    
    @Override
    public Address readAddress(Integer addressId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ADDRESS,
                    new AddressMapper(), addressId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<Address> listAddress(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_ADDRESS, new AddressMapper(), limit, offset);
    }

    @Override
    public void updateAddress(Address address) {
        jdbcTemplate.update(SQL_UPDATE_ADDRESS,
                address.getStreetAddress(),
                address.getCityName(),
                address.getStateName(),
                address.getZipCode(),
                address.getCountryName(),
                address.getPlanetName(),
                address.getAddressId());
    }
    
    @Override
    public void deleteAddress(Integer addressId) {
        jdbcTemplate.update(SQL_DELETE_ADDRESS, addressId);
    }
    
    //relational methods:
    
    @Override
    public List<Address> listAddressByContact(Contact contact, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_ADDRESS_BY_CONTACT, new AddressMapper(), contact.getContactId(), limit, offset);
    }
    
    private static final class AddressMapper implements RowMapper<Address> {

        public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
            Address address = new Address();
            address.setAddressId(rs.getInt("addressId"));
            address.setStreetAddress(rs.getString("streetAddress"));
            address.setCityName(rs.getString("cityName"));
            address.setStateName(rs.getString("stateName"));
            address.setZipCode(rs.getString("zipCode"));
            address.setCountryName(rs.getString("countryName"));
            address.setPlanetName(rs.getString("planetName"));
            return address;
        }
    }
    
}
