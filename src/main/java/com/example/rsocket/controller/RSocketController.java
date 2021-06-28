package com.example.rsocket.controller;

import com.example.rsocket.model.GreetingRequest;
import com.example.rsocket.model.GreetingResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@RestController
@Log4j2
public class RSocketController {

    @MessageMapping("greet")
    public Mono<GreetingResponse> greet(GreetingRequest request) {
        return Mono.just(new GreetingResponse("Hello " + request.getName() + " @ " + Instant.now()));
    }

    @MessageMapping("my-request-response")
    public GreetingResponse greetingResponse(GreetingRequest request) {
        log.info("Data of GreetingRequest {}",request.getName());
        return new GreetingResponse("Hello from server is you data :" + request.getName());
    }

    @MessageMapping("tweets.by.author")
    public Flux<GreetingResponse> getByAuthor(GreetingRequest request) {
        log.info("Data of GreetingRequest {}",request.getName());
        return Flux.just(new GreetingResponse("Hello from server is you data :" + request.getName()));
    }
}
