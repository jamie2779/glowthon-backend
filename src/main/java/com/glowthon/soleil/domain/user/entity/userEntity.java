package com.glowthon.soleil.domain.user.entity;

import com.glowthon.soleil.global.basic.BasicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class userEntity extends BasicEntity {
    private int student_number;
    private String password;
    @Enumerated(EnumType.STRING)
    private userRole role;
    private String username;
    private boolean is_account_expired;
}
