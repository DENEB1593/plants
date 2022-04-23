package io.sinsabridge.plants.domain.user;

import lombok.Getter;

@Getter
public class UserInfo {

    private Long userNo;

    private String id;

    private String phone;

    private String likePlants;

    public UserInfo(User user) {
        this.userNo = user.getUserNo();
        this.id = user.getId();
        this.phone = user.getPhone();
        this.likePlants = user.getLikePlants();

    }
}
