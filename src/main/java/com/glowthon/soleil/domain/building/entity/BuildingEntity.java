package com.glowthon.soleil.domain.building.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glowthon.soleil.domain.bookmark.entity.BookmarkEntity;
import com.glowthon.soleil.domain.facility.entity.FacilityEntity;
import com.glowthon.soleil.domain.room.entity.RoomEntity;
import com.glowthon.soleil.global.basic.BasicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BuildingEntity extends BasicEntity {
    private int number;
    private String name;
    private float lat;
    private float lng;

    @JsonIgnore
    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<FacilityEntity> facilities = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<RoomEntity> rooms = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<BookmarkEntity> bookmarks = new ArrayList<>();

}
