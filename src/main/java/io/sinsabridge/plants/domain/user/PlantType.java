package io.sinsabridge.plants.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PlantType {
    FLOWER("꽃", 1000),
    ROSE("장미", 1000),
    TREE("나무", 1000);

    private final String desc;
    private final int price;
}
