package io.sinsabridge.plants.domain.plant;

import io.sinsabridge.plants.common.entity.AbstractEntity;

import javax.persistence.*;

/**
 * 식물
 */
@Entity
@Table(name = "plants")
public class Plant extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantNo;

    private String code;

    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlantType plantType;
}
