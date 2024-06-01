package com.glowthon.soleil.domain.facility.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.menu.entity.MenuEntity;
import com.glowthon.soleil.global.basic.BasicEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FacilityEntity extends BasicEntity {
    @Enumerated(EnumType.STRING)
    private PositionType positionType;
    private String name;
    private String facilityType;
    private float lat;
    private float lng;
    private String note;

    @ManyToOne
    @JoinColumn(name="building_id")
    private BuildingEntity building;

    @JsonIgnore
    @OneToMany(mappedBy = "facility", fetch = FetchType.LAZY)
    private List<MenuEntity> menus = new ArrayList<>();

}
