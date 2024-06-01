package com.glowthon.soleil.domain.building.repository;

import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity,Long> {

}
