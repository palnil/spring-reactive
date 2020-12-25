package com.yoshallc.spring.reactive;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.time.Duration;

@RestController
public class GreetingController {

    @GetMapping(value = "/flux")
    public Flux<Integer> getNumber(){

        return Flux.just(1,2,3,4,5)
                .delayElements(Duration.ofMillis(1500))
                   .log();
    }

    @GetMapping(value = "/fluxstream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Long> getNumberStream(){

        return Flux.interval(Duration.ofSeconds(1))
                .log();
    }
}
