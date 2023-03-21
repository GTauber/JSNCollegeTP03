package com.jsn.tauber.service;

import com.jsn.tauber.model.entity.LoveCalculator;
import reactor.core.publisher.Mono;

public interface LoveCalculatorService {

    Mono<LoveCalculator> calculateLove(String fname, String sname);

}
