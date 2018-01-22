/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Superperson;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface PowerServiceInterface {
    
    public Power createPower(Power power);

    public Power readPower(int powerId);

    public List<Power> listPowers(int limit, int offset);

    public List<Power> listPowerBySuperPerson(Superperson superperson, int limit, int offset);
 
    public List<Power> listPowerBySuperPerson(int superpersonId, int limit, int offset);
    
    public void updatePower(Power power);

    public void deletePower(Power power);
    
}
