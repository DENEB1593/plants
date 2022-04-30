package io.sinsabridge.plants.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.sinsabridge.plants.infra.notification.VerificationCodeGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 문자인증 관련 정보
 */
@Setter
@Getter
public class VerifyDto {
    private String phone;

    @JsonIgnore
    private String msg;

    private static final String MESSAGE_FORMAT = "인증번호 [%s]";

    public void setVerifyMessage() {
        this.msg = String.format(MESSAGE_FORMAT, VerificationCodeGenerator.generate());
    }

}
