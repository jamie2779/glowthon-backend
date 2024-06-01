package com.glowthon.soleil.domain.room.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.lecture.entity.LectureEntity;
import com.glowthon.soleil.domain.pin.entity.PinEntity;
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
public class RoomEntity extends BasicEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name="building_id")
    private BuildingEntity building;

    @JsonIgnore
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<LectureEntity> lectures = new ArrayList<>();

}
