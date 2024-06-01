package com.glowthon.soleil.domain.facility.dto;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.facility.entity.PositionType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FacilityGetDto {
    private Long id;
    private PositionType positionType;
    private String name;
    private String facilityType;
    private float lat;
    private float lng;
    private String note;
    private BuildingEntity building;

}
