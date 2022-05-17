package iths.not3book.contactinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for {@link ContactInformation}
 */
@RestController
@RequestMapping(path = "/contactinfo")
public class ContactInformationController {

    /**
     * {@link ContactInformationService}
     */
    private final ContactInformationService contactInformationService;

    /**
     * Constructor initializing only field.
     * @see ContactInformationService
     */
    @Autowired
    public ContactInformationController(ContactInformationService contactInformationService) {
        this.contactInformationService = contactInformationService;
    }

    /**
     * Method returning a list containing all ContactInformation currently stored in database.
     */
    @GetMapping
    public List<ContactInformation> getContactInformation() {
        return contactInformationService.getContactInformation();
    }

    /**
     * Method returning contact-ContactInformation with matching id.
     */
    @GetMapping(path = {"{contactInfoId}"})
    public ContactInformation getContactInformationById(@PathVariable("contactInfoId") Long authorId) {
        return contactInformationService.getContactInformation(authorId);
    }

    /**
     * Method that creates new ContactInformation.
     */
    @PostMapping
    public void addNewContactInformation(@RequestBody ContactInformation contactInformation) {
        contactInformationService.addContactInformation(contactInformation);
    }

    /**
     * Method that removes ContactInformation with matching id.
     */
    @DeleteMapping(path = "{contactInfoId}")
    public void removeContactInfo(@PathVariable("contactInfoId") Long contactInfoId) {
        contactInformationService.removeContactInformation(contactInfoId);
    }

    /**
     * Method that updates user first- and last name in ContactInformation with matching id.
     */
    @PutMapping(path = "{contactInfoId}")
    public void updateName(
            @PathVariable("contactInfoId") Long contactInfoId,
            @RequestParam String firstName,
            @RequestParam String lastName) {
        contactInformationService.updateName(contactInfoId, firstName, lastName);
    }
}
