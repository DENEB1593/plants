package io.sinsabridge.plants.domain.plant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.net.http.HttpHeaders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlantApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("식물유형_조회_테스트")
    @Test
    public void getPlantTypeCodes() throws Exception {
        mockMvc.perform(
                    MockMvcRequestBuilders
                            .get("/plants/types")
                            .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

}