/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Location;
import SuperheroSighting.Dto.MoralityType;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Sighting;
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
public class SuperpersonDaoImplementation implements SuperpersonDaoInterface {
    
    private static final String SQL_INSERT_SUPERPERSON = "insert into Superpersons (personId, personId, moralityTypeId, superpersonDescription) values (?,?,?,?)";
    
    private static final String SQL_SELECT_SUPERPERSON = "select * from Superpersons where superpersonId = ?";
    
    private static final String SQL_LIST_SUPERPERSON = "select * from Superpersons limit ? offset ?";
    
    private static final String SQL_UPDATE_SUPERPERSON = "update Superpersons set personId = ?, personId = ?, moralityTypeId = ?, superpersonDescription = ? where superpersonId = ?";
    
    private static final String SQL_DELETE_SUPERPERSON = "delete from Superpersons where superpersonId = ?";
    
//    private static final String SQL_LIST_SUPERPERSON_BY_PERSON = "select * from Superpersons where personId = ? limit ? offset ?";
//    
//    private static final String SQL_LIST_SUPERPERSON_BY_ALIAS = "select * from Superpersons where aliasId = ? limit ? offset ?";
//    
//    private static final String SQL_LIST_SUPERPERSON_BY_MORALITYTYPE = "select * from Superpersons where moralityTypeId = ? limit ? offset ?";
//    
//    private static final String SQL_LIST_SUPERPERSON_BY_LOCATION = "SELECT sp.* FROM Superpersons sp INNER JOIN SightingsSuperpersons ssp ON sp.superpersonId = ssp.superpersonId INNER JOIN Sightings s ON s.sightingId = ssp.sightingId INNER JOIN Locations l ON l.locationId = s.locationId WHERE l.locationId = ? LIMIT ? OFFSET ?";
//    
//    private static final String SQL_LIST_SUPERPERSON_BY_SIGHTING = "select * from Superpersons where sightingId = ? limit ? offset ?";
//    
//    private static final String SQL_LIST_SUPERPERSON_BY_POWER = "select * from Superpersons where powerId = ? limit ? offset ?";
//    
//    private static final String SQL_LIST_SUPERPERSON_BY_ORGANIZATION = "select * from Superpersons where organizationId = ? limit ? offset ?";
    
    private static final String SQL_DELETE_SUPERPERSON_BY_SIGHTING = "delete * from Superpersons where sightingId = ?";
    
    private static final String SQL_DELETE_SUPERPERSON_BY_POWER = "delete * from Superpersons where powerId = ?";
    
    
    private static final String SQL_LIST_SUPERPERSON_BY_MORALITYTYPE = "SELECT * FROM Superpersons "

                                                                    + "WHERE moralityTypeId = ? LIMIT ? OFFSET ?";

    

    private static final String SQL_LIST_SUPERPERSON_BY_PERSON = "SELECT * FROM Superpersons "

                                                                    + "WHERE personId = ? LIMIT ? OFFSET ?";

    

    private static final String SQL_LIST_SUPERPERSON_BY_ALIAS = "SELECT * FROM Superpersons "

                                                                    + "WHERE aliasId = ? LIMIT ? OFFSET ?";    

    

    private static final String SQL_LIST_SUPERPERSON_BY_LOCATION = "SELECT sp.* FROM superpersons sp "

                                                                + "INNER JOIN sightingssuperpersons ssp ON sp.superpersonId = ssp.superpersonId "

                                                                +"INNER JOIN sightings s ON s.sightingId = ssp.sightingId "

                                                                +"INNER JOIN locations l ON l.locationId = s.locationId "

                                                                +"WHERE l.locationId = ? LIMIT ? OFFSET ?";

    

    private static final String SQL_LIST_SUPERPERSON_BY_SIGHTING = "SELECT sp.* FROM superpersons sp "                                                                

                                                                + "INNER JOIN sightingssuperpersons ssp ON sp.superpersonId = ssp.superpersonId "

                                                                +"INNER JOIN sightings s ON s.sightingId = ssp.sightingId "                                          

                                                                +"WHERE s.sightingId = ? LIMIT ? OFFSET ?";



    private static final String SQL_LIST_SUPERPERSON_BY_POWER =  "SELECT sp.* FROM superpersons sp "

                                                                + "INNER JOIN superpersonspowers spp ON spp.superpersonId = sp.superpersonId "

                                                                +"INNER JOIN powers p ON p.powerId = spp.powerId "

                                                                +"WHERE p.powerId = ? LIMIT ? OFFSET ?";

                                             

    

    private static final String SQL_LIST_SUPERPERSON_BY_ORGANIZATION = "SELECT sp.* FROM superpersons sp "

                                                                        +"INNER JOIN organizationspersons op ON op.personId = sp.personId "

                                                                        +"OR op.personId = sp.aliasId "

                                                                        +"INNER JOIN organizations o ON o.organizationId = op.organizationId "

                                                                        +"INNER JOIN organizationspersons op ON op.personId = sp.personId "

                                                                        +"WHERE o.organizationId = ? LIMIT ? OFFSET ?";
    
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD methods:
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Superperson createSuperperson(Superperson superperson) {
        jdbcTemplate.update(SQL_INSERT_SUPERPERSON,
                superperson.getPerson().getPersonId(),
                superperson.getPerson().getPersonId(),
                superperson.getMoralityType().getMoralityTypeId(),
                superperson.getSuperpersonDescription());
        int superpersonId = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        superperson.setSuperpersonId(superpersonId);
        return superperson;
    }
    
    @Override
    public Superperson readSuperperson(Integer superpersonId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPERPERSON,
                    new SuperpersonDaoImplementation.SuperpersonMapper(), superpersonId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<Superperson> listSuperperson(int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSON, new SuperpersonDaoImplementation.SuperpersonMapper(), limit, offset);
    }

    @Override
    public void updateSuperperson(Superperson superperson) {
        jdbcTemplate.update(SQL_UPDATE_SUPERPERSON,
                superperson.getPerson().getPersonId(),
                superperson.getPerson().getPersonId(),
                superperson.getMoralityType().getMoralityTypeId(),
                superperson.getSuperpersonDescription(),
                superperson.getSuperpersonId());
    }
    
    @Override
    public void deleteSuperperson(Integer superpersonId) {
        jdbcTemplate.update(SQL_DELETE_SUPERPERSON, superpersonId);
    }

    //relational methods:

    @Override
    public List<Superperson> listSuperpersonByPerson(Person person, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSON_BY_PERSON, new SuperpersonDaoImplementation.SuperpersonMapper(), person.getPersonId(), limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonByAlias(Person person, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSON_BY_ALIAS, new SuperpersonDaoImplementation.SuperpersonMapper(), person.getPersonId(), limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonByMoralityType(MoralityType moralityType, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSON_BY_MORALITYTYPE, new SuperpersonDaoImplementation.SuperpersonMapper(), moralityType.getMoralityTypeId(), limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonByLocation(Location location, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSON_BY_LOCATION, new SuperpersonDaoImplementation.SuperpersonMapper(), location.getLocationName(), limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonBySighting(Sighting sighting, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSON_BY_SIGHTING, new SuperpersonDaoImplementation.SuperpersonMapper(), sighting.getSightingId(), limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonByPower(Power power, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSON_BY_POWER, new SuperpersonDaoImplementation.SuperpersonMapper(), power.getPowerId(), limit, offset);
    }

    @Override
    public List<Superperson> listSuperpersonByOrganization(Organization organization, int limit, int offset) {
        return jdbcTemplate.query(SQL_LIST_SUPERPERSON_BY_ORGANIZATION, new SuperpersonDaoImplementation.SuperpersonMapper(), organization.getOrganizationId(), limit, offset);
    }
   
    private static final class SuperpersonMapper implements RowMapper<Superperson> {

        public Superperson mapRow(ResultSet rs, int rowNum) throws SQLException {
            Superperson superperson = new Superperson();
            superperson.setSuperpersonId(rs.getInt("superpersonId"));
            Person person = new Person();
            person.setPersonId(rs.getInt("personId"));
            superperson.setPerson(person);
            Person alias = new Person();
            alias.setPersonId(rs.getInt("aliasId"));
            superperson.setAlias(alias);
            MoralityType moralityType = new MoralityType();
            moralityType.setMoralityTypeId(rs.getInt("moralityTypeId"));
            superperson.setMoralityType(moralityType);
            return superperson;
        }
    }    
}
