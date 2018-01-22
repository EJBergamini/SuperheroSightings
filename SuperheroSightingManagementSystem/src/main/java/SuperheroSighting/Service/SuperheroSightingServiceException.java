/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;

/**
 *
 * @author EJB Laptop
 */
public class SuperheroSightingServiceException extends Exception {
    
    public SuperheroSightingServiceException(String message) {
        super(message);
    }
    
    public SuperheroSightingServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
