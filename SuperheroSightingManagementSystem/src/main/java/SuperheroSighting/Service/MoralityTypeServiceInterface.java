/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

import SuperheroSighting.Dto.MoralityType;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface MoralityTypeServiceInterface {
    
    public MoralityType createMoralityType(MoralityType moralityType);

    public MoralityType readMoralityType(int moralityTypeId);
    
    public MoralityType readMoralityType(MoralityType moralityType);

    public List<MoralityType> listMoralityType(int limit, int offset);

    public void updateMoralityType(MoralityType moralityType);

    public void deleteMoralityType(MoralityType moralityType) throws SuperheroSightingServiceException;
    
}
