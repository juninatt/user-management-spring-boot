package iths.not3book.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
