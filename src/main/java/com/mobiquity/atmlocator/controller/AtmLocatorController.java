package com.mobiquity.atmlocator.controller;


import com.mobiquity.atmlocator.dto.response.ResponseDTO;
import com.mobiquity.atmlocator.exception.AtmNotFoundException;
import com.mobiquity.atmlocator.service.AtmLocatorService;
import com.mobiquity.atmlocator.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/atm/")
public class AtmLocatorController {

    private final AtmLocatorService atmLocatorService;
    private final ResponseUtil responseUtil;

    public AtmLocatorController(AtmLocatorService atmLocatorService, ResponseUtil responseUtil) {
        this.atmLocatorService = atmLocatorService;
        this.responseUtil = responseUtil;
    }

    @ApiOperation(value="Find All Atm List")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @GetMapping("v1/findAll")
    @Secured(value="ROLE_ADMIN")
    public ResponseDTO findAllAtm() throws AtmNotFoundException, IOException {
        return responseUtil.createResponseDto("Get All Atm List",200,atmLocatorService.findAllAtm());
    }


    @ApiOperation(value="Find Atm By City")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @GetMapping("v1/findByCity/{city}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ResponseDTO findAtmByCity(@PathVariable String city) throws AtmNotFoundException, IOException {
        return responseUtil.createResponseDto("Get All Atm List",200,atmLocatorService.finAtmByCity(city));
    }


}
