package io.sinsabridge.plants.domain.user.exception;

public class UserNotFoundException extends RuntimeException {

    private static final String MESSAGE = "회원 조회에 실패하였습니다";

    public UserNotFoundException() {
        super(MESSAGE);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
