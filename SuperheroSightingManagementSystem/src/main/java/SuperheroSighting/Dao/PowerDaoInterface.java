/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Superperson;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface PowerDaoInterface {
    
    public Power createPower(Power power);
    
    public Power readPower(Integer powerId);
    
    public List<Power> listPower(int limit, int offset);
    
    public void updatePower(Power power);
    
    public void deletePower(Integer powerId);
    
    public List<Power> listPowerBySuperperson(Superperson superperson, int limit, int offset);
    
}
