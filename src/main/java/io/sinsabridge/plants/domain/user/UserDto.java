package io.sinsabridge.plants.domain.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String id;

    private String password;

    private String phone;

    private String likePlants;

    public User toEntity() {
        return User.builder()
                .id(id)
                .password(password)
                .phone(phone)
                .likePlants(likePlants)
                .build();
    }
}
