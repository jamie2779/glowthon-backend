package com.glowthon.soleil.domain.facility.service;


import com.glowthon.soleil.domain.facility.dto.FacilityGetDto;
import com.glowthon.soleil.domain.facility.dto.FacilityPostDto;
import com.glowthon.soleil.domain.facility.entity.FacilityEntity;
import com.glowthon.soleil.domain.facility.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class FacilityService {

    @Autowired
    public FacilityRepository facilityRepository;

    @Transactional
    public FacilityGetDto addFacility(FacilityPostDto newFacility){

        FacilityEntity facility = facilityRepository.save(FacilityEntity.builder()
                .building(newFacility.getBuilding())
                .positionType(newFacility.getPositionType())
                .name(newFacility.getName())
                .facilityType(newFacility.getFacilityType())
                .lat(newFacility.getLat())
                .lng(newFacility.getLng())
                .note(newFacility.getNote())
                .build());

        return FacilityGetDto.builder()
                .id(facility.getId())
                .building(facility.getBuilding())
                .positionType(facility.getPositionType())
                .name(facility.getName())
                .facilityType(facility.getFacilityType())
                .lat(facility.getLat())
                .lng(facility.getLng())
                .note(facility.getNote())
                .build();

    }

    public List<FacilityGetDto> getAllFacilities(){
        return facilityRepository.findAll().stream()
                .map(facility -> FacilityGetDto.builder()
                        .id(facility.getId())
                        .building(facility.getBuilding())
                        .positionType(facility.getPositionType())
                        .name(facility.getName())
                        .facilityType(facility.getFacilityType())
                        .lat(facility.getLat())
                        .lng(facility.getLng())
                        .note(facility.getNote())
                        .build()
                ).collect(Collectors.toList());
    }
    public FacilityGetDto getFacilityById(Long id) {
        try {
            FacilityEntity facility = facilityRepository.findById(id).get();
            return FacilityGetDto.builder()
                    .id(facility.getId())
                    .building(facility.getBuilding())
                    .positionType(facility.getPositionType())
                    .name(facility.getName())
                    .facilityType(facility.getFacilityType())
                    .lat(facility.getLat())
                    .lng(facility.getLng())
                    .note(facility.getNote())
                    .build();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Transactional
    public List<FacilityGetDto> deleteFacility(Long id){
        try{
            facilityRepository.deleteById(id);
            return getAllFacilities();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    public List<FacilityGetDto> getFacilityByBuildingId(Long id) {
        return facilityRepository.findByBuilding_Id(id).stream()
                .map(facility -> FacilityGetDto.builder()
                        .id(facility.getId())
                        .building(facility.getBuilding())
                        .positionType(facility.getPositionType())
                        .name(facility.getName())
                        .facilityType(facility.getFacilityType())
                        .lat(facility.getLat())
                        .lng(facility.getLng())
                        .note(facility.getNote())
                        .build()
                ).collect(Collectors.toList());
    }
}


