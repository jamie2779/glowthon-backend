package com.glowthon.soleil.domain.facility.controller;

import com.glowthon.soleil.domain.facility.dto.FacilityGetDto;
import com.glowthon.soleil.domain.facility.dto.FacilityPostDto;
import com.glowthon.soleil.domain.facility.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facilities")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class FacilityController {
    @Autowired
    private FacilityService facilityService;

    @PostMapping("")
    public FacilityGetDto newFacility(@RequestBody FacilityPostDto newBuilding){
        return facilityService.addFacility(newBuilding);
    }

    @GetMapping("/building/{id}")
    public List<FacilityGetDto> getFacilityByBuildingId(@PathVariable("id") Long id){
        return facilityService.getFacilityByBuildingId(id);
    }

    @GetMapping("")
    public List<FacilityGetDto> getAllfacilities(){
        return facilityService.getAllFacilities();
    }

    @GetMapping("/{id}")
    public FacilityGetDto getFacilityById(@PathVariable("id") Long id){
        return facilityService.getFacilityById(id);
    }

    @DeleteMapping("/{id}")
    public List<FacilityGetDto> deleteFacilitys(@PathVariable("id") Long id){
        return facilityService.deleteFacility(id);
    }



}
