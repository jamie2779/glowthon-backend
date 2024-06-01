package com.glowthon.soleil.domain.pin.dto;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PinPostDto
{
    private Long userId;
    private String name;
    private float lat;
    private float lng;
}
