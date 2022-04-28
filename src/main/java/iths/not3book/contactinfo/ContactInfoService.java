package iths.not3book.contactinfo;

import iths.not3book.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContactInfoService {
    
    private final ContactInfoRepository contactInfoRepository;

    @Autowired
    public ContactInfoService(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    public List<ContactInfo> getContactInformation() {
        return contactInfoRepository.findAll();
    }
    public ContactInfo getContactInformation(Long contactInfoId) {
        return contactInfoRepository.findById(contactInfoId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact information", "id", String.valueOf(contactInfoId)));
    }

    public void addContactInformation(ContactInfo contactInfo) {
        contactInfoRepository.save(contactInfo);
    }
    public void removeContactInformation(Long contactInfoId) {
        ContactInfo contactInfo = contactInfoRepository.findById(contactInfoId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact information", "id", String.valueOf(contactInfoId)));
        contactInfoRepository.delete(contactInfo);
    }
    @Transactional
    public void updateName(Long contactInfoId,
                           String firstName,
                           String lastName) {
        ContactInfo contactInfo = contactInfoRepository.findById(contactInfoId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact information", "id", String.valueOf(contactInfoId)));
        if (firstName != null &&
                lastName != null &&
                firstName.length() > 0 &&
                lastName.length() > 0) {
            contactInfo.setFirstName(firstName);
            contactInfo.setLastName(lastName);
        }
    }
}
