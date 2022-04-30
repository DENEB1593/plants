package io.sinsabridge.plants.infra.notification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VerificationCodeGeneratorTest {

    private final int CODE_SIZE = 5;

    @DisplayName("인증번호_생성_테스트")
    @Test
    public void generateCodeTest() {
        String code = VerificationCodeGenerator.generate();
        Assertions.assertEquals(CODE_SIZE, code.length());
    }
}