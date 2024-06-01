package com.glowthon.soleil.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glowthon.soleil.domain.bookmark.entity.BookmarkEntity;
import com.glowthon.soleil.domain.pin.entity.PinEntity;
import com.glowthon.soleil.global.basic.BasicEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends BasicEntity {
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String username;
    private boolean is_account_expired;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<BookmarkEntity> bookmarks = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<PinEntity> pins = new ArrayList<>();

}
