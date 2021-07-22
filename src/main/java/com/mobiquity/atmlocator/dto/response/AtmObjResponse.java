package com.mobiquity.atmlocator.dto.response;


import com.mobiquity.atmlocator.dto.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtmObjResponse {

    private Address address;
    private String distance;
    private String functionality;
    private String type;
}
