/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.SuperpersonPower;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface SuperpersonPowerServiceInterface {
    
    public SuperpersonPower createSuperpersonPower(SuperpersonPower superpersonPower);
    
    public SuperpersonPower readSuperpersonPower(SuperpersonPower superpersonPower);
    
    public List<SuperpersonPower> listSuperpersonPower(int limit, int offset);    
 
    public List<SuperpersonPower> listSuperpersonPowerBySuperperson(Superperson superperson, int limit, int offset);

    public List<SuperpersonPower> listSuperpersonPowerBySuperperson(int superpersonId, int limit, int offset);
    
    public List<SuperpersonPower> listSuperpersonPowerByPower(Power power, int limit, int offset);

    public List<SuperpersonPower> listSuperpersonPowerByPower(int powerId, int limit, int offset);
    
    public void updateSuperpersonPower(SuperpersonPower superpersonPower);

    public void deleteSuperpersonPower(SuperpersonPower superpersonPower);

    public void deleteSuperpersonPowerBySuperperson(Superperson superperson);

    public void deleteSuperpersonPowerByPower(Power power);
    
}
