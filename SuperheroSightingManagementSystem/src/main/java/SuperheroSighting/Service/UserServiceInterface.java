/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.User;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface UserServiceInterface {
    
    public User createUser(User user);

    public User readUser(int userId);
    
    public List<User> listUser(int limit, int offset);

    public List<User> listUserByPerson(Person person, int limit, int offset);
 
    public List<User> listUserByPerson(int personId, int limit, int offset);
    
    public void updateUser(User user);

    public void deleteUser(User user) throws SuperheroSightingServiceException;
    
}
