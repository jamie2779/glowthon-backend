package com.glowthon.soleil.domain.building.controller;

import com.glowthon.soleil.domain.building.dto.BuildingGetDto;
import com.glowthon.soleil.domain.building.dto.BuildingPostDto;
import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.building.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buildings")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @PostMapping("")
    public BuildingGetDto newBuilding(@RequestBody BuildingPostDto newBuilding){
        return buildingService.addBuilding(newBuilding);
    }

    @GetMapping("")
    public List<BuildingGetDto> getAllBuildings(){
        return buildingService.getAllBuildings();
    }

    @GetMapping("/{id}")
    public BuildingGetDto getBuildingById(@PathVariable("id") Long id){
        return buildingService.getBuildingById(id);
    }

    @PutMapping("/{id}")
    public BuildingGetDto editBuilding(@PathVariable("id") Long id, @RequestBody BuildingPostDto info){
        return buildingService.editBuilding(id,info.getNumber(),info.getName(),info.getLat(),info.getLng());
    }

    @DeleteMapping("/{id}")
    public List<BuildingGetDto> deleteBuilding(@PathVariable("id") Long id){
        return buildingService.deleteBuilding(id);
    }

}
