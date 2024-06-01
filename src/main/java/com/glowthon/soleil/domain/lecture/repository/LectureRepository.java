package com.glowthon.soleil.domain.lecture.repository;

import com.glowthon.soleil.domain.lecture.entity.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<LectureEntity,Long> {
    List<LectureEntity> findByRoom_Id(Long roomId);

}
