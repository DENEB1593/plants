package io.sinsabridge.plants.domain.plant;

import io.sinsabridge.plants.common.response.CommonResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlantApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("식물유형_조회_테스트")
    @Test
    public void getPlantTypeCodes() throws Exception {
        final int PLANT_TYPE_SIZE = PlantType.values().length;
        mockMvc.perform(
                    get("/plants/types").contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(CommonResponse.Status.SUCCESS.toString())))
                .andExpect(jsonPath("$.data", hasSize(PLANT_TYPE_SIZE)));
    }

}