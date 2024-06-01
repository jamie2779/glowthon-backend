package com.glowthon.soleil.domain.room.controller;

import com.glowthon.soleil.domain.facility.dto.FacilityGetDto;
import com.glowthon.soleil.domain.room.dto.RoomGetDto;
import com.glowthon.soleil.domain.room.dto.RoomPostDto;
import com.glowthon.soleil.domain.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("")
    public RoomGetDto newRoom(@RequestBody RoomPostDto newBuilding){
        return roomService.addRoom(newBuilding);
    }

    @GetMapping("")
    public List<RoomGetDto> getAllRooms(){
        return roomService.getAllRoom();
    }
    @GetMapping("/building/{id}")
    public List<RoomGetDto> getRoomByBuildingId(@PathVariable("id") Long id){
        return roomService.getRoomByBuildingId(id);
    }

    @GetMapping("/{id}")
    public RoomGetDto getRoomById(@PathVariable("id") Long id){
        return roomService.getRoomById(id);
    }

    @DeleteMapping("/{id}")
    public List<RoomGetDto> deleteRoom(@PathVariable("id") Long id){
        return roomService.deleteRoom(id);
    }



}
