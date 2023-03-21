package com.jsn.tauber.repository;

import com.jsn.tauber.model.entity.UserProfile;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends ReactiveCrudRepository<UserProfile, String> {

}
