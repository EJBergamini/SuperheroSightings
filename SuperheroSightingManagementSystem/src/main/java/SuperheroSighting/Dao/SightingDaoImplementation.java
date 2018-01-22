/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.Date;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author EJB Laptop
 */
public class SightingDaoImplementation implements SightingDaoInterface {
    
    private static final String SQL_INSERT_SIGHTING = "insert into Sightings (userId, locationId, sightingDescription, sightingDateTime) values (?,?,?,?)";
    
    private static final String SQL_SELECT_SIGHTING = "select * from Sightings where sightingId = ?";
    
    private static final String SQL_LIST_SIGHTING = "select * from Sightings ORDER BY sightingDateTime DESC limit ? offset ?";
    
    private static final String SQL_UPDATE_SIGHTING = "update Sightings set userId = ?, locationId = ?, sightingDescription = ?, sightingDateTime = ? where sightingId = ?";
    
    private static final String SQL_DELETE_SIGHTING = "delete from Sightings where sightingId = ?";
    
    private static final String SQL_LIST_SIGHTING_BY_USER = "select * from Sightings where userId = ?  limit ? offset ?";
    
    private static final String SQL_LIST_SIGHTING_BY_LOCATION = "select * from Sightings where locationId = ?  limit ? offset ?";
    
    private static final String SQL_LIST_SIGHTING_BY_DATE = "select * from Sightings where sightingDateTime >= ? and sightingDateTime < ? limit ? offset ?";
    
    private static final String SQL_LIST_SIGHTING_BY_SUPERPERSON = "select * from Sightings where superpersonId = ?  limit ? offset ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Sighting createSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_INSERT_SIGHTING,
            sighting.getUser().getUserId(),
            sighting.getLocation().getLocationId(),
            sighting.getSightingDescription(),
            sighting.getSightingDateTime().toString());
        int sightingId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        sighting.setSightingId(sightingId);
        return sighting;
    }
    
    @Override
    public Sighting readSighting(Integer sightingId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SIGHTING, new SightingDaoImplementation.SightingMapper(), sightingId);
        }   catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<Sighting> listSighting(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SIGHTING, new SightingDaoImplementation.SightingMapper(), limit, offset);
    }

    @Override
    public void updateSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_UPDATE_SIGHTING,
            sighting.getUser().getUserId(),
            sighting.getLocation().getLocationId(),
            sighting.getSightingDescription(),
            sighting.getSightingDateTime().toString(),
            sighting.getSightingId());
    }
    
    @Override
    public void deleteSighting(Integer sightingId) {
        jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingId);
    }

    //relational methods:
    
    @Override
    public List<Sighting> listSightingByUser(User user, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SIGHTING_BY_USER, new SightingDaoImplementation.SightingMapper(), user.getUserId(), limit, offset);
    }

    @Override
    public List<Sighting> listSightingByLocation(Location location, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SIGHTING_BY_LOCATION, new SightingDaoImplementation.SightingMapper(), location.getLocationId(), limit, offset);
    }

    @Override
    public List<Sighting> listSightingByDate(LocalDate date, int limit, int offset) {
        LocalDate nextDay = date.plusDays(1);
        LocalTime midnight = LocalTime.parse("00:00:00");
        return jdbcTemplate.query(SQL_LIST_SIGHTING_BY_DATE, new SightingDaoImplementation.SightingMapper(), LocalDateTime.of(date, midnight).toString(), LocalDateTime.of(nextDay, midnight).toString(), limit, offset);
    }

    @Override
    public List<Sighting> listSightingBySuperperson(Superperson superperson, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SIGHTING_BY_SUPERPERSON, new SightingDaoImplementation.SightingMapper(), superperson.getSuperpersonId(), limit, offset);
    }

    private static final class SightingMapper implements RowMapper<Sighting> {

        public Sighting mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sighting sighting = new Sighting();
            sighting.setSightingId(rs.getInt("sightingId"));
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            sighting.setUser(user);
            Location location = new Location();
            location.setLocationId(rs.getInt("locationId"));
            sighting.setLocation(location);
            sighting.setSightingDescription(rs.getString("sightingDescription"));
            sighting.setSightingDateTime(rs.getTimestamp("sightingDateTime").toLocalDateTime());
            return sighting;
        }
    }    
    
}
