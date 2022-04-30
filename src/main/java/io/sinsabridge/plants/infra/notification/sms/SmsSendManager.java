package io.sinsabridge.plants.infra.notification.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.sinsabridge.plants.domain.user.VerifyDto;
import io.sinsabridge.plants.infra.notification.SendManger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component(value = "smsSendManager")
@RequiredArgsConstructor
public class SmsSendManager implements SendManger {

    private final SmsProperties smsProperties;
    private static RestTemplate restTemplate = new RestTemplate();

    /**
     * 문자 발송 수행
     * @return
     */
    @Override
    public ResponseEntity<String> send(VerifyDto verifyDto) {
        final String SMS_REQUEST_URL = smsProperties.getHost();

        SmsRequest requestBody = new SmsRequest(smsProperties, verifyDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        HttpEntity entity = new HttpEntity(requestBody, headers);
        return restTemplate.exchange(SMS_REQUEST_URL, HttpMethod.POST, entity, String.class);
    }

}
