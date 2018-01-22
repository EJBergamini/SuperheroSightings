/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
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
public class ContactDaoImplementation implements ContactDaoInterface {
    
    private static final String SQL_INSERT_CONTACT = "insert into Contacts (personId, addressId, phoneNumber) values (?,?,?)";
    
    private static final String SQL_SELECT_CONTACT = "select * from Contacts where contactId = ?";
    
    private static final String SQL_LIST_CONTACT = "select * from Contacts limit ? offset ?";
    
    private static final String SQL_UPDATE_CONTACT = "update Contacts set personId = ?, addressId = ?, phoneNumber = ? where contactId = ?";
    
    private static final String SQL_DELETE_CONTACT = "delete from Contacts where contactId = ?";
    
    private static final String SQL_LIST_CONTACT_BY_ORGANIZATION = "SELECT c.* FROM Contacts c INNER JOIN Organizations o ON c.contactId = o.contactId WHERE o.organizationId = ? LIMIT ? OFFSET ?";
    
    private static final String SQL_LIST_CONTACT_BY_PERSON = "select * from Contacts where personId = ? limit ? offset ?";
    
    private static final String SQL_LIST_CONTACT_BY_ADDRESS = "select * from Contacts where addressId = ? limit ? offset ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Contact createContact(Contact contact) {
        jdbcTemplate.update(SQL_INSERT_CONTACT, 
            contact.getPerson().getPersonId(),
            contact.getAddress().getAddressId(),
            contact.getPhoneNumber());
        int contactId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        contact.setContactId(contactId);
        return contact;
    }
    
    @Override
    public Contact readContact(Integer contactId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_CONTACT,
                    new ContactDaoImplementation.ContactMapper(), contactId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<Contact> listContact(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_CONTACT, new ContactDaoImplementation.ContactMapper(), limit, offset);
    }

    @Override
    public void updateContact(Contact contact) {
        jdbcTemplate.update(SQL_UPDATE_CONTACT,
                contact.getPerson().getPersonId(),
                contact.getAddress().getAddressId(),
                contact.getPhoneNumber(),
                contact.getContactId());
    }
    
    @Override
    public void deleteContact(Integer contactId) {
        jdbcTemplate.update(SQL_DELETE_CONTACT, contactId);
    }

    //relational methods:
    
    @Override
    public List<Contact> listContactByOrganization(Organization organization, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_CONTACT_BY_ORGANIZATION, new ContactMapper(), organization.getOrganizationId(), limit, offset);
    }

    @Override
    public List<Contact> listContactByAddress(Address address, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_CONTACT_BY_ADDRESS, new ContactMapper(), address.getAddressId(), limit, offset);
    }

    @Override
    public List<Contact> listContactByPerson(Person person, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_CONTACT_BY_PERSON ,new ContactMapper(), person.getPersonId(), limit, offset);
    }
     
    private static final class ContactMapper implements RowMapper<Contact> {

        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contact contact = new Contact();
            contact.setContactId(rs.getInt("contactId"));
            Person person = new Person();
            person.setPersonId(rs.getInt("personId"));
            contact.setPerson(person);
            Address address = new Address();
            address.setAddressId(rs.getInt("addressId"));
            contact.setAddress(address);
            contact.setPhoneNumber(rs.getString("phoneNumber"));
            return contact;
        }
    }    
}
