/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.User;
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
public class UserDaoImplementation implements UserDaoInterface {
    
    private static final String SQL_INSERT_USER = "insert into Users (personId) values (?)";
    
    private static final String SQL_SELECT_USER = "select * from Users where userId = ?";
    
    private static final String SQL_LIST_USER = "select * from Users limit ? offset ?";
    
    private static final String SQL_UPDATE_USER = "update Users set personId = ? where userId = ?";
    
    private static final String SQL_DELETE_USER = "delete from Users where userId = ?";
    
    private static final String SQL_LIST_USER_BY_PERSON = "select * from Users where personId = ? limit ? offset ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public User createUser(User user) {
        jdbcTemplate.update(SQL_INSERT_USER,
            user.getPerson().getPersonId());
        int userId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        user.setUserId(userId);
        return user;
    }
    
    @Override
    public User readUser(Integer userId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_USER, new UserDaoImplementation.UserMapper(), userId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<User> listUser(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_USER, new UserDaoImplementation.UserMapper(), limit, offset);
    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update(SQL_UPDATE_USER,
            user.getPerson().getPersonId(),
            user.getUserId());           
    }
    
    @Override
    public void deleteUser(Integer userId) {
        jdbcTemplate.update(SQL_DELETE_USER, userId);
    }

    //relational methods:
    
    @Override
    public List<User> listUserByPerson(Person person, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_USER_BY_PERSON, new UserMapper(), person.getPersonId(), limit, offset);
    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            Person person = new Person();
            person.setPersonId(rs.getInt("personId"));
            user.setPerson(person);
            return user;
        }
    }    
    
}
