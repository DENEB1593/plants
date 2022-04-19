package io.sinsabridge.plants.domain.user;

import lombok.Getter;

@Getter
public class UserInfo {

    private Long userNo;

    private String id;

    private String email;

    private String phone;

    public UserInfo(User user) {
        this.userNo = user.getUserNo();
        this.id = user.getId();
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }
}
