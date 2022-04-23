package io.sinsabridge.plants.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 식물유형
 */
@AllArgsConstructor
@Getter
public enum PlantType {

    FOLIAGE( "관엽식물"),
    FLOWER("꽃"),
    TREE("나무"),
    HERB("허브"),
    SEED("씨앗"),
    ETC("기타");

    private final String name;
}
