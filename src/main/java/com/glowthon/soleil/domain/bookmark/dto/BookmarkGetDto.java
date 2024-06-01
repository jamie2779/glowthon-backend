package com.glowthon.soleil.domain.bookmark.dto;

import com.glowthon.soleil.domain.bookmark.entity.BookmarkType;
import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.facility.entity.FacilityEntity;
import com.glowthon.soleil.domain.user.entity.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookmarkGetDto {
    private Long id;
    private UserEntity user;
    private BookmarkType type;
    private FacilityEntity facility;
    private BuildingEntity building;

}
