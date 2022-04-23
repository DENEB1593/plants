package io.sinsabridge.plants.domain.plant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlantService {

    private final PlantRepository plantRepository;

    public void getPlants() {

    }

    public void getPlantsByType(PlantType plantType) {

    }

    public void registPlant(PlantDto plantDto) {

    }

    public void updatePlant(PlantDto plantDto) {

    }

    public void deletePlant() {

    }
}
