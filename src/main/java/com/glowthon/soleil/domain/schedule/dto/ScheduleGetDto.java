package com.glowthon.soleil.domain.schedule.dto;

import com.glowthon.soleil.domain.lecture.entity.LectureEntity;
import com.glowthon.soleil.domain.room.entity.RoomEntity;
import com.glowthon.soleil.domain.schedule.entity.WeekDay;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduleGetDto {
    private Long id;
    private WeekDay day;
    private int time;
    private LectureEntity lecture;

}
