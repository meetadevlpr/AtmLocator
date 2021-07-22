package com.mobiquity.atmlocator.controller;

import com.mobiquity.atmlocator.dto.Address;
import com.mobiquity.atmlocator.dto.response.AtmObjResponse;
import com.mobiquity.atmlocator.service.AtmLocatorService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebAppConfiguration
@WithMockUser(authorities = "ROLE_ADMIN")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class AtmLocatorControllerTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;
    protected MockMvc mockMvc;

    @Mock
    AtmLocatorService atmLocatorService;
    private List<AtmObjResponse> atmLocationList;


    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        atmLocationList = new ArrayList<>();
        AtmObjResponse atmObjResponse = new AtmObjResponse();
        Address address = new Address();
        address.setCity("GELDROP");
        address.setHouseNumber("1");

        atmObjResponse.setAddress(address);

        AtmObjResponse atmObjResponse1 = new AtmObjResponse();
        Address address1 = new Address();
        address1.setHouseNumber("2");
        address1.setCity("ROTTERDAM");

        atmObjResponse1.setAddress(address1);

        atmLocationList.add(atmObjResponse);
        atmLocationList.add(atmObjResponse1);
    }


    @Test
    void testGetAllATM() {
        try {
            when(atmLocatorService.findAllAtm()).thenReturn(atmLocationList);
            mockMvc.perform(get("/api/atm/v1/findAll")).
                    andExpect(status().isOk()).
                    andExpect((jsonPath("$.*", Matchers.hasSize(3)))).
                    andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void findAtmByCity() {
        try {
            when(atmLocatorService.finAtmByCity(any())).thenReturn(atmLocationList);
            mockMvc.perform(get("/api/atm/v1/findByCity/" + "ROTTERDAM")).
                    andExpect(status().isOk()).
                    andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

}