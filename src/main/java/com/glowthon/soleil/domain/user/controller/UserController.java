package com.glowthon.soleil.domain.user.controller;

import com.glowthon.soleil.domain.user.dto.UserGetDto;
import com.glowthon.soleil.domain.user.dto.UserPostDto;
import com.glowthon.soleil.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public UserGetDto newUser(@RequestBody UserPostDto newUser){
        return userService.addUser(newUser);
    }

    @GetMapping("")
    public List<UserGetDto> getAllUsers(){
        return userService.getAllUsers();
    }
}
