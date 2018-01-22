/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dao.PowerDaoInterface;
import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Superperson;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class PowerService implements PowerServiceInterface {

    PowerDaoInterface powerDao;
    SuperpersonServiceInterface superpersonService;
    
    public PowerService(PowerDaoInterface powerDao) {
        this.powerDao = powerDao;
    }
    
    public void setSuperpersonService(SuperpersonServiceInterface superpersonService) {
        this.superpersonService = superpersonService;
    }

    @Override
    public Power createPower(Power power) {
        return powerDao.createPower(power);
    }

    @Override
    public Power readPower(int powerId) {
        return powerDao.readPower(powerId);
    }

    @Override
    public List<Power> listPowers(int limit, int offset) {
        return powerDao.listPower(limit, offset);
    }

    @Override
    public List<Power> listPowerBySuperPerson(Superperson superperson, int limit, int offset) {
        return powerDao.listPowerBySuperperson(superperson, limit, offset);
    }
    
    @Override
    public List<Power> listPowerBySuperPerson(int superpersonId, int limit, int offset) {
        return powerDao.listPowerBySuperperson(superpersonService.readSuperperson(superpersonId), limit, offset);
    }
    
    @Override
    public void updatePower(Power power) {
        powerDao.updatePower(power);
    }

    @Override
    public void deletePower(Power power) {
        powerDao.deletePower(power.getPowerId());
    }

}
