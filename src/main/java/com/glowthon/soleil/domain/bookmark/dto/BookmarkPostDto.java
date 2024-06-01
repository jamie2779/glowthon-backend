package com.glowthon.soleil.domain.bookmark.dto;

import com.glowthon.soleil.domain.bookmark.entity.BookmarkType;
import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.facility.entity.FacilityEntity;
import com.glowthon.soleil.domain.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkPostDto
{
    private UserEntity user;
    private BookmarkType type;
    private FacilityEntity facility;
    private BuildingEntity building;
}
