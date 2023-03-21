package com.jsn.tauber.controller;

import com.jsn.tauber.model.entity.LoveCalculator;
import com.jsn.tauber.service.impl.LoveCalculatorServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/love-calculator")
@RequiredArgsConstructor
@Slf4j
public class LoveCalculatorController {

    private final LoveCalculatorServiceImpl loveCalculatorServiceImpl;

    @GetMapping("/calculate")
    public Mono<LoveCalculator> calculateLove(@RequestParam String fname, @RequestParam String sname) {
        log.info("Calculating love between {} and {}", fname, sname);
        return loveCalculatorServiceImpl.calculateLove(fname, sname)
            .doOnNext(loveCalculator -> log.info("Love calculated: {}", loveCalculator));
    }

}
