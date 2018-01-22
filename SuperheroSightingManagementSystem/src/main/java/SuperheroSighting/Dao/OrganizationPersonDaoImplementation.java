/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.OrganizationPerson;
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
public class OrganizationPersonDaoImplementation implements OrganizationPersonDaoInterface {
    
    private static final String SQL_INSERT_ORGANIZATIONPERSON = "insert into OrganizationsPersons (personId, organizationId) values (?,?)";
    
    private static final String SQL_SELECT_ORGANIZATIONPERSON = "select * from OrganizationsPersons where organizationPersonId = ?";
    
    private static final String SQL_LIST_ORGANIZATIONPERSON = "select * from OrganizationsPersons limit ? offset ?";
    
    private static final String SQL_UPDATE_ORGANIZATIONPERSON = "update OrganizationsPersons set personId = ?, organizationId = ? where organizationPersonId = ?";
    
    private static final String SQL_DELETE_ORGANIZATIONPERSON = "delete from OrganizationsPersons where organizationPersonId = ?";
    
    private static final String SQL_LIST_ORGANIZATIONPERSON_BY_ORGANIZATION = "select op.* from OrganizationsPersons op inner join Organizations o on o.organizationId = op.organizationId where o.organizationId = ? limit ? offset ?";
    
    private static final String SQL_LIST_ORGANIZATIONPERSON_BY_PERSON = "select op.* from OrganizationsPersons op inner join Persons p on p.personId = op.personId where p.personId = ? limit ? offset ?";
    
    private static final String SQL_DELETE_ORGANIZATIONPERSON_BY_ORGANIZATION = "delete from OrganizationsPersons where organizationId = ?";
    
    private static final String SQL_DELETE_ORGANIZATIONPERSON_BY_PERSON = "delete from OrganizationsPersons where personId = ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public OrganizationPerson createOrganizationPerson(OrganizationPerson organizationPerson) {
        jdbcTemplate.update(SQL_INSERT_ORGANIZATIONPERSON,
            organizationPerson.getPerson().getPersonId(),
            organizationPerson.getOrganization().getOrganizationId());
        int organizationPersonId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        organizationPerson.setOrganizationPersonId(organizationPersonId);
        return organizationPerson;
    }
    
    @Override
    public OrganizationPerson readOrganizationPerson(Integer organizationPersonId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATIONPERSON, new OrganizationPersonDaoImplementation.OrganizationPersonMapper(), organizationPersonId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<OrganizationPerson> listOrganizationPerson(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_ORGANIZATIONPERSON, new OrganizationPersonDaoImplementation.OrganizationPersonMapper(), limit, offset);
    }

    @Override
    public void updateOrganizationPerson(OrganizationPerson organizationPerson) {
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATIONPERSON,
            organizationPerson.getPerson().getPersonId(),
            organizationPerson.getOrganization().getOrganizationId(),
            organizationPerson.getOrganizationPersonId());
    }
    
    @Override
    public void deleteOrganizationPerson(Integer organizationPersonId) {
        jdbcTemplate.update(SQL_DELETE_ORGANIZATIONPERSON, organizationPersonId);
    }
    
    //relational methods:

    
    @Override
    public List<OrganizationPerson> listOrganizationPersonByOrganization(Organization organization, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_ORGANIZATIONPERSON_BY_ORGANIZATION, new OrganizationPersonDaoImplementation.OrganizationPersonMapper(), organization.getOrganizationId(), limit, offset);
    }

    @Override
    public List<OrganizationPerson> listOrganizationPersonByPerson(Person person, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_ORGANIZATIONPERSON_BY_PERSON, new OrganizationPersonDaoImplementation.OrganizationPersonMapper(), person.getPersonId(), limit, offset);
    }

    @Override
    public void deleteOrganizationPersonByOrganization(Organization organization) {
        jdbcTemplate.update(SQL_DELETE_ORGANIZATIONPERSON_BY_ORGANIZATION, organization.getOrganizationId());
    }

    @Override
    public void deleteOrganizationPersonByPerson(Person person) {
        jdbcTemplate.update(SQL_DELETE_ORGANIZATIONPERSON_BY_PERSON, person.getPersonId());
    }

    

    private static final class OrganizationPersonMapper implements RowMapper<OrganizationPerson> {

        public OrganizationPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrganizationPerson organizationPerson = new OrganizationPerson();
            organizationPerson.setOrganizationPersonId(rs.getInt("organizationPersonId"));
            Person person = new Person();
            person.setPersonId(rs.getInt("personId"));
            organizationPerson.setPerson(person);
            Organization organization = new Organization();
            organization.setOrganizationId(rs.getInt("organizationId"));
            organizationPerson.setOrganization(organization);
            return organizationPerson;
        }
    }    
}
