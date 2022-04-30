package io.sinsabridge.plants.infra.notification.sms;

import com.google.common.base.Strings;
import io.sinsabridge.plants.domain.user.VerifyDto;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.annotation.Nullable;

/**
 * 문자 요청
 * https://smartsms.aligo.in/smsapi.html - 알리고문자API
 */
@NoArgsConstructor
public class SmsRequest {
    //
    private String key;         // 인증용 API Key
    private String userId;      // 사용자id
    private String sender;      // 발신자 전화번호 (최대 16bytes)
    private String receiver;    // 수신자 전화번호 - 컴마(,)분기 입력으로 최대 1천명
    private String msg;         // 문자내용

    @Builder
    public SmsRequest(SmsProperties prop,
                      VerifyDto verifyDto) {
        Assert.notNull(prop, "sms 설정값을 읽어오지 못했습니다");
        if(Strings.isNullOrEmpty(verifyDto.getPhone())) throw new IllegalArgumentException("문자 수신자 정보가 없습니다");

        this.key = prop.getKey();
        this.userId = prop.getUserId();
        this.sender = prop.getSender();
        this.receiver = verifyDto.getPhone();
        this.msg = verifyDto.getMsg();
    }
}
