package io.sinsabridge.plants.infra.notification;

import io.sinsabridge.plants.domain.user.VerifyDto;
import org.springframework.http.ResponseEntity;

public interface SendManger {
    public ResponseEntity<String> send(VerifyDto verifyDto);
}
