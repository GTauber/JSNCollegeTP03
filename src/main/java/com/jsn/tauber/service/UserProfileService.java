package com.jsn.tauber.service;

import com.jsn.tauber.model.entity.UserProfile;
import reactor.core.publisher.Mono;

public interface UserProfileService {

    Mono<UserProfile> register(UserProfile userProfile);
}
