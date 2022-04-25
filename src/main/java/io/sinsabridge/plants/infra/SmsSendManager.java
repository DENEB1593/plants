package io.sinsabridge.plants.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component(value = "smsSendManager")
public class SmsSendManager implements SendManger {

    /**
     * 문자 발송을 정의한다
     */
    @Override
    public void send(String content) {
        // TODO: 2022-04-25 : 문자 발송 구현
        final String code = VerificationCodeGenerator.generate();
    }

}
