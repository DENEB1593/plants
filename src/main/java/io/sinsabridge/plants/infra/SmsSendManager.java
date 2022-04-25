package io.sinsabridge.plants.infra;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Component(value = "smsSendManager")
public class SmsSendManager implements SendManger {
    Supplier<String> verificationCodeGenerator = () -> {
        return new Random().ints(0, 10)
                .limit(6)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining());
    };

    /**
     * 문자 발송을 정의한다
     */
    @Override
    public void send(String content) {
        // TODO: 2022-04-25 : 문자 발송 구현
        verificationCodeGenerator.get();
    }

}
