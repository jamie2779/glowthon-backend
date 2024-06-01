package com.glowthon.soleil.domain.pin.entity;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.user.entity.UserEntity;
import com.glowthon.soleil.global.basic.BasicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PinEntity extends BasicEntity {
    private String name;
    private float lat;
    private float lng;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;


}
