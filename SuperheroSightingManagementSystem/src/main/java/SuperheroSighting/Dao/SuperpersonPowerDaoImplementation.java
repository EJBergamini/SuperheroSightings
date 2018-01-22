/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.SuperpersonPower;
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
public class SuperpersonPowerDaoImplementation implements SuperpersonPowerDaoInterface {
    
    private static final String SQL_INSERT_SUPERPERSONPOWER = "insert into SuperpersonsPowers (superpersonId, powerId) values (?,?)";
    
    private static final String SQL_SELECT_SUPERPERSONPOWER = "select * from SuperpersonsPowers where superpersonPowerId = ?";
    
    private static final String SQL_LIST_SUPERPERSONPOWER = "select * from SuperpersonsPowers limit ? offset ?";
    
    private static final String SQL_UPDATE_SUPERPERSONPOWER = "update SuperpersonsPowers set superpersonId = ?, powerId = ? where superpersonPowerId = ?";
    
    private static final String SQL_DELETE_SUPERPERSONPOWER = "delete from SuperpersonsPowers where superpersonPowerId = ?";
    
    private static final String SQL_LIST_SUPERPERSONPOWER_BY_SUPERPERSON = "select * from SuperpersonsPowers where superpersonId = ? limit ? offset ?";
    
    private static final String SQL_LIST_SUPERPERSONPOWER_BY_POWER = "select * from SuperpersonsPowers where powerId = ? limit ? offset ?";
    
    private static final String SQL_DELETE_SUPERPERSONPOWER_BY_SUPERPERSON = "delete from SuperpersonsPowers where superpersonId = ?";
    
    private static final String SQL_DELETE_SUPERPERSONPOWER_BY_POWER = "delete from SuperpersonsPowers where powerId = ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public SuperpersonPower createSuperpersonPower(SuperpersonPower superpersonPower) {
        jdbcTemplate.update(SQL_INSERT_SUPERPERSONPOWER,
            superpersonPower.getSuperperson().getSuperpersonId(),
            superpersonPower.getPower().getPowerId());
        int superpersonPowerId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        superpersonPower.setSuperpersonPowerId(superpersonPowerId);
        return superpersonPower;
    }
    
    @Override
    public SuperpersonPower readSuperpersonPowerById(Integer superpersonPowerId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPERPERSONPOWER, new SuperpersonPowerDaoImplementation.SuperpersonPowerMapper(), superpersonPowerId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<SuperpersonPower> listSuperpersonPower(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSONPOWER, new SuperpersonPowerDaoImplementation.SuperpersonPowerMapper(), limit, offset);
    }

    @Override
    public void updateSuperpersonPower(SuperpersonPower superpersonPower) {
        jdbcTemplate.update(SQL_UPDATE_SUPERPERSONPOWER,
            superpersonPower.getSuperperson().getSuperpersonId(),
            superpersonPower.getPower().getPowerId(),
            superpersonPower.getSuperpersonPowerId());               
    }
    
    @Override
    public void deleteSuperpersonPower(Integer superpersonPowerId) {
        jdbcTemplate.update(SQL_DELETE_SUPERPERSONPOWER, superpersonPowerId);
    }

    //relational methods:

    @Override
    public void deleteSuperpersonPowerByPower(Power power) {
        jdbcTemplate.update(SQL_DELETE_SUPERPERSONPOWER_BY_POWER, power.getPowerId());
    }

    @Override
    public void deleteSuperpersonPowerBySuperperson(Superperson superperson) {
        jdbcTemplate.update(SQL_DELETE_SUPERPERSONPOWER_BY_SUPERPERSON, superperson.getSuperpersonId());
    }
    
    @Override
    public List<SuperpersonPower> listSuperpersonPowerByPower(Power power, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSONPOWER_BY_POWER, new SuperpersonPowerDaoImplementation.SuperpersonPowerMapper(), power.getPowerId(), limit, offset);
    }

    @Override
    public List<SuperpersonPower> listSuperpersonPowerBySuperperson(Superperson superperson, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSONPOWER_BY_SUPERPERSON, new SuperpersonPowerDaoImplementation.SuperpersonPowerMapper(), superperson.getSuperpersonId(), limit, offset);
    }
    
    private static final class SuperpersonPowerMapper implements RowMapper<SuperpersonPower> {

        public SuperpersonPower mapRow(ResultSet rs, int rowNum) throws SQLException {
            SuperpersonPower superpersonPower = new SuperpersonPower();
            superpersonPower.setSuperpersonPowerId(rs.getInt("superpersonPowerId"));
            Superperson superperson = new Superperson();
            superperson.setSuperpersonId(rs.getInt("superpersonId"));
            superpersonPower.setSuperperson(superperson);
            Power power = new Power();
            power.setPowerId(rs.getInt("powerId"));
            superpersonPower.setPower(power);
            return superpersonPower;
        }
    }    
}
