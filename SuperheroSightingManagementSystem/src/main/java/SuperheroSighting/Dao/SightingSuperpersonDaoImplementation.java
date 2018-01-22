/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.SightingSuperperson;
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
public class SightingSuperpersonDaoImplementation implements SightingSuperpersonDaoInterface {
    
    private static final String SQL_INSERT_SIGHTINGSUPERPERSON = "insert into SightingsSuperpersons (sightingId, superpersonId) values (?,?)";
    
    private static final String SQL_SELECT_SIGHTINGSUPERPERSON = "select * from SightingsSuperpersons where sightingSuperpersonId = ?";
    
    private static final String SQL_LIST_SIGHTINGSUPERPERSON = "select * from SightingsSuperpersons limit ? offset ?";
    
    private static final String SQL_UPDATE_SIGHTINGSUPERPERSON = "update SightingsSuperpersons set sightingId = ?, superpersonId = ? where sightingSuperpersonId = ?";
    
    private static final String SQL_DELETE_SIGHTINGSUPERPERSON = "delete from SightingsSuperpersons where sightingSuperpersonId = ?";
    
    private static final String SQL_LIST_SIGHTINGSUPERPERSON_BY_SUPERPERSON = "select * from SightingsSuperpersons where superpersonId = ? limit ? offset ?";
    
    private static final String SQL_LIST_SIGHTINGSUPERPERSON_BY_SIGHTING = "select * from SightingsSuperpersons where sightingId = ? limit ? offset ?";
    
    private static final String SQL_DELETE_SIGHTINGSUPERPERSON_BY_SUPERPERSON = "delete from SightingsSuperpersons where superpersonId = ?";
    
    private static final String SQL_DELETE_SIGHTINGSUPERPERSON_BY_SIGHTING = "delete from SightingsSuperpersons where sightingId = ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public SightingSuperperson createSightingSuperperson(SightingSuperperson sightingSuperperson) {
        jdbcTemplate.update(SQL_INSERT_SIGHTINGSUPERPERSON,
            sightingSuperperson.getSighting().getSightingId(),
            sightingSuperperson.getSuperperson().getSuperpersonId());
        int sightingSuperpersonId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        sightingSuperperson.setSightingSuperpersonId(sightingSuperpersonId);
        return sightingSuperperson;
    }
    
    @Override
    public SightingSuperperson readSightingSuperperson(Integer sightingSuperpersonId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SIGHTINGSUPERPERSON, new SightingSuperpersonDaoImplementation.SightingSuperpersonMapper(), sightingSuperpersonId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<SightingSuperperson> listSightingSuperperson(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SIGHTINGSUPERPERSON, new SightingSuperpersonDaoImplementation.SightingSuperpersonMapper(), limit, offset);
    }

    @Override
    public void updateSightingSuperperson(SightingSuperperson sightingSuperperson) {
        jdbcTemplate.update(SQL_UPDATE_SIGHTINGSUPERPERSON,
            sightingSuperperson.getSighting().getSightingId(),
            sightingSuperperson.getSuperperson().getSuperpersonId(),
            sightingSuperperson.getSightingSuperpersonId());
    }
    
    @Override
    public void deleteSightingSuperperson(Integer sightingSuperpersonId) {
        jdbcTemplate.update(SQL_DELETE_SIGHTINGSUPERPERSON, sightingSuperpersonId);
    }
    
    //relational methods:

    @Override
    public List<SightingSuperperson> listSightingSuperpersonBySuperperson(Superperson superperson, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SIGHTINGSUPERPERSON_BY_SUPERPERSON, new SightingSuperpersonDaoImplementation.SightingSuperpersonMapper(), superperson.getSuperpersonId(), limit, offset);
    }

    @Override
    public List<SightingSuperperson> listSightingSuperpersonBySighting(Sighting sighting, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SIGHTINGSUPERPERSON_BY_SIGHTING, new SightingSuperpersonDaoImplementation.SightingSuperpersonMapper(), sighting.getSightingId(), limit, offset);
    }

    @Override
    public void deleteSightingSuperpersonBySuperperson(Superperson superperson) {
        jdbcTemplate.update(SQL_DELETE_SIGHTINGSUPERPERSON_BY_SUPERPERSON, superperson.getSuperpersonId());
    }

    @Override
    public void deleteSightingSuperpersonBySighting(Sighting sighting) {
        jdbcTemplate.update(SQL_DELETE_SIGHTINGSUPERPERSON_BY_SIGHTING, sighting.getSightingId());
    }

    private static final class SightingSuperpersonMapper implements RowMapper<SightingSuperperson> {

        public SightingSuperperson mapRow(ResultSet rs, int rowNum) throws SQLException {
            SightingSuperperson sightingSuperperson = new SightingSuperperson();
            sightingSuperperson.setSightingSuperpersonId(rs.getInt("sightingSuperpersonId"));
            Sighting sighting = new Sighting();
            sighting.setSightingId(rs.getInt("sightingId"));
            sightingSuperperson.setSighting(sighting);
            Superperson superperson = new Superperson();
            superperson.setSuperpersonId(rs.getInt("superpersonId"));
            sightingSuperperson.setSuperperson(superperson);
            return sightingSuperperson;
        }
    }    
}
