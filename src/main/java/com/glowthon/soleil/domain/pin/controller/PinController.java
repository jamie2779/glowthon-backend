package com.glowthon.soleil.domain.pin.controller;

import com.glowthon.soleil.domain.pin.dto.PinGetDto;
import com.glowthon.soleil.domain.pin.dto.PinPostDto;
import com.glowthon.soleil.domain.pin.service.PinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pins")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PinController {
    private final PinService pinSErvice;

    @PostMapping("")
    public PinGetDto newPin(@RequestBody PinPostDto newPin){
        return pinSErvice.addPin(newPin);
    }

    @GetMapping("")
    public List<PinGetDto> getAllPins(){
        return pinSErvice.getAllPin();
    }
    @GetMapping("/user/{id}")
    public List<PinGetDto> getPinByUserId(@PathVariable("id") Long id){
        return pinSErvice.getPinByUserId(id);
    }

    @GetMapping("/{id}")
    public PinGetDto getPinById(@PathVariable("id") Long id){
        return pinSErvice.getPinById(id);
    }

    @DeleteMapping("/{id}")
    public List<PinGetDto> deleteBookmarks(@PathVariable("id") Long id){
        return pinSErvice.deletePin(id);
    }



}
