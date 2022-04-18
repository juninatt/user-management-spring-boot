package iths.not3book.subscriber;

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

    public void addSubscriber(Subscriber subscriber) {
        subscriberRepository.save(subscriber);
    }

    public void removeSubscriber(Long subscriberId) {
        subscriberRepository.deleteById(subscriberId);
    }

    @Transactional
    public void updateUserName(Long subscriberId, String userName) {
        Subscriber subscriber = subscriberRepository.findById(subscriberId)
                .orElseThrow(() -> new IllegalStateException(
                        "Subscriber with id " + subscriberId + " does not exist"
                ));
        if ((userName != null) && (userName.length() > 0)) {
            subscriber.setUserName(userName);
        }
    }
}
