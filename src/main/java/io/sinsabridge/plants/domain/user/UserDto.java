package io.sinsabridge.plants.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * UserDto
 * CreateUser: 회원추가
 * UpdateUser: 회원정보 수정
 * LoginUser: 로그인 시
 */
public class UserDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoginUser {
        private String id;
        private String password;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateUser {
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

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateUser {
        private String id;
        private String phone;
        private String password;
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
}
