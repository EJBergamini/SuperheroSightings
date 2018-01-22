/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSightingDaoTest;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author EJB Laptop
 */
public class TestingDataInjector {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
private static final String[] INSERT_DATA = {

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Persons(personId,personFirstName,personLastName) VALUES(1, 'Nick', 'Kuster')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Persons(personId,personFirstName,personLastName) VALUES(2, 'Connor', 'Kelly')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Persons(personId,personFirstName,personLastName) VALUES(3,'Brittany','Miller')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Persons(personId,personFirstName,personLastName) VALUES(4,'Eric','Bergamini')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Persons(personId,personFirstName,personLastName) VALUES(5,'Chippy','McChiperson')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Powers(powerId,powerName,powerDescription) VALUES (1, 'X-Ray Vision', 'Allows one to see through physical objects'), ('2', 'Telekensis', 'Move physical objects using thoughts'), ('3', 'Super Speed', 'Movements increase by 1000X'), ('4', 'Auto-Healing', 'Body heals itself at a normal than faster rate'), ('5', 'Super Strength', 'Stronger than normal capabilities')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Addresses(addressId, streetAddress, cityName, stateName, zipCode, countryName, planetName)"

    + "VALUES(1,'9764 Jeopardy Lane','Chicago','IL','60015','USA','Earth'), "

    + "(2,'518 Crestview Drive','Beverly Hills','CA','90077','Z67','Mars'), "

    + "(3,'31 Spooner Street','Quahog','RI','02907','VXZ','Saturn'), "

    + "(4,'1407 Graymalkin Lane','Salem Center','NY','10560','Boogers','Neptune'),(5,'111 Archer Avenue','New York City','NY','10550','Glurble','Venus')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.MoralityTypes (moralityTypeId, moralityDescription) VALUES (1, 'Lawful Good')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.MoralityTypes (moralityTypeId, moralityDescription) VALUES (2, 'Chaotic Good')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.MoralityTypes (moralityTypeId, moralityDescription) VALUES (3, 'Neutral')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.MoralityTypes (moralityTypeId, moralityDescription) VALUES (4, 'Chaotic Bad')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.MoralityTypes (moralityTypeId, moralityDescription) VALUES (5, 'Lawful Bad')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.superpersons (superpersonId, personId,aliasId,moralityTypeId, superpersonDescription) "
    + "VALUES(1,1, 1, 1, 'The best... around!'),(2,2,2,2,'Jumpin down rabbit holes'), "

    + "(3,3,3,3,'Super Acronym/ I really dont care woman'), (4,4,4,4,'KneeCaps/RainbowUnicorn man'), "

    + "(5,5,5,5,'Magically Delicious')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Users(userId, personId) VALUES (1, 1), (2, 2), (3, 3), (4, 4), (5, 5)",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Contacts(contactId, personId, addressId, phoneNumber) VALUES(1,2,1,'2164325561'),(2,1,2,'8188675309'),(3,4,4,'5550002323'),(4,5,3,'4449096767'),(5,3,5,'3306543257')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Locations (locationId, locationName, locationDescription, addressId, cardinalDirectionLongitude, cardinalDirectionLatitude, latitudinalCoordinate, longitudinalCoordinate) VALUES (1, 'Starbucks Downtown','A Starbucks in downtown Akron.','5','N','E','25.23','45.75')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Locations (locationId, locationName, locationDescription, addressId, cardinalDirectionLongitude, cardinalDirectionLatitude, latitudinalCoordinate, longitudinalCoordinate) VALUES (2, 'Tat Poners House','A mancave somewhere.','4','S','W','89.60','89.60')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Locations (locationId, locationName, locationDescription, addressId, cardinalDirectionLongitude, cardinalDirectionLatitude, latitudinalCoordinate, longitudinalCoordinate) VALUES (3, 'The Natatorium','The Cuyahoga Falls recreation center.','3','N','E','75','10')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Locations (locationId, locationName, locationDescription, addressId, cardinalDirectionLongitude, cardinalDirectionLatitude, latitudinalCoordinate, longitudinalCoordinate) VALUES (4, 'Kent State','A university in NE Ohio.','2','S','W','25','15.60')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.Locations (locationId, locationName, locationDescription, addressId, cardinalDirectionLongitude, cardinalDirectionLatitude, latitudinalCoordinate, longitudinalCoordinate) VALUES (5, 'Hudson Square','A town square in NE Ohio','1','N','E','10.34','0.65')",

    "INSERT INTO Sightings(sightingId, userId, locationId, sightingDescription, sightingDateTime) VALUES (1, 1, 1, 'Shit Happened', '1999-12-05 12:12:12'), (2, 2, 2, 'The good guys lost', '2004-10-15 17:13:44'), (3, 3, 3, 'The bad guys won', '2003-11-29 13:30:24'), (4, 4, 4, 'False alarm', '2013-12-13 13:45:19'), (5, 5, 5, 'I think I saw Batman', '2009-10-15 14:23:23')",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.SuperpersonsPowers(superpersonPowerId, superPersonId, powerId) VALUES(1,5,2),(2,4,3),(3,3,4),(4,2,5),(5,1,1)",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.organizations (organizationId,organizationName,organizationDescription,addressId,moralityTypeId,contactId) VALUES(1,'Lair of Listerine', 'Fights them germs',1,1,1),(2,'Team of Tiny Turtle Tots', 'Slowly but surely',2,2,2),(3,'Super Serial Spotted Sillies', 'Boinga Boinga',3,3,3),(4,'Amalgam of Angry Ardvarks','Dont mess with these guys',4,4,4),(5,'Zingy Zebra Zippers','ummm....',5,5,5)",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.organizationspersons (organizationPersonId,personId,organizationId) VALUES(1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5)",

    "INSERT INTO SuperheroSightingManagementSystemDatabaseTest.sightingssuperpersons (sightingSuperpersonId, sightingId, superpersonId) VALUES(1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5)"

};

private static final String[] DELETE_DATA = {
    
    "SET foreign_key_checks = 0",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.Addresses WHERE addressId > 0;",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.Powers WHERE powerId > 0;",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.MoralityTypes WHERE moralityTypeId > 0;",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.Persons WHERE personId > 0;",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.Contacts WHERE contactId > 0;",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.Superpersons WHERE superpersonId > 0;",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.Users WHERE userId > 0;",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.Locations WHERE locationId > 0;",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.SuperpersonsPowers WHERE superpersonPowerId > 0;",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.Sightings WHERE sightingId > 0;",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.Organizations WHERE organizationId > 0;",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.OrganizationsPersons WHERE organizationPersonId > 0;",

    "DELETE FROM SuperheroSightingManagementSystemDatabaseTest.SightingsSuperpersons WHERE sightingSuperpersonId > 0;",
        
    "SET foreign_key_checks = 1",

};



    public void setUpDatabase(){
        tearDownDatabase();
        jdbcTemplate.batchUpdate(INSERT_DATA);

    }



    public void tearDownDatabase(){

         jdbcTemplate.batchUpdate(DELETE_DATA);

    }
    
}
