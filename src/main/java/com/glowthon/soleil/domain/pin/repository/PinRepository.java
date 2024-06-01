package com.glowthon.soleil.domain.pin.repository;

import com.glowthon.soleil.domain.pin.entity.PinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinRepository extends JpaRepository<PinEntity,Long> {
    List<PinEntity> findByUser_Id(Long buildingId);

}
