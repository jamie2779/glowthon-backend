package com.glowthon.soleil.domain.room.repository;

import com.glowthon.soleil.domain.room.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity,Long> {
    List<RoomEntity> findByBuilding_Id(Long buildingId);

}
