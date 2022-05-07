package io.sinsabridge.plants.domain.plant;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlantRepositoryTest {

    @Autowired
    private PlantRepository plantRepository;

    @DisplayName("식물_등록_테스트")
    @Order(1)
    @Test
    public void createPlantTest() {
        PlantDto plantDto = givenPlantDto();
        Plant plant = plantDto.toEntity();

        plantRepository.save(plant);

        Assertions.assertNotNull(plantRepository.findAll());
    }


    private static PlantDto givenPlantDto() {
        PlantDto plantDto = new PlantDto();
        plantDto.setCode("airplant");
        plantDto.setName("공기/정화식물");
        plantDto.setPlantType(PlantType.FOLIAGE);

        return plantDto;
    }
}