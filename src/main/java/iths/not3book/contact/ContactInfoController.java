package iths.not3book.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contactinfo")
public class ContactInfoController {

    private final ContactInfoService contactInfoService;

    @Autowired
    public ContactInfoController(ContactInfoService contactInfoService) {
        this.contactInfoService = contactInfoService;
    }

    @GetMapping
    public List<ContactInfo> getContactInformation() {
        return contactInfoService.getContactInformation();
    }
    @GetMapping(path = {"{contactInfoId}"})
    public ContactInfo getContactInformationById(@PathVariable("contactInfoId") Long authorId) {
        return contactInfoService.getContactInformation(authorId);
    }
    @PostMapping
    public void addNewContactInformation(@RequestBody ContactInfo contactInfo) {
        contactInfoService.addContactInformation(contactInfo);
    }
    @DeleteMapping(path = "{contactInfoId}")
    public void removeContactInfo(@PathVariable("contactInfoId") Long contactInfoId) {
        contactInfoService.removeContactInformation(contactInfoId);
    }

    @PutMapping(path = "{contactInfoId}")
    public void updateName(
            @PathVariable("contactInfoId") Long contactInfoId,
            @RequestParam String firstName,
            @RequestParam String lastName) {
        contactInfoService.updateName(contactInfoId, firstName, lastName);
    }
}
