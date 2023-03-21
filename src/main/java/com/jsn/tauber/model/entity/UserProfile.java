package com.jsn.tauber.model.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("user_profile")
public class UserProfile {

    @Id
    private Long id;

    @Version
    private Integer version;
    private String name;

    private String email;

    private String tel;

    @Transient
    private Address address;
}
