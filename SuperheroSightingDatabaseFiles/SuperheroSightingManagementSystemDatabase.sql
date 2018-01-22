DROP DATABASE IF EXISTS SuperheroSightingManagementSystemDatabase;

CREATE DATABASE SuperheroSightingManagementSystemDatabase;

USE SuperheroSightingManagementSystemDatabase;

CREATE TABLE IF NOT EXISTS Addresses
(
    addressId INT NOT NULL AUTO_INCREMENT,
    streetAddress VARCHAR(100) NOT NULL,
    cityName VARCHAR(50) NOT NULL,
    stateName VARCHAR(2) NOT NULL,
    zipCode VARCHAR(10) NOT NULL,
    countryName VARCHAR(100) NOT NULL,
    planetName VARCHAR(50) NOT NULL,
    PRIMARY KEY (addressId)
);

CREATE TABLE IF NOT EXISTS Powers
(
    powerId INT NOT NULL AUTO_INCREMENT,
    powerName VARCHAR(50) NOT NULL,
    powerDescription VARCHAR(250) NULL,
    PRIMARY KEY (powerId)
);

CREATE TABLE IF NOT EXISTS MoralityTypes
(
    moralityTypeId INT NOT NULL AUTO_INCREMENT,
    moralityDescription VARCHAR(250) NOT NULL,
    PRIMARY KEY (moralityTypeId)
);

CREATE TABLE IF NOT EXISTS Persons
(
    personId INT NOT NULL AUTO_INCREMENT,
    personFirstName VARCHAR(30) NOT NULL,
    personLastName VARCHAR(50) NULL,
    PRIMARY KEY (personId)
);

CREATE TABLE IF NOT EXISTS Contacts
(
    contactId INT NOT NULL AUTO_INCREMENT,
    personId INT NOT NULL,
    addressId INT NOT NULL,
    phoneNumber VARCHAR(20) NOT NULL,
    PRIMARY KEY (contactId)
);

CREATE TABLE IF NOT EXISTS Superpersons
(
    superpersonId INT NOT NULL AUTO_INCREMENT,
    personId INT NOT NULL,
    aliasId INT NULL,
    moralityTypeId INT NOT NULL,
    superpersonDescription VARCHAR(250) NULL,
    PRIMARY KEY (superpersonId)
);

CREATE TABLE IF NOT EXISTS Users
(
    userId INT NOT NULL AUTO_INCREMENT,
    personId INT NOT NULL,
    PRIMARY KEY (userId)
);

CREATE TABLE IF NOT EXISTS Locations
(
    locationId INT NOT NULL AUTO_INCREMENT,
    locationName VARCHAR(50) NOT NULL,
    locationDescription VARCHAR(250) NULL,
    addressId INT NOT NULL,
    cardinalDirectionLongitude CHAR(1) NOT NULL,
    cardinalDirectionLatitude CHAR(1) NOT NULL,
    latitudinalCoordinate DECIMAL(11, 8) NOT NULL,
    longitudinalCoordinate DECIMAL(11, 8) NOT NULL,
    PRIMARY KEY (locationId)
);

CREATE TABLE IF NOT EXISTS SuperpersonsPowers
(
    superpersonPowerId INT NOT NULL AUTO_INCREMENT,
    superpersonId INT NOT NULL,
    powerId INT NOT NULL,
    PRIMARY KEY (superpersonPowerId)
);

CREATE TABLE IF NOT EXISTS Sightings
(
    sightingId INT NOT NULL AUTO_INCREMENT,
    userId INT NOT NULL,
    locationId INT NOT NULL,
    sightingDescription VARCHAR(250) NULL,
    sightingDateTime DATETIME NOT NULL,
    PRIMARY KEY (sightingId)
);

CREATE TABLE IF NOT EXISTS Organizations
(
    organizationId INT NOT NULL AUTO_INCREMENT,
    organizationName VARCHAR(50) NOT NULL,
    organizationDescription VARCHAR(250) NULL,
    addressId INT NOT NULL,
    moralityTypeId INT NOT NULL,
    contactId INT NOT NULL,
    PRIMARY KEY (organizationId)
);

CREATE TABLE IF NOT EXISTS OrganizationsPersons
(
    organizationPersonId INT NOT NULL AUTO_INCREMENT,
    personId INT NOT NULL,
    organizationId INT NOT NULL,
    PRIMARY KEY (organizationPersonId)
);

CREATE TABLE IF NOT EXISTS SightingsSuperpersons
(
    sightingSuperpersonId INT NOT NULL AUTO_INCREMENT,
    sightingId INT NOT NULL,
    superpersonId INT NOT NULL,
    PRIMARY KEY (sightingSuperpersonId)
);

-- FOREIGN KEYS BELOW (BY TABLE):

-- Contacts
ALTER TABLE `Contacts` ADD CONSTRAINT `fk_contactperson` FOREIGN KEY (`personId`) REFERENCES `Persons` (`personId`) ON DELETE NO ACTION;
ALTER TABLE `Contacts` ADD CONSTRAINT `fk_contactaddress` FOREIGN KEY (`addressId`) REFERENCES `Addresses` (`addressId`) ON DELETE NO ACTION;

-- SuperPersons
ALTER TABLE `Superpersons` ADD CONSTRAINT `fk_superpersonperson` FOREIGN KEY (`personId`) REFERENCES `Persons` (`personId`) ON DELETE NO ACTION;
ALTER TABLE `Superpersons` ADD CONSTRAINT `fk_superpersonalias` FOREIGN KEY (`aliasId`) REFERENCES `Persons` (`personId`) ON DELETE NO ACTION;
ALTER TABLE `Superpersons` ADD CONSTRAINT `fk_superpersonmoralitytype` FOREIGN KEY (`moralityTypeId`) REFERENCES `MoralityTypes` (`moralityTypeId`) ON DELETE NO ACTION;

-- Users
ALTER TABLE `Users` ADD CONSTRAINT `fk_userperson` FOREIGN KEY (`personId`) REFERENCES `Persons` (`personId`) ON DELETE NO ACTION;

-- Locations
ALTER TABLE `Locations` ADD CONSTRAINT `fk_locationaddress` FOREIGN KEY (`addressId`) REFERENCES `Addresses` (`addressId`) ON DELETE NO ACTION;

-- SuperPersons_Powers
ALTER TABLE `SuperpersonsPowers` ADD CONSTRAINT `fk_superpersonpowersuperperson` FOREIGN KEY (`superpersonId`) REFERENCES `Superpersons` (`superpersonId`) ON DELETE NO ACTION;
ALTER TABLE `SuperpersonsPowers` ADD CONSTRAINT `fk_superpersonpowerpower` FOREIGN KEY (`powerId`) REFERENCES `Powers` (`powerId`) ON DELETE NO ACTION;

-- Sightings
ALTER TABLE `Sightings` ADD CONSTRAINT `fk_sightinguser` FOREIGN KEY (`userId`) REFERENCES `Users` (`userId`) ON DELETE NO ACTION;
ALTER TABLE `Sightings` ADD CONSTRAINT `fk_sightinglocation` FOREIGN KEY (`locationId`) REFERENCES `Locations` (`locationId`) ON DELETE NO ACTION;

-- Organizations 
ALTER TABLE `Organizations` ADD CONSTRAINT `fk_organizationaddress` FOREIGN KEY (`addressId`) REFERENCES `Addresses` (`AddressID`) ON DELETE NO ACTION;
ALTER TABLE `Organizations` ADD CONSTRAINT `fk_organizationmoralitytype` FOREIGN KEY (`moralityTypeId`) REFERENCES `MoralityTypes` (`moralityTypeId`) ON DELETE NO ACTION;
ALTER TABLE `Organizations` ADD CONSTRAINT `fk_organizationcontact` FOREIGN KEY (`contactId`) REFERENCES `Contacts` (`contactId`) ON DELETE NO ACTION;

-- Organizations_Persons
ALTER TABLE `OrganizationsPersons` ADD CONSTRAINT `fk_organizationpersonperson` FOREIGN KEY (`personId`) REFERENCES `Persons` (`personId`) ON DELETE NO ACTION;
ALTER TABLE `OrganizationsPersons` ADD CONSTRAINT `fk_organizationpersonorganization` FOREIGN KEY (`organizationId`) REFERENCES `Organizations` (`organizationId`) ON DELETE NO ACTION;

-- Sightings_Superpersons
ALTER TABLE `SightingsSuperpersons` ADD CONSTRAINT `fk_sightingsuperpersonsighting` FOREIGN KEY (`sightingId`) REFERENCES `Sightings` (`sightingId`) ON DELETE NO ACTION;
ALTER TABLE `SightingsSuperpersons` ADD CONSTRAINT `fk_sightingsuperpersonsuperperson` FOREIGN KEY (`superpersonId`) REFERENCES `Superpersons` (`superpersonId`) ON DELETE NO ACTION;