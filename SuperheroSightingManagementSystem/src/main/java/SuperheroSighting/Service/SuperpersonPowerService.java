/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dao.SuperpersonPowerDaoInterface;
import SuperheroSighting.Dto.Power;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.Dto.SuperpersonPower;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class SuperpersonPowerService implements SuperpersonPowerServiceInterface {

    SuperpersonPowerDaoInterface superpersonPowerDao;
    SuperpersonServiceInterface superpersonService;
    PowerServiceInterface powerService;

    public SuperpersonPowerService(SuperpersonPowerDaoInterface superpersonPowerDao) {
        this.superpersonPowerDao = superpersonPowerDao;
    }
    
    public void setSuperpersonService(SuperpersonServiceInterface superpersonService) {
        this.superpersonService = superpersonService;
    }

    public void setPowerService(PowerServiceInterface powerService) {
        this.powerService = powerService;
    }
    
    @Override
    public SuperpersonPower createSuperpersonPower(SuperpersonPower superpersonPower) {
        return superpersonPowerDao.createSuperpersonPower(superpersonPower);
    }

    @Override
    public SuperpersonPower readSuperpersonPower(SuperpersonPower superpersonPower) {
        return superpersonPowerDao.readSuperpersonPowerById(superpersonPower.getSuperpersonPowerId());
    }

    @Override
    public List<SuperpersonPower> listSuperpersonPower(int limit, int offset) {
        return superpersonPowerDao.listSuperpersonPower(limit, offset);
    }

    @Override
    public List<SuperpersonPower> listSuperpersonPowerBySuperperson(Superperson superperson, int limit, int offset) {
        return superpersonPowerDao.listSuperpersonPowerBySuperperson(superperson, limit, offset);
    }
    
    @Override
    public List<SuperpersonPower> listSuperpersonPowerBySuperperson(int superpersonId, int limit, int offset) {
        return superpersonPowerDao.listSuperpersonPowerBySuperperson(superpersonService.readSuperperson(superpersonId), limit, offset);
    }

    @Override
    public List<SuperpersonPower> listSuperpersonPowerByPower(Power power, int limit, int offset) {
        return superpersonPowerDao.listSuperpersonPowerByPower(power, limit, offset);
    }
    
    @Override
    public List<SuperpersonPower> listSuperpersonPowerByPower(int powerId, int limit, int offset) {
        return superpersonPowerDao.listSuperpersonPowerByPower(powerService.readPower(powerId), limit, offset);
    }

    @Override
    public void updateSuperpersonPower(SuperpersonPower superersonPower) {
        superpersonPowerDao.updateSuperpersonPower(superersonPower);
    }

    @Override
    public void deleteSuperpersonPower(SuperpersonPower superpersonPower) {
        superpersonPowerDao.deleteSuperpersonPower(superpersonPower.getSuperpersonPowerId());
    }

    @Override
    public void deleteSuperpersonPowerBySuperperson(Superperson superperson) {
        superpersonPowerDao.deleteSuperpersonPowerBySuperperson(superperson);
    }

    @Override
    public void deleteSuperpersonPowerByPower(Power power) {
        superpersonPowerDao.deleteSuperpersonPowerByPower(power);
    }
 
}
