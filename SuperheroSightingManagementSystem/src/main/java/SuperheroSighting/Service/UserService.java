/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dao.UserDaoInterface;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.Sighting;
import SuperheroSighting.Dto.User;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class UserService implements UserServiceInterface {

    UserDaoInterface userDao;
    
    SightingServiceInterface sightingService;
    PersonServiceInterface personService;

    public UserService(UserDaoInterface userDao) {
        this.userDao = userDao;
    }
    
    public void setSightingService(SightingServiceInterface sightingService) {
        this.sightingService = sightingService;
    }
    
    public void setPersonService(PersonServiceInterface personService) {
        this.personService = personService;
    }
    
    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public User readUser(int userId) {
        return userDao.readUser(userId);
    }

    @Override
    public List<User> listUser(int limit, int offset) {
        return userDao.listUser(limit, offset);
    }

    @Override
    public List<User> listUserByPerson(Person person, int limit, int offset) {
        return userDao.listUserByPerson(person, limit, offset);
    }
    
    @Override
    public List<User> listUserByPerson(int personId, int limit, int offset) {
        return userDao.listUserByPerson(personService.readPerson(personId), limit, offset);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) throws SuperheroSightingServiceException {
        
        List<Sighting> sightingList = sightingService.listSightingByUser(user, Integer.MAX_VALUE, 0);
        
        if(sightingList.size() > 0) {
            throw new SuperheroSightingServiceException("Warning: this user is associated with a sighting, you must delete the sighting first.");
        }   else {
            userDao.deleteUser(user.getUserId());
        }
    }
    
}
