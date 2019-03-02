package com.mariawimmer.weatherApp3;

import com.mariawimmer.weatherApp3.controller.ControllerWeather;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerWeatherTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ControllerWeather controllerWeather;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controllerWeather).build();
    }

    @Test
    public void testControllerWeather() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/weather/city/Vienna"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public  void testStringNotNull() throws Exception {
        String output = controllerWeather.weatherInfo();
        Assert.assertNotEquals("", output);
    }

    @Test
    public  void testStringContainsVienna() throws Exception {
        String output = controllerWeather.weatherInfo();
        Assert.assertTrue(output.contains("Vienna"));
    }

}
