package com.glowthon.soleil.domain.room.dto;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomGetDto {
    private Long id;
    private String name;
    private BuildingEntity building;

}
