package io.sinsabridge.plants.domain.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String id;

    private String password;

    private String email;

    private String phone;

    public User toEntity() {
        return User.builder()
                .id(id)
                .password(password)
                .email(email)
                .phone(phone)
                .build();
    }
}
