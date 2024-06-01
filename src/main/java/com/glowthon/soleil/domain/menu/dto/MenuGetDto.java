package com.glowthon.soleil.domain.menu.dto;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.facility.entity.FacilityEntity;
import com.glowthon.soleil.domain.menu.entity.MenuType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MenuGetDto {
    private Long id;
    private FacilityEntity facility;
    private MenuType type;
    private String menu;
    private LocalDateTime date;

}
