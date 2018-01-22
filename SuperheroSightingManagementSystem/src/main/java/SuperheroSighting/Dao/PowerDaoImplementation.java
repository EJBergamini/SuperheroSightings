/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Power;
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
public class PowerDaoImplementation implements PowerDaoInterface {
    
    private static final String SQL_INSERT_POWER = "insert into Powers (powerName, powerDescription) values (?,?)";
    
    private static final String SQL_SELECT_POWER = "select * from Powers where powerId = ?";
    
    private static final String SQL_LIST_POWER = "select * from Powers limit ? offset ?";
    
    private static final String SQL_UPDATE_POWER = "update Powers set powerId = ?, powerDescription = ?";
    
    private static final String SQL_DELETE_POWER = "delete from Powers where powerId = ?";
    
    private static final String SQL_LIST_POWER_BY_SUPERPERSON = "select * from Powers where superpersonId = ? limit ? offset ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Power createPower(Power power) {
        jdbcTemplate.update(SQL_INSERT_POWER,
            power.getPowerName(),
            power.getPowerDescription());
        int powerId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        power.setPowerId(powerId);
        return power;
    }
    
    @Override
    public Power readPower(Integer powerId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POWER, new PowerDaoImplementation.PowerMapper(), powerId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<Power> listPower(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_POWER, new PowerDaoImplementation.PowerMapper(), limit, offset);
    }

    @Override
    public void updatePower(Power power) {
        jdbcTemplate.update(SQL_UPDATE_POWER,
            power.getPowerName(),
            power.getPowerDescription(),
            power.getPowerId());
    }
    
    @Override
    public void deletePower(Integer powerId) {
        jdbcTemplate.update(SQL_DELETE_POWER, powerId);
    }

    //relational methods:
    
    @Override
    public List<Power> listPowerBySuperperson(Superperson superperson, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_POWER_BY_SUPERPERSON, new PowerDaoImplementation.PowerMapper(), superperson.getSuperpersonId(), limit, offset);
    }

    private static final class PowerMapper implements RowMapper<Power> {

        public Power mapRow(ResultSet rs, int rowNum) throws SQLException {
            Power power = new Power();
            power.setPowerId(rs.getInt("powerId"));
            power.setPowerName(rs.getString("powerName"));
            power.setPowerDescription(rs.getString("powerDescription"));
            return power;
        }
    }   
    
}
