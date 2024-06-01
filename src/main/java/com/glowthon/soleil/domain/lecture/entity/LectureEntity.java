package com.glowthon.soleil.domain.lecture.entity;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.room.entity.RoomEntity;
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
public class LectureEntity extends BasicEntity {
    private String name;
    private String professor;

    @ManyToOne
    @JoinColumn(name="room_id")
    private RoomEntity room;

}
