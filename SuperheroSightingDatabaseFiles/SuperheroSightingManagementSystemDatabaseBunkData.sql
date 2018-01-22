USE SuperheroSightingManagementSystemDatabase;

INSERT INTO SuperheroSightingManagementSystemDatabase.Persons(personId,personFirstName,personLastName) VALUES(1, 'Nick', 'Kuster');

INSERT INTO SuperheroSightingManagementSystemDatabase.Persons(personId,personFirstName,personLastName) VALUES(2, 'Connor', 'Kelly');

INSERT INTO SuperheroSightingManagementSystemDatabase.Persons(personId,personFirstName,personLastName) VALUES(3,'Brittany','Miller');

INSERT INTO SuperheroSightingManagementSystemDatabase.Persons(personId,personFirstName,personLastName) VALUES(4,'Eric','Bergamini');

INSERT INTO SuperheroSightingManagementSystemDatabase.Persons(personId,personFirstName,personLastName) VALUES(5,'Chippy','McChiperson');

INSERT INTO SuperheroSightingManagementSystemDatabase.Powers(powerId,powerName,powerDescription) VALUES (1, 'X-Ray Vision', 'Allows one to see through physical objects');

INSERT INTO SuperheroSightingManagementSystemDatabase.Powers(powerId,powerName,powerDescription) VALUES (2, 'Telekensis', 'Move physical objects using thoughts'); 

INSERT INTO SuperheroSightingManagementSystemDatabase.Powers(powerId,powerName,powerDescription) VALUES (3, 'Super Speed', 'Movements increase by 1000X');

INSERT INTO SuperheroSightingManagementSystemDatabase.Powers(powerId,powerName,powerDescription) VALUES (4, 'Auto-Healing', 'Body heals itself at a normal than faster rate');

INSERT INTO SuperheroSightingManagementSystemDatabase.Powers(powerId,powerName,powerDescription) VALUES (5, 'Super Strength', 'Stronger than normal capabilities');

INSERT INTO SuperheroSightingManagementSystemDatabase.Addresses(addressId, streetAddress, cityName, stateName, zipCode, countryName, planetName) VALUES (1, '9764 Jeopardy Lane','Chicago','IL','60015','USA','Earth');

INSERT INTO SuperheroSightingManagementSystemDatabase.Addresses(addressId, streetAddress, cityName, stateName, zipCode, countryName, planetName) VALUES (2, '518 Crestview Drive','Beverly Hills','CA','90077','Z67','Mars');

INSERT INTO SuperheroSightingManagementSystemDatabase.Addresses(addressId, streetAddress, cityName, stateName, zipCode, countryName, planetName) VALUES (3, '31 Spooner Street','Quahog','RI','02907','VXZ','Saturn');

INSERT INTO SuperheroSightingManagementSystemDatabase.Addresses(addressId, streetAddress, cityName, stateName, zipCode, countryName, planetName) VALUES (4, '1407 Graymalkin Lane','Salem Center','NY','10560','Boogers','Neptune');

INSERT INTO SuperheroSightingManagementSystemDatabase.Addresses(addressId, streetAddress, cityName, stateName, zipCode, countryName, planetName) VALUES (5, '111 Archer Avenue','New York City','NY','10550','Glurble','Venus');

INSERT INTO SuperheroSightingManagementSystemDatabase.MoralityTypes (moralityTypeId, moralityDescription) VALUES (1, 'Lawful Good');

INSERT INTO SuperheroSightingManagementSystemDatabase.MoralityTypes (moralityTypeId, moralityDescription) VALUES (2, 'Chaotic Good');

INSERT INTO SuperheroSightingManagementSystemDatabase.MoralityTypes (moralityTypeId, moralityDescription) VALUES (3, 'Neutral');

INSERT INTO SuperheroSightingManagementSystemDatabase.MoralityTypes (moralityTypeId, moralityDescription) VALUES (4, 'Chaotic Bad');

INSERT INTO SuperheroSightingManagementSystemDatabase.MoralityTypes (moralityTypeId, moralityDescription) VALUES (5, 'Lawful Bad');

INSERT INTO SuperheroSightingManagementSystemDatabase.superpersons (superpersonId, personId,aliasId,moralityTypeId, superpersonDescription) VALUES (1, 1, 1, 1, 'The best... around!');

INSERT INTO SuperheroSightingManagementSystemDatabase.superpersons (superpersonId, personId,aliasId,moralityTypeId, superpersonDescription) VALUES (2, 2, 2, 2, 'Jumpin down rabbit holes');

INSERT INTO SuperheroSightingManagementSystemDatabase.superpersons (superpersonId, personId,aliasId,moralityTypeId, superpersonDescription) VALUES (3,3,3,3,'Super Acronym/ I really dont care woman');

INSERT INTO SuperheroSightingManagementSystemDatabase.superpersons (superpersonId, personId,aliasId,moralityTypeId, superpersonDescription) VALUES (4,4,4,4,'KneeCaps/RainbowUnicorn man');

INSERT INTO SuperheroSightingManagementSystemDatabase.superpersons (superpersonId, personId,aliasId,moralityTypeId, superpersonDescription) VALUES (5,5,5,5,'Magically Delicious');

INSERT INTO SuperheroSightingManagementSystemDatabase.Users(userId, personId) VALUES (1, 1);

INSERT INTO SuperheroSightingManagementSystemDatabase.Users(userId, personId) VALUES (2, 2);

INSERT INTO SuperheroSightingManagementSystemDatabase.Users(userId, personId) VALUES (3, 3);

INSERT INTO SuperheroSightingManagementSystemDatabase.Users(userId, personId) VALUES (4, 4);

INSERT INTO SuperheroSightingManagementSystemDatabase.Users(userId, personId) VALUES (5, 5);

INSERT INTO SuperheroSightingManagementSystemDatabase.Contacts(contactId, personId, addressId, phoneNumber) VALUES (1,2,1,'2164325561');

INSERT INTO SuperheroSightingManagementSystemDatabase.Contacts(contactId, personId, addressId, phoneNumber) VALUES (2,1,2,'8188675309');

INSERT INTO SuperheroSightingManagementSystemDatabase.Contacts(contactId, personId, addressId, phoneNumber) VALUES (3,4,4,'5550002323');

INSERT INTO SuperheroSightingManagementSystemDatabase.Contacts(contactId, personId, addressId, phoneNumber) VALUES (4,5,3,'4449096767');

INSERT INTO SuperheroSightingManagementSystemDatabase.Contacts(contactId, personId, addressId, phoneNumber) VALUES (5,3,5,'3306543257');

INSERT INTO SuperheroSightingManagementSystemDatabase.Locations (locationId, locationName, locationDescription, addressId, cardinalDirectionLongitude, cardinalDirectionLatitude, latitudinalCoordinate, longitudinalCoordinate) VALUES (1, 'Starbucks Downtown','A Starbucks in downtown Akron.','5','N','E','25.23','45.75');

INSERT INTO SuperheroSightingManagementSystemDatabase.Locations (locationId, locationName, locationDescription, addressId, cardinalDirectionLongitude, cardinalDirectionLatitude, latitudinalCoordinate, longitudinalCoordinate) VALUES (2, 'Tat Poners House','A mancave somewhere.','4','S','W','89.60','89.60');

INSERT INTO SuperheroSightingManagementSystemDatabase.Locations (locationId, locationName, locationDescription, addressId, cardinalDirectionLongitude, cardinalDirectionLatitude, latitudinalCoordinate, longitudinalCoordinate) VALUES (3, 'The Natatorium','The Cuyahoga Falls recreation center.','3','N','E','75','10');

INSERT INTO SuperheroSightingManagementSystemDatabase.Locations (locationId, locationName, locationDescription, addressId, cardinalDirectionLongitude, cardinalDirectionLatitude, latitudinalCoordinate, longitudinalCoordinate) VALUES (4, 'Kent State','A university in NE Ohio.','2','S','W','25','15.60');

INSERT INTO SuperheroSightingManagementSystemDatabase.Locations (locationId, locationName, locationDescription, addressId, cardinalDirectionLongitude, cardinalDirectionLatitude, latitudinalCoordinate, longitudinalCoordinate) VALUES (5, 'Hudson Square','A town square in NE Ohio','1','N','E','10.34','0.65');

INSERT INTO Sightings(sightingId, userId, locationId, sightingDescription, sightingDateTime) VALUES (1, 1, 1, 'Stuff Happened.', '1999-12-05 12:12:12');

INSERT INTO Sightings(sightingId, userId, locationId, sightingDescription, sightingDateTime) VALUES (2, 2, 2, 'The good guys lost.', '2004-10-15 17:13:44');

INSERT INTO Sightings(sightingId, userId, locationId, sightingDescription, sightingDateTime) VALUES (3, 3, 3, 'The bad guys won.', '2003-11-29 13:30:24');

INSERT INTO Sightings(sightingId, userId, locationId, sightingDescription, sightingDateTime) VALUES (4, 4, 4, 'False alarm.', '2013-12-13 13:45:19');

INSERT INTO Sightings(sightingId, userId, locationId, sightingDescription, sightingDateTime) VALUES (5, 5, 5, 'I think I saw Batman.', '2009-10-15 14:23:23');

INSERT INTO Sightings(sightingId, userId, locationId, sightingDescription, sightingDateTime) VALUES (6,5,2, 'Lots of buildings leveled.', '2018-01-20 14:23:23');

INSERT INTO Sightings(sightingId, userId, locationId, sightingDescription, sightingDateTime) VALUES (7,4,3, 'Laser beams all over the place.', '2007-11-20 14:23:23');

INSERT INTO Sightings(sightingId, userId, locationId, sightingDescription, sightingDateTime) VALUES (8,3,4, 'Peace accord signed here.', '2017-12-30 14:23:23');

INSERT INTO Sightings(sightingId, userId, locationId, sightingDescription, sightingDateTime) VALUES (9,2,5, 'No one survived the encounter.', '2004-01-07 14:23:23');

INSERT INTO Sightings(sightingId, userId, locationId, sightingDescription, sightingDateTime) VALUES (10,1,1, 'I noped out of there.', '2001-10-11 14:23:23');

INSERT INTO SuperheroSightingManagementSystemDatabase.organizations (organizationId,organizationName,organizationDescription,addressId,moralityTypeId,contactId) VALUES (1,'Lair of Listerine', 'Fights them germs',1,1,1);

INSERT INTO SuperheroSightingManagementSystemDatabase.organizations (organizationId,organizationName,organizationDescription,addressId,moralityTypeId,contactId) VALUES (2,'Team of Tiny Turtle Tots', 'Slowly but surely',2,2,2);

INSERT INTO SuperheroSightingManagementSystemDatabase.organizations (organizationId,organizationName,organizationDescription,addressId,moralityTypeId,contactId) VALUES (3,'Super Serial Spotted Sillies', 'Boinga Boinga',3,3,3);

INSERT INTO SuperheroSightingManagementSystemDatabase.organizations (organizationId,organizationName,organizationDescription,addressId,moralityTypeId,contactId) VALUES (4,'Amalgam of Angry Ardvarks','Dont mess with these guys',4,4,4);

INSERT INTO SuperheroSightingManagementSystemDatabase.organizations (organizationId,organizationName,organizationDescription,addressId,moralityTypeId,contactId) VALUES (5,'Zingy Zebra Zippers','ummm....',5,5,5);

INSERT INTO SuperheroSightingManagementSystemDatabase.organizationspersons (organizationPersonId,personId,organizationId) VALUES (1,1,1);

INSERT INTO SuperheroSightingManagementSystemDatabase.organizationspersons (organizationPersonId,personId,organizationId) VALUES (2,2,2);

INSERT INTO SuperheroSightingManagementSystemDatabase.organizationspersons (organizationPersonId,personId,organizationId) VALUES (3,3,3);

INSERT INTO SuperheroSightingManagementSystemDatabase.organizationspersons (organizationPersonId,personId,organizationId) VALUES (4,4,4);

INSERT INTO SuperheroSightingManagementSystemDatabase.organizationspersons (organizationPersonId,personId,organizationId) VALUES (5,5,5);

INSERT INTO SuperheroSightingManagementSystemDatabase.sightingssuperpersons (sightingSuperpersonId, sightingId, superpersonId) VALUES (1,1,1);

INSERT INTO SuperheroSightingManagementSystemDatabase.sightingssuperpersons (sightingSuperpersonId, sightingId, superpersonId) VALUES (2,2,2);

INSERT INTO SuperheroSightingManagementSystemDatabase.sightingssuperpersons (sightingSuperpersonId, sightingId, superpersonId) VALUES (3,3,3);

INSERT INTO SuperheroSightingManagementSystemDatabase.sightingssuperpersons (sightingSuperpersonId, sightingId, superpersonId) VALUES (4,4,4);

INSERT INTO SuperheroSightingManagementSystemDatabase.sightingssuperpersons (sightingSuperpersonId, sightingId, superpersonId) VALUES (5,5,5);