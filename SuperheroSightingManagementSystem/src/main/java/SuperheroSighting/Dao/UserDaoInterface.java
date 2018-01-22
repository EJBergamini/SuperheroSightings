/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.User;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface UserDaoInterface {
    
    public User createUser(User user);
    
    public User readUser(Integer userId);
    
    public List<User> listUser(int limit, int offset);
    
    public void updateUser(User user);
    
    public void deleteUser(Integer userId);
    
    public List<User> listUserByPerson(Person person, int limit, int offset);
    
}
