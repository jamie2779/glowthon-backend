package com.glowthon.soleil.domain.menu.service;


import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.facility.entity.FacilityEntity;
import com.glowthon.soleil.domain.facility.repository.FacilityRepository;
import com.glowthon.soleil.domain.menu.dto.MenuGetDto;
import com.glowthon.soleil.domain.menu.dto.MenuPostDto;
import com.glowthon.soleil.domain.menu.entity.MenuEntity;
import com.glowthon.soleil.domain.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class MenuService {

    @Autowired
    public MenuRepository menuRepository;

    @Autowired
    public FacilityRepository facilityRepository;

    @Transactional
    public MenuGetDto addMenu(MenuPostDto newMenu){
        FacilityEntity facility = facilityRepository.findById(newMenu.getFacilityId())
                .orElseThrow(() -> new RuntimeException("Building not found"));

        MenuEntity menu = this.menuRepository.save(MenuEntity.builder()
                .facility(facility)
                .type(newMenu.getType())
                .menu(newMenu.getMenu())
                .date(newMenu.getDate())
                .build());

        return MenuGetDto.builder()
                .id(menu.getId())
                .facility(menu.getFacility())
                .type(menu.getType())
                .menu(menu.getMenu())
                .date(menu.getDate())
                .build();

    }

    public List<MenuGetDto> getAllMenu(){
        return menuRepository.findAll().stream()
                .map(menu -> MenuGetDto.builder()
                        .id(menu.getId())
                        .facility(menu.getFacility())
                        .type(menu.getType())
                        .menu(menu.getMenu())
                        .date(menu.getDate())
                        .build()
                ).collect(Collectors.toList());
    }
    public MenuGetDto getMenuById(Long id) {
        try {
            MenuEntity menu = menuRepository.findById(id).get();
            return MenuGetDto.builder()
                    .id(menu.getId())
                    .facility(menu.getFacility())
                    .type(menu.getType())
                    .menu(menu.getMenu())
                    .date(menu.getDate())
                    .build();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Transactional
    public List<MenuGetDto> deleteMenu(Long id){
        try{
            menuRepository.deleteById(id);
            return getAllMenu();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    public List<MenuGetDto> getMenuByFacilityId(Long id) {
        return menuRepository.findByFacility_Id(id).stream()
                .map(menu -> MenuGetDto.builder()
                        .facility(menu.getFacility())
                        .type(menu.getType())
                        .menu(menu.getMenu())
                        .date(menu.getDate())
                        .build()
                ).collect(Collectors.toList());
    }
}


