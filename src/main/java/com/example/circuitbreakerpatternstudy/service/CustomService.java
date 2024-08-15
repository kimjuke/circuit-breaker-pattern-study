package com.example.circuitbreakerpatternstudy.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomService {

    @CircuitBreaker(name = "customCircuitBreaker", fallbackMethod = "fallback")
    public String fail() {
        throw new RuntimeException("fail");
    }

    @CircuitBreaker(name = "customCircuitBreaker", fallbackMethod = "fallback")
    public String slowCall() throws InterruptedException {

        long start = System.currentTimeMillis();
        Thread.sleep(5000L);
        long end = System.currentTimeMillis();
        log.info("call time {} ms", end - start);

        return "success";
    }

    @CircuitBreaker(name = "customCircuitBreaker", fallbackMethod = "fallback")
    public String success(){
        return "success";
    }

    public String fallback(Throwable throwable) {
        log.error("fallback method", throwable);
        return "CIRCUIT OPEN STATUS";
    }




}
