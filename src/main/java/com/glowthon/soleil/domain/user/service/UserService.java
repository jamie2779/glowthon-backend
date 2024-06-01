package com.glowthon.soleil.domain.user.service;

import com.glowthon.soleil.domain.user.dto.UserGetDto;
import com.glowthon.soleil.domain.user.dto.UserPostDto;
import com.glowthon.soleil.domain.user.entity.UserEntity;
import com.glowthon.soleil.domain.user.entity.UserRole;
import com.glowthon.soleil.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserGetDto addUser(UserPostDto userDto){
        if (userRepository.findByUsername(userDto.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        UserEntity newUser = UserEntity.builder()
                .email(userDto.getEmail())
                .password(encodedPassword)
                .username(userDto.getUsername())
                .role(UserRole.USER)
                .is_account_expired(false)
                .build();

        UserEntity savedUser = userRepository.save(newUser);
        return UserGetDto.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .username(savedUser.getUsername())
                .build();
    }

    public List<UserGetDto> getAllUsers(){
        return userRepository.findAll().stream()
                .map(userEntity -> UserGetDto.builder()
                        .id(userEntity.getId())
                        .username(userEntity.getUsername())
                        .email(userEntity.getEmail())
                        .build()
                ).collect(Collectors.toList());
    }


}
