package com.glowthon.soleil.domain.room.dto;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomPostDto {
    private String name;
    private BuildingEntity building;
}
