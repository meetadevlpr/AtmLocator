package com.mobiquity.atmlocator.service;


import com.mobiquity.atmlocator.dto.response.AtmObjResponse;
import com.mobiquity.atmlocator.exception.AtmNotFoundException;

import java.io.IOException;
import java.util.List;

public interface AtmLocatorService {

    List<AtmObjResponse> findAllAtm() throws AtmNotFoundException, IOException;

    List<AtmObjResponse> finAtmByCity(String city) throws AtmNotFoundException, IOException;


}
