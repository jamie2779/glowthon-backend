package com.glowthon.soleil.domain.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class userGetDto {
    private Long id;
    private String username;
    private int student_number;
}
