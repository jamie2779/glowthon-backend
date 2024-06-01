package com.glowthon.soleil.domain.menu.repository;

import com.glowthon.soleil.domain.menu.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity,Long> {
    List<MenuEntity> findByFacility_Id(Long buildingId);

}
