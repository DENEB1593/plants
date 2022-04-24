package io.sinsabridge.plants.domain.plant;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 식물유형
 */
@AllArgsConstructor
@Getter
@JsonSerialize(using = PlantTypeSerializer.class)
public enum PlantType {

    FOLIAGE( "관엽식물"),
    FLOWER("꽃"),
    TREE("나무"),
    HERB("허브"),
    SEED("씨앗"),
    ETC("기타");

    private final String name;


    public static List<PlantType> toList() {
       return Stream.of(PlantType.values())
               .collect(Collectors.toUnmodifiableList());
    }
}
