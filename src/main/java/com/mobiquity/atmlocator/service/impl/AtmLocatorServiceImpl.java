package com.mobiquity.atmlocator.service.impl;

import com.mobiquity.atmlocator.dto.AtmObj;
import com.mobiquity.atmlocator.dto.response.AtmObjResponse;
import com.mobiquity.atmlocator.exception.AtmNotFoundException;
import com.mobiquity.atmlocator.service.AtmLocatorService;
import com.mobiquity.atmlocator.util.client.AtmRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtmLocatorServiceImpl implements AtmLocatorService {


    @Value("${mobi.quity.atm.locator.uri}")
    private String atmLocatorUri;

    @Override
    public List<AtmObjResponse> findAllAtm() throws AtmNotFoundException, IOException {
        return getAtmList("");
    }

    @Override
    public List<AtmObjResponse> finAtmByCity(String city) throws AtmNotFoundException, IOException {
        return getAtmList(city);
    }


    public List<AtmObjResponse> getAtmList(String city) throws IOException, AtmNotFoundException {
        List<AtmObj> atmObjList = AtmRestClient.getInstance().getATMs(atmLocatorUri).stream().
                filter(atm -> city.equalsIgnoreCase("") || atm.getAddress().getCity().equals(city)).
                sorted().
                collect(Collectors.toList());
        if (atmObjList.isEmpty()) {
            throw new AtmNotFoundException();
        }
        List<AtmObjResponse> atmObjResponseList = new ArrayList<>();
        getAtmObjectResponseList(atmObjList, atmObjResponseList);
        return atmObjResponseList;
    }

    public void getAtmObjectResponseList(List<AtmObj> atmObjList, List<AtmObjResponse> atmObjResponseList) {
        atmObjList.forEach(atm -> {
            AtmObjResponse atmObjResponse = new AtmObjResponse();
            atmObjResponse.setAddress(atm.getAddress());
            atmObjResponse.setFunctionality(atm.getFunctionality());
            atmObjResponse.setType(atm.getType());
            atmObjResponseList.add(atmObjResponse);
        });
    }
}
