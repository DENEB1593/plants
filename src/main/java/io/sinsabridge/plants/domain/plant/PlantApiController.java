package io.sinsabridge.plants.domain.plant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantApiController {
    /**
     * 식물 유형 코드 조회
     */
    @GetMapping("/types")
    public List<PlantType> types() {
        return Arrays.asList(PlantType.values());
    }
}
