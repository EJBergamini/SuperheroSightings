/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.MoralityType;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.Superperson;
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
public class OrganizationDaoImplementation implements OrganizationDaoInterface {
    
    private static final String SQL_INSERT_ORGANIZATION = "insert into Organizations (organizationName, organizationDescription, addressId, moralityTypeId, contactId) values (?,?,?,?,?)";
    
    private static final String SQL_SELECT_ORGANIZATION = "select * from Organizations where organizationId = ?";
    
    private static final String SQL_LIST_ORGANIZATION = "select * frorm Organizations limit = ? offset = ?";
    
    private static final String SQL_UPDATE_ORGANIZATION = "update Organizations set organizationName = ?, organizationDescription = ?, addressId = ?, moralityTypeId = ?, contactId = ?";
    
    private static final String SQL_DELETE_ORGANIZATION = "delete from Organizations where organizationId = ?";
    
    private static final String SQL_LIST_ORGANIZATION_BY_MORALITYTYPE = "select * from Organizations where moralityTypeId = ? limit ? offset ?";
    
    private static final String SQL_LIST_ORGANIZATION_BY_PERSON = "SELECT * FROM Organizations where personId = ? limit ? offset ?";
    
    private static final String SQL_LIST_ORGANIZATION_BY_SUPERPERSON = "select * from Organizations where superpersonId = ? limit ? offset ?";
    
    private static final String SQL_LIST_ORGANIZATION_BY_CONTACT = "select * from Organizations where contactId = ? limit ? offset ?";
    
    private static final String SQL_LIST_ORGANIZATION_BY_ADDRESS = "select * from Organizations where addressId = ? limit ? offset ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Organization createOrganization(Organization organization) {
        jdbcTemplate.update(SQL_INSERT_ORGANIZATION,
            organization.getOrganizationName(),
            organization.getOrganizationDescription(),
            organization.getAddress().getAddressId(),
            organization.getMoralityType().getMoralityTypeId(),
            organization.getContact().getContactId());
        int organizationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        organization.setOrganizationId(organizationId);
        return organization;
    }
    
    @Override
    public Organization readOrganization(Integer organizationId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION, new OrganizationDaoImplementation.OrganizationMapper(), organizationId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<Organization> listOrganization(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_ORGANIZATION, new OrganizationDaoImplementation.OrganizationMapper(), limit, offset);
    }

    @Override
    public void updateOrganization(Organization organization) {
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATION,
            organization.getOrganizationName(),
            organization.getOrganizationDescription(),
            organization.getAddress().getAddressId(),
            organization.getMoralityType().getMoralityTypeId(),
            organization.getContact().getContactId(),
            organization.getOrganizationId());
    }
    
    @Override
    public void deleteOrganization(Integer organizationId) {
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION, organizationId);
    }

    //relational methods:
    
    @Override
    public List<Organization> listOrganizationByMoralityType(MoralityType moralityType, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_ORGANIZATION_BY_MORALITYTYPE, new OrganizationDaoImplementation.OrganizationMapper(), moralityType.getMoralityTypeId(), limit, offset);
    }

    @Override
    public List<Organization> listOrganizationByPerson(Person person, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_ORGANIZATION_BY_PERSON, new OrganizationDaoImplementation.OrganizationMapper(), person.getPersonId(), limit, offset);
    }

    @Override
    public List<Organization> listOrganizationBySuperperson(Superperson superperson, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_ORGANIZATION_BY_SUPERPERSON, new OrganizationDaoImplementation.OrganizationMapper(), superperson.getSuperpersonId(), limit, offset);
    }

    @Override
    public List<Organization> listOrganizationByContact(Contact contact, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_ORGANIZATION_BY_CONTACT, new OrganizationDaoImplementation.OrganizationMapper(), contact.getContactId(),limit, offset);
    }
    
    @Override
    public List<Organization> listOrganizationByAddress(Address address, int offset, int limit) {
        return jdbcTemplate.query(SQL_LIST_ORGANIZATION_BY_ADDRESS, new OrganizationDaoImplementation.OrganizationMapper(), address.getAddressId(),limit, offset);
    }

    private static final class OrganizationMapper implements RowMapper<Organization> {

        public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
            Organization organization = new Organization();
            organization.setOrganizationId(rs.getInt("organizationId"));
            organization.setOrganizationName(rs.getString("organizationName"));
            organization.setOrganizationDescription(rs.getString("organizationDescription"));
            Address address = new Address();
            address.setAddressId(rs.getInt("addressId"));
            organization.setAddress(address);
            MoralityType moralityType = new MoralityType();
            moralityType.setMoralityTypeId(rs.getInt("moralityTypeId"));
            organization.setMoralityType(moralityType);
            Contact contact = new Contact();
            contact.setContactId(rs.getInt("contactId"));
            organization.setContact(contact);
            return organization;
        }
    } 
    
}
