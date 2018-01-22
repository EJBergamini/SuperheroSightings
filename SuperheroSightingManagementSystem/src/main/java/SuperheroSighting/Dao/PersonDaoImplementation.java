/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

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
public class PersonDaoImplementation implements PersonDaoInterface {
    
    private static final String SQL_INSERT_PERSON = "insert into Persons (personFirstName, personLastName) values (?,?)";
    
    private static final String SQL_SELECT_PERSON = "select * from Persons where personId = ?";
    
    private static final String SQL_LIST_PERSON = "select * from Persons limit ? offset ?";
    
    private static final String SQL_UPDATE_PERSON = "update Persons set personFirstName = ?, personLastName = ? where personId = ?";
    
    private static final String SQL_DELETE_PERSON = "delete from Persons where personId = ?";
    
    private static final String SQL_LIST_PERSON_BY_ORGANIZATION = "select * from Persons where organizationId = ? limit ? offset ?";
    
    private static final String SQL_LIST_PERSON_BY_CONTACT = "select * from Persons where contactId = ? limit ? offset ?";;
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Person createPerson(Person person) {
        jdbcTemplate.update(SQL_INSERT_PERSON,
            person.getPersonFirstName(),
            person.getPersonLastName());
        int personId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        person.setPersonId(personId);
        return person;
    }
    
    @Override
    public Person readPerson(Integer personId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PERSON, new PersonDaoImplementation.PersonMapper(), personId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<Person> listPerson(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_PERSON, new PersonDaoImplementation.PersonMapper(), limit, offset);
    }

    @Override
    public void updatePerson(Person person) {
        jdbcTemplate.update(SQL_UPDATE_PERSON,
            person.getPersonFirstName(),
            person.getPersonLastName(),
            person.getPersonId());
    }
    
    @Override
    public void deletePerson(Integer personId) {
        jdbcTemplate.update(SQL_DELETE_PERSON, personId);
    }
    
    //relational methods:
    
    @Override
    public List<Person> listPersonByOrganization(Organization organization, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_PERSON_BY_ORGANIZATION, new PersonDaoImplementation.PersonMapper(), organization.getOrganizationId(), limit, offset);
    }
    
    @Override
    public List<Person> listPersonByContact(Contact contact, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_PERSON_BY_CONTACT, new PersonDaoImplementation.PersonMapper(), contact.getContactId(), limit, offset);
    }

    private static final class PersonMapper implements RowMapper<Person> {

        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setPersonId(rs.getInt("personId"));
            person.setPersonFirstName(rs.getString("personFirstName"));
            person.setPersonLastName(rs.getString("personLastName"));
            return person;
        }
    }    
}
