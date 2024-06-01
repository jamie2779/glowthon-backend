package com.glowthon.soleil.domain.schedule.entity;

import com.glowthon.soleil.domain.lecture.entity.LectureEntity;
import com.glowthon.soleil.domain.room.entity.RoomEntity;
import com.glowthon.soleil.global.basic.BasicEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ScheduleEntity extends BasicEntity {
    @Enumerated(EnumType.STRING)
    private WeekDay day;
    private int time;

    @ManyToOne
    @JoinColumn(name="lecture_id")
    private LectureEntity lecture;

}
