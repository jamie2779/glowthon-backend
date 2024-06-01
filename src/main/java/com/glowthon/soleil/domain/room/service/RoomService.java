package com.glowthon.soleil.domain.room.service;


import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.building.repository.BuildingRepository;
import com.glowthon.soleil.domain.room.dto.RoomGetDto;
import com.glowthon.soleil.domain.room.dto.RoomPostDto;
import com.glowthon.soleil.domain.room.entity.RoomEntity;
import com.glowthon.soleil.domain.room.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class RoomService {
    @Autowired
    public RoomRepository roomRepository;

    @Autowired
    public BuildingRepository buildingRepository;

    @Transactional
    public RoomGetDto addRoom(RoomPostDto newRoom){
        BuildingEntity building = buildingRepository.findById(newRoom.getBuildingId())
                .orElseThrow(() -> new RuntimeException("Building not found"));

        RoomEntity room = roomRepository.save(RoomEntity.builder()
                .building(building)
                .name(newRoom.getName())
                .build());

        return RoomGetDto.builder()
                .id(room.getId())
                .building(room.getBuilding())
                .name(room.getName())
                .build();

    }

    public List<RoomGetDto> getAllRoom(){
        return roomRepository.findAll().stream()
                .map(room -> RoomGetDto.builder()
                        .id(room.getId())
                        .building(room.getBuilding())
                        .name(room.getName())
                        .build()
                ).collect(Collectors.toList());
    }
    public RoomGetDto getRoomById(Long id) {
        try {
            RoomEntity room = roomRepository.findById(id).get();
            return RoomGetDto.builder()
                    .id(room.getId())
                    .building(room.getBuilding())
                    .name(room.getName())
                    .build();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Transactional
    public List<RoomGetDto> deleteRoom(Long id){
        try{
            roomRepository.deleteById(id);
            return getAllRoom();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    public List<RoomGetDto> getRoomByBuildingId(Long id) {
        return roomRepository.findByBuilding_Id(id).stream()
                .map(room -> RoomGetDto.builder()
                        .id(room.getId())
                        .building(room.getBuilding())
                        .name(room.getName())
                        .build()
                ).collect(Collectors.toList());
    }
}


