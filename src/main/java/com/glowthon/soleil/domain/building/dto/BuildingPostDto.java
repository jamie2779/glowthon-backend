package com.glowthon.soleil.domain.building.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuildingPostDto {
    private int number;
    private String name;
    private float lat;
    private float lng;
}
