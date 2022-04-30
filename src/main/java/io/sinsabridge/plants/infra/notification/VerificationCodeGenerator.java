package io.sinsabridge.plants.infra.notification;


import java.util.Random;
import java.util.stream.Collectors;

public class VerificationCodeGenerator {

    private final static int CODE_SIZE = 5;

    public static String generate() {
        return new Random().ints(0, 10)
                .limit(CODE_SIZE)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
