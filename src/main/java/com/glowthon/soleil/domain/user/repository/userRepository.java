package com.glowthon.soleil.domain.user.repository;

import com.glowthon.soleil.domain.user.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<userEntity,Long> {

}
