package io.sinsabridge.plants.domain.plant;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantApiController {
    /**
     * 식물 유형 코드 조회
     */
    @GetMapping("/types")
    public List<PlantType> types() {
        return Collections.unmodifiableList(Arrays.asList(PlantType.values()));
    }

    /**
     * 식물유형 별 식물 조회
     */
    @GetMapping("/{plantType}")
    public List<Plant> getPlantsByType(@PathVariable("plantType") PlantType plantType) {
        return null;
    }

    /**
     * 식물 조회
     */
    @GetMapping
    public List<Plant> getPlants() {
        return null;
    }

    /**
     * 식물 등록
     */
    @PostMapping
    public void registPlant(@RequestBody PlantDto plantDto) {

    }
}
