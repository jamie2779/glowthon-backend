package com.glowthon.soleil.domain.facility.dto;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.facility.entity.PositionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacilityPostDto {
    private PositionType positionType;
    private String name;
    private String facilityType;
    private float lat;
    private float lng;
    private String note;
    private Long buildingId;
}
