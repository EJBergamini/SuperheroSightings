/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Dao;

import SuperheroSighting.Dto.MoralityType;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public interface MoralityTypeDaoInterface {
    
    public MoralityType createMoralityType(MoralityType moralityType);
    
    public MoralityType readMoralityType(Integer moralityTypeId);
    
    public List<MoralityType> listMoralityType(int limit, int offset);
    
    public void updateMoralityType(MoralityType moralityType);
    
    public void deleteMoralityType(Integer moralityTypeId);
    
}
