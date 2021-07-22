package com.mobiquity.atmlocator.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NonNull
@EqualsAndHashCode
public class AtmObj implements  Comparable<AtmObj>{
    private Address address;
    private int distance;
    private List<OpeningHour> openingHours;
    private String functionality;
    private String type;

    @Override
    public int compareTo(AtmObj o) {
        return this.address.compareTo(o.address);
    }
}