package com.mobiquity.atmlocator.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@NonNull
@EqualsAndHashCode
public class Hour{
    private String hourFrom;
    private String hourTo;
}