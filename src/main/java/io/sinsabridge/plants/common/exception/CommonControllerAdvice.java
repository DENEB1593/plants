package io.sinsabridge.plants.common.exception;

import io.sinsabridge.plants.common.response.CommonResponse;
import io.sinsabridge.plants.domain.user.exception.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CommonControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = {UserAlreadyExistException.class})
    public CommonResponse businessException(Exception e) {
        return CommonResponse.fail(null, e.getMessage());
    }
}
