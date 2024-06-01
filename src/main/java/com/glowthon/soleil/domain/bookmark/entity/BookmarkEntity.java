package com.glowthon.soleil.domain.bookmark.entity;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.facility.entity.FacilityEntity;
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
public class BookmarkEntity extends BasicEntity {
    private BookmarkType type;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="facility_id")
    private FacilityEntity facility;

    @ManyToOne
    @JoinColumn(name="building_id")
    private BuildingEntity building;

}
