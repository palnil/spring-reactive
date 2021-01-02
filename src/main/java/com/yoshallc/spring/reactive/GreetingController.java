package com.yoshallc.spring.reactive;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@Log4j2
public class GreetingController {

    @GetMapping(value = "/flux")
    public Flux<Integer> getNumber() {

        log.info("/flux end point");
        return Flux.just(1, 2, 3, 4, 5)
                .delayElements(Duration.ofMillis(100))
                .log();
    }

    @GetMapping(value = "/fluxstream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Long> getNumberStream() {

        log.info("/fluxstream end point");
        return Flux.interval(Duration.ofMillis(100))
                .log();
    }

    @GetMapping(value = "/customers", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Customer> getCustomers() {

        log.info("/customers end point");
        return Flux.just(new Customer("Nilesh Patel", 41),
                new Customer("Palak Patel", 41),
                new Customer("Swina Patel", 16),
                new Customer("Stuti Patel", 12))
                .log();

    }

}
