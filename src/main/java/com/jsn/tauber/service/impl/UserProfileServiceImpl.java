package com.jsn.tauber.service.impl;

import com.jsn.tauber.model.entity.Address;
import com.jsn.tauber.model.entity.UserProfile;
import com.jsn.tauber.repository.UserProfileRepository;
import com.jsn.tauber.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final WebClient viaCepWebClient;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository, @Qualifier("viaCepWebClient") WebClient viaCepWebClient) {
        this.userProfileRepository = userProfileRepository;
        this.viaCepWebClient = viaCepWebClient;
    }

    @Override
    public Mono<UserProfile> register(UserProfile userProfile) {
        return this.findAddress(userProfile.getAddress().getCep())
            .flatMap(address -> {
                log.info("Address found: {}", address);
                userProfile.setAddress(address);
                log.info("Saving user profile: {}", userProfile);
                return userProfileRepository.save(userProfile);
            });
    }

    private Mono<Address> findAddress(String cep) {
        return viaCepWebClient.get()
            .uri(uriBuilder -> uriBuilder.path("/" + cep + "/json")
                .build())
            .retrieve()
            .bodyToMono(Address.class).log();
    }
}
