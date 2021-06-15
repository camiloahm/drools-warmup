package com.warmup.drools.demo.api;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private final KieContainer kieContainer;

    public BookingController(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @PostMapping("/booking")
    private Booking getDiscountPercent(@RequestBody Booking bookingObject) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(bookingObject);
        kieSession.fireAllRules();
        kieSession.dispose();
        return bookingObject;
    }
}