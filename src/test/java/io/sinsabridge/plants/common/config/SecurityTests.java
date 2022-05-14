package io.sinsabridge.plants.common.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityTests {

    @DisplayName("비밀번호_인코딩_테스트")
    @Test
    public void passwordTest() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        String encodedPassword = passwordEncoder.encode("1234");
        System.out.println(encodedPassword);
    }
}