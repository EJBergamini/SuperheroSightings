/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Location;
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
public class LocationDaoImplementation implements LocationDaoInterface {
    
    private static final String SQL_INSERT_LOCATION = "insert into Locations (locationName, locationDescription, addressId,  cardinalDirectionLongitude, cardinalDirectionLatitude, latitudinalCoordinate, longitudinalCoordinate values (?,?,?,?,?,?,?)";
    
    private static final String SQL_SELECT_LOCATION = "select * from Locations where locationId = ?";
    
    private static final String SQL_LIST_LOCATION = "select * from Locations limit ? offset ?";
    
    private static final String SQL_UPDATE_LOCATION = "update Locations set locationName = ?, locationDescription = ?, addressId = ?, cardinalDirectionLongitude = ?, cardinalDirectionLatitude = ?, latitudinalCoordinate = ?, longitudinalCoordinate = ? where locationId = ?";
    
    private static final String SQL_DELETE_LOCATION = "delete from Locations where locationId = ?";
    
    private static final String SQL_LIST_LOCATION_BY_SUPERPERSON = "select * from Locations where superpersonId = ? limit ? offset ?";
    
    private static final String SQL_LIST_LOCATION_BY_ADDRESS = "select * from Locations where addressId = ? limit ? offset ?";
     
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Location createLocation(Location location) {
        jdbcTemplate.update(SQL_INSERT_LOCATION, 
                location.getLocationName(),
                location.getLocationDescription(),
                location.getAddress().getAddressId(),
                location.getCardinalDirectionLongitude(),
                location.getCardinalDirectionLatitude(),
                location.getLatitudinalCoordinate(),
                location.getLongitudinalCoordinate());
        int locationId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        location.setLocationId(locationId);
        return location;
    }
    
    @Override
    public Location readLocation(Integer locationId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION,
                    new LocationDaoImplementation.LocationMapper(), locationId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<Location> listLocation(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_LOCATION, new LocationDaoImplementation.LocationMapper(), limit, offset);
    }

    @Override
    public void updateLocation(Location location) {
        jdbcTemplate.update(SQL_UPDATE_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getAddress().getAddressId(),
                location.getCardinalDirectionLongitude(),
                location.getCardinalDirectionLatitude(),
                location.getLatitudinalCoordinate(),
                location.getLongitudinalCoordinate(),
                location.getLocationId());
    }
    
    @Override
    public void deleteLocation(Integer locationId) {
        jdbcTemplate.update(SQL_DELETE_LOCATION, locationId);
    }

    //relational methods:

    @Override
    public List<Location> listLocationBySuperperson(Superperson superperson, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_LOCATION_BY_SUPERPERSON, new LocationMapper(), superperson.getSuperpersonId(), limit, offset);
    }
    
    @Override
    public List<Location> listLocationByAddress(Address address, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_LOCATION_BY_ADDRESS, new LocationMapper(), address.getAddressId(), limit, offset);
    }
    
    private static final class LocationMapper implements RowMapper<Location> {

        public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
            Location location = new Location();
            location.setLocationId(rs.getInt("locationID"));
            location.setLocationName(rs.getString("locationName"));
            location.setLocationDescription(rs.getString("locationDescription"));
            Address address = new Address();
            address.setAddressId(rs.getInt("addressId"));
            location.setAddress(address);
            location.setCardinalDirectionLongitude(rs.getString("cardinalDirectionLongitude"));
            location.setCardinalDirectionLatitude(rs.getString("cardinalDirectionLatitude"));
            location.setLatitudinalCoordinate(rs.getFloat("latitudinalCoordinate"));
            location.setLongitudinalCoordinate(rs.getFloat("longitudinalCoordinate"));
            return location;
        }
    }    
}
