/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dao.MoralityTypeDaoInterface;
import SuperheroSighting.Dto.MoralityType;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Superperson;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class MoralityTypeService implements MoralityTypeServiceInterface {

    MoralityTypeDaoInterface moralityTypeDao;
    OrganizationServiceInterface organizationService;
    SuperpersonServiceInterface superpersonService;

    public MoralityTypeService(MoralityTypeDaoInterface moralityTypeDao) {
        this.moralityTypeDao = moralityTypeDao;
    }    
    
    public void setOrganizationService(OrganizationServiceInterface organizationService) {
        this.organizationService = organizationService;
    }
    
    public void setSuperpersonService(SuperpersonServiceInterface superpersonService) {
        this.superpersonService = superpersonService;
    }
    
    @Override
    public MoralityType createMoralityType(MoralityType moralityType) {
        return moralityTypeDao.createMoralityType(moralityType);
    }

    @Override
    public MoralityType readMoralityType(int moralityTypeId) {
        return moralityTypeDao.readMoralityType(moralityTypeId);
    }

    @Override
    public MoralityType readMoralityType(MoralityType moralityType) {
        return moralityTypeDao.readMoralityType(moralityType.getMoralityTypeId());
    }

    @Override
    public List<MoralityType> listMoralityType(int limit, int offset) {
        return moralityTypeDao.listMoralityType(limit, offset);
    }

    @Override
    public void updateMoralityType(MoralityType moralityType) {
        moralityTypeDao.updateMoralityType(moralityType);
    }

    @Override
    public void deleteMoralityType(MoralityType moralityType) throws SuperheroSightingServiceException {
        
        List<Organization> organizationList = organizationService.listOrganizationByMoralityType(moralityType, Integer.MAX_VALUE, 0);
        List<Superperson> superpersonList = superpersonService.listSuperpersonByMoralityType(moralityType, Integer.MAX_VALUE, 0);
        
        if(organizationList.size() > 0) {
            throw new SuperheroSightingServiceException("Warning: this morality is assigned to an organization, the organization must be deleted first.");
        }   else if (superpersonList.size() > 0) {
            throw new SuperheroSightingServiceException("Warning: this morality is assigned to a superperson, you must delete the superperson first.");
        }   else {
            moralityTypeDao.deleteMoralityType(moralityType.getMoralityTypeId());
        }       
    }
    
}
