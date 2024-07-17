package com.exam.controller;

import com.exam.entity.RequestData;
import com.exam.service.CalculatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
    protected static final MediaType JSON_MEDIA_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype());
    private Double[] inputData;

    RequestData requestData;

    @MockBean
    CalculatorService calculatorService;

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void setUp(){
        inputData = new Double[]{5.0,4.0,6.0,1.0};
        requestData = new RequestData();
        requestData.setData(inputData);
    }

    @Test
    public void getSquareRootTest() throws Exception {

        String content = json(requestData);
        given(calculatorService.getRootSquare(inputData)).willReturn(Double.valueOf(8.77));
        mvc.perform(get("/api/v1/calculator/rootsquare")
                .content(content)
                .contentType(JSON_MEDIA_TYPE)
                .header("token","eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NjUwNjY2OTksImV4cCI6MTY2NTEwOTg5OSwidXNlcklkIjozLCJlbWFpbCI6Im50bmdvYy5pdEBnbWFpbC5jb20iLCJmaXJzdE5hbWUiOiJOZ29jIiwibGFzdE5hbWUiOiJOZ3V5ZW4ifQ.aRhYT5jQqO4wMK59nNI1-9gSuPX-P_IDY78QgZ9wenc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_MEDIA_TYPE))
                .andExpect(jsonPath("$.output",is(8.77)));
    }
    protected String json(Object o) throws IOException {
        return objectMapper.writeValueAsString(o);
    }
}
