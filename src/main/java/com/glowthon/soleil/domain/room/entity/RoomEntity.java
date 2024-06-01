package com.glowthon.soleil.domain.room.entity;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.global.basic.BasicEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RoomEntity extends BasicEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name="building_id")
    private BuildingEntity building;

}
