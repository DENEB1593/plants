package io.sinsabridge.plants.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

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

        @NotBlank(message = "아이디는 필수입니다")
        private String id;

        @NotBlank(message = "비밀번호는 필수입니다")
        private String password;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateUser {

        @NotBlank(message = "아이디는 필수입니다")
        private String id;

        @NotBlank(message = "비밀번호는 필수입니다")
        private String password;

        @NotBlank(message = "휴대번호는 필수입니다")
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
