package iths.not3book.subscriber;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "subscriber")
public class SubscriberController {

    private final SubscriberService subscriberService;

    @Autowired
    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping
    public List<Subscriber> getSubscribers() {
        return subscriberService.getSubscribers();
    }
    @PostMapping
    public void registerSubscriber(@RequestBody Subscriber subscriber) {
        subscriberService.addSubscriber(subscriber);
    }
}
