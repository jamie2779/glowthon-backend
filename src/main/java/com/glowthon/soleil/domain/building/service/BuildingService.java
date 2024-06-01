package com.glowthon.soleil.domain.building.service;


import com.glowthon.soleil.domain.building.dto.BuildingGetDto;
import com.glowthon.soleil.domain.building.dto.BuildingPostDto;
import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.building.repository.BuildingRepository;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class BuildingService {

    @Autowired
    public BuildingRepository buildingRepository;

    @Transactional
    public BuildingGetDto addBuilding(BuildingPostDto newBuilding){

        BuildingEntity building = buildingRepository.save(BuildingEntity.builder()
                .number(newBuilding.getNumber())
                .name(newBuilding.getName())
                .lat(newBuilding.getLat())
                .lng(newBuilding.getLng())
                .build());

        return BuildingGetDto.builder()
                .id(building.getId())
                .number(building.getNumber())
                .name(building.getName())
                .lat(building.getLat())
                .lng(building.getLng())
                .build();

    }

    public List<BuildingGetDto> getAllBuildings(){
        return buildingRepository.findAll().stream()
                .map(buildingEntity -> BuildingGetDto.builder()
                        .id(buildingEntity.getId())
                        .number(buildingEntity.getNumber())
                        .name(buildingEntity.getName())
                        .lat(buildingEntity.getLat())
                        .lng(buildingEntity.getLng())
                        .build()
                ).collect(Collectors.toList());
    }
    public BuildingGetDto getBuildingById(Long id){
        try {
            BuildingEntity building = buildingRepository.findById(id).get();
            return BuildingGetDto.builder()
                    .id(building.getId())
                    .number(building.getNumber())
                    .name(building.getName())
                    .lat(building.getLat())
                    .lng(building.getLng())
                    .build();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    @Transactional
    public BuildingGetDto editBuilding(Long id, int number, String name, float lat, float lng){
        try{
            BuildingEntity _building = buildingRepository.findById(id).get();
            if(number != 0) _building.setNumber(number);
            if(name != null) _building.setName(name);
            if(lat != 0) _building.setLat(lat);
            if(lng != 0) _building.setLng(lng);
            buildingRepository.save(_building);
            return getBuildingById(id);
        }catch(NoSuchElementException e){
            return null;
        }

    }

    @Transactional
    public List<BuildingGetDto> deleteBuilding(Long id){
        try{
            buildingRepository.deleteById(id);
            return getAllBuildings();
        }catch(NoSuchElementException e){
            return null;
        }
    }
}


