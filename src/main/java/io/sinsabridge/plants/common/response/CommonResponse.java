package io.sinsabridge.plants.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

/**
 *  공통 응답 객체
 *  1. 상태
 *  2. 데이터
 *  3. 메세지
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private Status status;
    private T data;
    private String message;

    /**
     * 성공 시 응답 설정
     */
    public static <T> CommonResponse<T> success(T data) {
        return success(data, Strings.EMPTY);
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        return (CommonResponse<T>) CommonResponse.builder()
                .status(Status.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    /**
     * 실패 시 응답 설정
     */

    public static <T> CommonResponse<T> fail(T data) {
        return fail(data, Strings.EMPTY);
    }

    public static <T> CommonResponse<T> fail(T data, String message) {
        return (CommonResponse<T>) CommonResponse.builder()
                .status(Status.FAIL)
                .data(data)
                .message(message)
                .build();
    }

    @Getter
    public enum Status {
        SUCCESS, FAIL
    }
}
