package com.glowthon.soleil.domain.menu.controller;

import com.glowthon.soleil.domain.menu.dto.MenuGetDto;
import com.glowthon.soleil.domain.menu.dto.MenuPostDto;
import com.glowthon.soleil.domain.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menus")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping("")
    public MenuGetDto newMenu(@RequestBody MenuPostDto newMenu){
        return menuService.addMenu(newMenu);
    }

    @GetMapping("")
    public List<MenuGetDto> getAllMenus(){
        return menuService.getAllMenu();
    }
    @GetMapping("/user/{id}")
    public List<MenuGetDto> getMenuByFacilityId(@PathVariable("id") Long id){
        return menuService.getMenuByFacilityId(id);
    }

    @GetMapping("/{id}")
    public MenuGetDto getMenuById(@PathVariable("id") Long id){
        return menuService.getMenuById(id);
    }

    @DeleteMapping("/{id}")
    public List<MenuGetDto> DeleteMenu(@PathVariable("id") Long id){
        return menuService.deleteMenu(id);
    }



}
