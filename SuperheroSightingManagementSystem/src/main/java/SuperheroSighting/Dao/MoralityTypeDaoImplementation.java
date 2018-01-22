/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.MoralityType;
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
public class MoralityTypeDaoImplementation implements MoralityTypeDaoInterface {
    
    private static final String SQL_INSERT_MORALITYTYPE = "insert into MoralityType (moralityDescription) values (?)";
    
    private static final String SQL_SELECT_MORALITYTYPE = "select * from MoralityType where moralityTypeId = ?";
    
    private static final String SQL_LIST_MORALITYTYPE = "select * from MoralityType limit ? offset ?";
    
    private static final String SQL_UPDATE_MORALITYTYPE = "update MoralityType set moralityDescription = ? where moralityTypeId = ?";
    
    private static final String SQL_DELETE_MORALITYTYPE = "delete from MoralityType where moralityTypeId = ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public MoralityType createMoralityType(MoralityType moralityType) {
        jdbcTemplate.update(SQL_INSERT_MORALITYTYPE, 
            moralityType.getMoralityDescription());
        int moralityTypeId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        moralityType.setMoralityTypeId(moralityTypeId);
        return moralityType;
    }
    
    @Override
    public MoralityType readMoralityType(Integer moralityTypeId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_MORALITYTYPE,
                    new MoralityTypeDaoImplementation.MoralityTypeMapper(), moralityTypeId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<MoralityType> listMoralityType(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_MORALITYTYPE, new MoralityTypeDaoImplementation.MoralityTypeMapper(), limit, offset);
    }

    @Override
    public void updateMoralityType(MoralityType moralityType) {
        jdbcTemplate.update(SQL_UPDATE_MORALITYTYPE,
                moralityType.getMoralityDescription(),
                moralityType.getMoralityTypeId());
    }
    
    @Override
    public void deleteMoralityType(Integer moralityTypeId) {
        jdbcTemplate.update(SQL_DELETE_MORALITYTYPE, moralityTypeId);
    }

    private static final class MoralityTypeMapper implements RowMapper<MoralityType> {

        public MoralityType mapRow(ResultSet rs, int rowNum) throws SQLException {
            MoralityType moralityType = new MoralityType();
            moralityType.setMoralityTypeId(rs.getInt("moralityTypeId"));
            moralityType.setMoralityDescription(rs.getString("moralityDescription"));
            return moralityType;
        }
    }    
}
