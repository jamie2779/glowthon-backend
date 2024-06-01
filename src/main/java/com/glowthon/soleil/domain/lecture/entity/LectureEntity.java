package com.glowthon.soleil.domain.lecture.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.room.entity.RoomEntity;
import com.glowthon.soleil.domain.schedule.entity.ScheduleEntity;
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
public class LectureEntity extends BasicEntity {
    private String name;
    private String professor;

    @ManyToOne
    @JoinColumn(name="room_id")
    private RoomEntity room;

    @JsonIgnore
    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY)
    private List<ScheduleEntity> schedules = new ArrayList<>();

}
