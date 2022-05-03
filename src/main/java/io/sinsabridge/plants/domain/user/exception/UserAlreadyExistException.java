package io.sinsabridge.plants.domain.user.exception;

public class UserAlreadyExistException extends RuntimeException {
    private static final String MESSAGE = "해당 아이디가 이미 존재합니다.";

    public UserAlreadyExistException() {
        super(MESSAGE);
    }

    public UserAlreadyExistException(String message) {
        super(message);
    }

    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
