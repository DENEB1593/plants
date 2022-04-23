package io.sinsabridge.plants.domain.plant;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlantDto {

    private String code;

    private String name;

    private PlantType plantType;

    public Plant toEntity() {
        return Plant.builder()
                .code(code)
                .name(name)
                .plantType(plantType)
                .build();
    }
}
