package iths.not3book.subscriber;

import iths.not3book.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubscriberService {

    private final SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public List<Subscriber> getSubscribers() {
        return subscriberRepository.findAll();
    }

    public Subscriber getSubscriber(Long subscriberId) {
        return subscriberRepository.findById(subscriberId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscriber", "id", subscriberId));
    }

    public void addSubscriber(Subscriber subscriber) {
        subscriberRepository.save(subscriber);
    }

    public void removeSubscriber(Long subscriberId) {
        Subscriber subscriber = subscriberRepository.findById(subscriberId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscriber", "id", subscriberId));
        subscriberRepository.delete(subscriber);
    }

    @Transactional
    public void updateUserName(Long subscriberId, String userName) {
        Subscriber subscriber = subscriberRepository.findById(subscriberId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscriber", "id", subscriberId));
        if ((userName != null) && (userName.length() > 0)) {
            subscriber.setUserName(userName);
        }
    }
}
