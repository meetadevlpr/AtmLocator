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
public class OpeningHour{
    private int dayOfWeek;
    private List<Hour> hours;
}