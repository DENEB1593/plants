package io.sinsabridge.plants.infra;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Collectors;

@Component
public class VerificationCodeGenerator {

    private final int CODE_SIZE = 5;

    public static String generate() {
        return new Random().ints(0, 10)
                .limit(5)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
