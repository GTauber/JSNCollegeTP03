package com.jsn.tauber.service.impl;

import com.jsn.tauber.model.entity.LoveCalculator;
import com.jsn.tauber.service.LoveCalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class LoveCalculatorServiceImpl implements LoveCalculatorService {

    private final WebClient webClient;

    public LoveCalculatorServiceImpl(@Qualifier("amorWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<LoveCalculator> calculateLove(String sname, String fname) {

        return webClient.get()
            .uri(uriBuilder -> uriBuilder.path("/getPercentage")
                .queryParam("fname", fname)
                .queryParam("sname", sname)
                .build())
            .retrieve()
            .bodyToMono(LoveCalculator.class).log();
    }
}
