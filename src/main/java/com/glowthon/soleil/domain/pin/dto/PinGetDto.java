package com.glowthon.soleil.domain.pin.dto;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.user.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PinGetDto {
    private Long id;
    private UserEntity user;
    private String name;
    private float lat;
    private float lng;

}
