package com.mobiquity.atmlocator.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@NonNull
@EqualsAndHashCode
public class GeoLocation{
    private String lat;
    private String lng;
}