package com.jsn.tauber.controller;

import com.jsn.tauber.model.entity.UserProfile;
import com.jsn.tauber.service.impl.UserProfileServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@RestController
public class UserProfileCotroller {
    private final UserProfileServiceImpl userProfileService;

    @PostMapping("/register")
    public ResponseEntity<Mono<UserProfile>> register(@RequestBody UserProfile userProfile) {
        log.info("Registering user {}", userProfile);
        return ResponseEntity.ok(userProfileService.register(userProfile));
    }

}
