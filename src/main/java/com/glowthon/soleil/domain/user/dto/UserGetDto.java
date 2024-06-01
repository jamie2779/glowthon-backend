package com.glowthon.soleil.domain.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserGetDto {
    private Long id;
    private String username;
    private String email;
}
