package com.glowthon.soleil.domain.lecture.dto;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.room.entity.RoomEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LectureGetDto {
    private Long id;
    private String name;
    private String professor;
    private RoomEntity room;

}
