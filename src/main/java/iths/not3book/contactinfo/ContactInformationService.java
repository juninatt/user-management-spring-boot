package iths.not3book.contactinfo;

import iths.not3book.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service class of {@link ContactInformation}
 */
@Service
public class ContactInformationService {

    private final ContactInformationRepository contactInformationRepository;

    /**
     * Class constructor.
     * @see ContactInformationRepository
     */
    @Autowired
    public ContactInformationService(ContactInformationRepository contactInformationRepository) {
        this.contactInformationRepository = contactInformationRepository;
    }

    /**
     * Method that return a list of all instances of ContactInformation currently stored in database.
     */
    public List<ContactInformation> getContactInformation() {
        return contactInformationRepository.findAll();
    }

    /**
     * Method that returns ContactInformation with matching id.
     */
    public ContactInformation getContactInformation(Long contactInfoId) {
        return contactInformationRepository.findById(contactInfoId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact information", "id", String.valueOf(contactInfoId)));
    }

    /**
     * Method that saves the ContactInformation given as parameter to the database.
     */
    public void addContactInformation(ContactInformation contactInformation) {
        contactInformationRepository.save(contactInformation);
    }

    /**
     * Method that removes ContactInformation with matching id from database.
     */
    public void removeContactInformation(Long contactInfoId) {
        ContactInformation contactInformation = contactInformationRepository.findById(contactInfoId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact information", "id", String.valueOf(contactInfoId)));
        contactInformationRepository.delete(contactInformation);
    }

    /**
     * Method that updates first- and last name in ContactInformation with matching id.
     */
    @Transactional
    public void updateName(Long contactInfoId,
                           String firstName,
                           String lastName) {
        ContactInformation contactInformation = contactInformationRepository.findById(contactInfoId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact information", "id", String.valueOf(contactInfoId)));
        if (firstName != null &&
                lastName != null &&
                firstName.length() > 0 &&
                lastName.length() > 0) {
            contactInformation.setFirstName(firstName);
            contactInformation.setLastName(lastName);
        }
    }
}
