package com.mobiquity.atmlocator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@NonNull
@EqualsAndHashCode
public class Address implements Comparable<Address> {
    @JsonProperty("street")
    private String street;
    @JsonProperty("housenumber")
    private String houseNumber;
    @JsonProperty("postalcode")
    private String postalCode;
    @JsonProperty("city")
    private String city;
    @JsonProperty("geoLocation")
    private GeoLocation geoLocation;
    @Override
    public int compareTo(Address o) {
        return this.houseNumber.compareTo(o.houseNumber);
    }
}