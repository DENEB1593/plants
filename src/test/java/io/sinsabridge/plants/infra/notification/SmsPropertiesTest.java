package io.sinsabridge.plants.infra.notification;

import io.sinsabridge.plants.infra.notification.sms.SmsProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SmsPropertiesTest {

    private static final String HOST = "https://apis.aligo.in/send/";
    private static final String USER_ID = "sinsabridge";
    private static final String SENDER = "01028381593";
    private static final String KEY = "ttjtewy9mecn6nwldn93kswfcdw9jpup";
    private static final String TITLE = "[Plants] 문자인증";

    @Autowired
    private SmsProperties smsProperties;

    @DisplayName("문자_설정값_읽기_테스트")
    @Test
    public void readSmsPropertiesTest() {
        Assertions.assertAll(
                () -> assertEquals(HOST, smsProperties.getHost()),
                () -> assertEquals(USER_ID, smsProperties.getUserId()),
                () -> assertEquals(SENDER, smsProperties.getSender()),
                () -> assertEquals(KEY, smsProperties.getKey()),
                () -> assertEquals(TITLE, smsProperties.getTitle())
        );
    }
}