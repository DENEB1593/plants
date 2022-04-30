package io.sinsabridge.plants.infra.notification;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "sms")
@PropertySource(value = "classpath:notification/sms.properties")
public class SmsProperties {
    private String host;
    private String userId;
    private String sender;
    private String key;
    private String title;
}
