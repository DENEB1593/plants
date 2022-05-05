package io.sinsabridge.plants.domain.plant;

import io.sinsabridge.plants.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
@RequiredArgsConstructor
public class PlantApiController {

    private final PlantService plantService;

    /**
     * 식물 조회
     */
    @GetMapping
    public List<Plant> getPlants() {
        plantService.getPlants();
        return null;
    }

    /**
     * 식물 등록
     */
    @PostMapping
    public void registPlant(@RequestBody PlantDto plantDto) {
        plantService.registPlant(plantDto);
    }

    /**
     * 식물 정보 수정
     */
    @PutMapping
    public void updatePlant(@RequestBody PlantDto plantDto) {
        plantService.updatePlant(plantDto);
    }

    /**
     * 식물 삭제
     */
    @DeleteMapping
    public void deletePlant(Long plantNo) {
        plantService.deletePlant(plantNo);
    }

    /**
     * 식물유형 별 식물 조회
     */
    @GetMapping("/{plantType}")
    public List<Plant> getPlantsByType(@PathVariable("plantType") PlantType plantType) {
        plantService.getPlantsByType(plantType);
        return null;
    }
    /**
     * 식물 유형 코드 조회
     */
    @GetMapping("/types")
    public CommonResponse types() {
        List<PlantType> plantTypeList = PlantType.toList();
        return CommonResponse.success(plantTypeList);
    }

}
