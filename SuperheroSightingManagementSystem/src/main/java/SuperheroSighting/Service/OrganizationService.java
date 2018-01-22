/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperheroSighting.Service;


import SuperheroSighting.Dao.OrganizationDaoInterface;
import SuperheroSighting.Dto.Address;
import SuperheroSighting.Dto.Contact;
import SuperheroSighting.Dto.MoralityType;
import SuperheroSighting.Dto.Organization;
import SuperheroSighting.Dto.Person;
import SuperheroSighting.Dto.Superperson;
import SuperheroSighting.ViewModel.OrganizationViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class OrganizationService implements OrganizationServiceInterface {

    OrganizationDaoInterface organizationDao;
    MoralityTypeServiceInterface moralityTypeService;
    PersonServiceInterface personService;
    SuperpersonServiceInterface superpersonService;
    ContactServiceInterface contactService;
    AddressServiceInterface addressService;
    OrganizationPersonServiceInterface organizationPersonService;
    
    public OrganizationService(OrganizationDaoInterface organizationDao) {
        this.organizationDao = organizationDao;
    }
    
    public void setMoralityTypeService(MoralityTypeServiceInterface moralityTypeService) {
        this.moralityTypeService = moralityTypeService;
    }
    
    public void setOrganizationPersonService(OrganizationPersonServiceInterface organizationPersonServiceInterface) {
        this.organizationPersonService = organizationPersonService;
    }    
    
    public void setPersonService(PersonServiceInterface personService) {
        this.personService = personService;
    }
    
    public void setSuperpersonService(SuperpersonServiceInterface superpersonService) {
        this.superpersonService = superpersonService;
    }
    
    public void setContactService(ContactServiceInterface contactService) {
        this.contactService = contactService;
    }
    
    public void setAddressService(AddressServiceInterface addressService) {
        this.addressService = addressService;
    }

    @Override
    public Organization createOrganization(Organization organization) {
        return organizationDao.createOrganization(organization);
    }

    @Override
    public Organization readOrganization(int organizationId) {
        return organizationDao.readOrganization(organizationId);
    }

    @Override
    public List<Organization> listOrganization(int limit, int offset) {
        return organizationDao.listOrganization(limit, offset);
    }

    @Override
    public List<Organization> listOrganizationByMoralityType(MoralityType moralityType, int limit, int offset) {
        return organizationDao.listOrganizationByMoralityType(moralityType, limit, offset);
    }

    @Override
    public List<Organization> listOrganizationByMoralityType(int moralityTypeId, int limit, int offset) {
        return organizationDao.listOrganizationByMoralityType(moralityTypeService.readMoralityType(moralityTypeId), limit, offset);
    }
    
    @Override
    public List<Organization> listOrganizationByPerson(Person person, int limit, int offset) {
        return organizationDao.listOrganizationByPerson(person, limit, offset);
    }
    
    @Override
    public List<Organization> listOrganizationByPerson(int PersonId, int limit, int offset) {
        return organizationDao.listOrganizationByPerson(personService.readPerson(PersonId), limit, offset);
    }

    @Override
    public List<Organization> listOrganizationBySuperPerson(Superperson superperson, int limit, int offset) {
        return organizationDao.listOrganizationBySuperperson(superperson, limit, offset);
    }
    
    @Override
    public List<Organization> listOrganizationBySuperperson(int superpersonId, int limit, int offset) {
        return organizationDao.listOrganizationBySuperperson(superpersonService.readSuperperson(superpersonId), limit, offset);
    }

    @Override
    public List<Organization> listOrganizationByContact(Contact contact, int limit, int offset) {
        return organizationDao.listOrganizationByContact(contact, limit, offset);
    }
    
    @Override
    public List<Organization> listOrganizationByContact(int contactId, int limit, int offset) {
        return organizationDao.listOrganizationByContact(contactService.readContact(contactId), limit, offset);
    }
    
    @Override
    public List<Organization> listOrganizationByAddress(Address address, int limit, int offset) {
        return organizationDao.listOrganizationByAddress(address, limit, offset);
    }
    
    @Override
    public List<Organization> listOrganizationByAddress(int addressId, int limit, int offset) {
        return organizationDao.listOrganizationByAddress(addressService.readAddress(addressId), limit, offset);
    }

    @Override
    public void updateOrganization(Organization organization) {
        organizationDao.updateOrganization(organization);
    }

    @Override
    public void deleteOrganization(Organization organization) {
        organizationPersonService.deleteOrganizationPersonByOrganization(organization);
        organizationDao.deleteOrganization(organization.getOrganizationId());
    }

    @Override
    public OrganizationViewModel organizationViewModel(int limit, int offset) {
        List<Organization> organization = listOrganization(limit, offset);
        OrganizationViewModel ovm = new OrganizationViewModel();
        ovm.setOrganizationList(organization);
        return ovm;
    }
    
    
}
