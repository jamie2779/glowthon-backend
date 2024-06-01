package com.glowthon.soleil.domain.building.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildingGetDto {
    private Long id;
    private int number;
    private String name;
    private float lat;
    private float lng;

}
