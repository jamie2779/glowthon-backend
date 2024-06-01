package com.glowthon.soleil.domain.bookmark.repository;

import com.glowthon.soleil.domain.bookmark.entity.BookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<BookmarkEntity,Long> {
    List<BookmarkEntity> findByUser_Id(Long buildingId);

}
