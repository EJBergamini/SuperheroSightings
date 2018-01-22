/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.SuperpersonPower;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface SuperpersonPowerDaoInterface {
    
    public SuperpersonPower createSuperpersonPower(SuperpersonPower superpersonPower);
    
    public SuperpersonPower readSuperpersonPowerById(Integer superpersonPowerId);
    
    public List<SuperpersonPower> listSuperpersonPower(int limit, int offset);
    
    public void updateSuperpersonPower(SuperpersonPower superpersonPower);
    
    public void deleteSuperpersonPower(Integer superpersonPowerId);
    
    public List<SuperpersonPower> listSuperpersonPowerByPower(Power power, int limit, int offset);
    
    public List<SuperpersonPower> listSuperpersonPowerBySuperperson(Superperson superperson, int limit, int offset);
    
    public void deleteSuperpersonPowerByPower(Power power);
    
    public void deleteSuperpersonPowerBySuperperson(Superperson superperson);
    
}
