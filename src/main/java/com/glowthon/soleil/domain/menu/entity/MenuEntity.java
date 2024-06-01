package com.glowthon.soleil.domain.menu.entity;

import com.glowthon.soleil.domain.facility.entity.FacilityEntity;
import com.glowthon.soleil.global.basic.BasicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MenuEntity extends BasicEntity {
    private MenuType type;
    private String menu;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="facility_id")
    private FacilityEntity facility;


}
