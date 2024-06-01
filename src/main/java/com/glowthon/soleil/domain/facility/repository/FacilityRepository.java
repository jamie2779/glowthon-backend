package com.glowthon.soleil.domain.facility.repository;

import com.glowthon.soleil.domain.facility.entity.FacilityEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<FacilityEntity,Long> {
    List<FacilityEntity> findByBuilding_Id(Long buildingId);

}
