package com.glowthon.soleil.domain.pin.service;


import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.pin.dto.PinGetDto;
import com.glowthon.soleil.domain.pin.dto.PinPostDto;
import com.glowthon.soleil.domain.pin.entity.PinEntity;
import com.glowthon.soleil.domain.pin.repository.PinRepository;
import com.glowthon.soleil.domain.user.entity.UserEntity;
import com.glowthon.soleil.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class PinService {

    @Autowired
    public PinRepository pinRepository;

    @Autowired
    public UserRepository userRepository;

    @Transactional
    public PinGetDto addPin(PinPostDto newPin){
        UserEntity user = userRepository.findById(newPin.getUserId())
                .orElseThrow(() -> new RuntimeException("Building not found"));
        PinEntity pin = this.pinRepository.save(PinEntity.builder()
                .user(user)
                .name(newPin.getName())
                .lat(newPin.getLat())
                .lng(newPin.getLng())
                .build());

        return PinGetDto.builder()
                .id(pin.getId())
                .user(pin.getUser())
                .name(pin.getName())
                .lat(pin.getLat())
                .lng(pin.getLng())
                .build();

    }

    public List<PinGetDto> getAllPin(){
        return pinRepository.findAll().stream()
                .map(pin -> PinGetDto.builder()
                        .id(pin.getId())
                        .user(pin.getUser())
                        .name(pin.getName())
                        .lat(pin.getLat())
                        .lng(pin.getLng())
                        .build()
                ).collect(Collectors.toList());
    }
    public PinGetDto getPinById(Long id) {
        try {
            PinEntity pin = pinRepository.findById(id).get();
            return PinGetDto.builder()
                    .id(pin.getId())
                    .user(pin.getUser())
                    .name(pin.getName())
                    .lat(pin.getLat())
                    .lng(pin.getLng())
                    .build();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Transactional
    public List<PinGetDto> deletePin(Long id){
        try{
            pinRepository.deleteById(id);
            return getAllPin();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    public List<PinGetDto> getPinByUserId(Long id) {
        return pinRepository.findByUser_Id(id).stream()
                .map(pin -> PinGetDto.builder()
                        .id(pin.getId())
                        .user(pin.getUser())
                        .name(pin.getName())
                        .lat(pin.getLat())
                        .lng(pin.getLng())
                        .build()
                ).collect(Collectors.toList());
    }
}


