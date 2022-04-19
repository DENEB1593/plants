package io.sinsabridge.plants;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactTestController {

    @GetMapping("/hello")
    public String hello() {
        return "리액트연동 테스트";
    }

}
