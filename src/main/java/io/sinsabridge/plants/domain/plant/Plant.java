package io.sinsabridge.plants.domain.plant;

import com.google.common.base.Strings;
import io.sinsabridge.plants.common.entity.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * 식물
 */
@Getter
@NoArgsConstructor
@Entity
@Table(name = "plants")
public class Plant extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantNo;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlantType plantType;

    @Builder
    public Plant(String code, String name, PlantType plantType) {
        if(Strings.isNullOrEmpty(code)) throw new IllegalArgumentException("empty code");
        if(Strings.isNullOrEmpty(name)) throw new IllegalArgumentException("empty name");
        if(Objects.isNull(plantType)) throw new IllegalArgumentException("empty plantType");

        this.code = code;
        this.name = name;
        this.plantType = plantType;
    }
}
