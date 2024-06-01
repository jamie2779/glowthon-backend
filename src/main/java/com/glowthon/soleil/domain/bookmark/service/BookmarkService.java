package com.glowthon.soleil.domain.bookmark.service;


import com.glowthon.soleil.domain.bookmark.dto.BookmarkGetDto;
import com.glowthon.soleil.domain.bookmark.dto.BookmarkPostDto;
import com.glowthon.soleil.domain.bookmark.entity.BookmarkEntity;
import com.glowthon.soleil.domain.bookmark.entity.BookmarkType;
import com.glowthon.soleil.domain.bookmark.repository.BookmarkRepository;
import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.building.repository.BuildingRepository;
import com.glowthon.soleil.domain.facility.entity.FacilityEntity;
import com.glowthon.soleil.domain.facility.repository.FacilityRepository;
import com.glowthon.soleil.domain.user.entity.UserEntity;
import com.glowthon.soleil.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class BookmarkService {

    @Autowired
    public BookmarkRepository bookmarkRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public FacilityRepository facilityRepository;

    @Autowired
    public BuildingRepository buildingRepository;

    @Transactional
    public BookmarkGetDto addBookmark(BookmarkPostDto newBookmark){
        UserEntity user = userRepository.findById(newBookmark.getBuildingId())
                .orElseThrow(() -> new RuntimeException("Building not found"));
        FacilityEntity facility = null;
        BuildingEntity building = null;
        if(newBookmark.getType() == BookmarkType.FACILITY){
            facility = facilityRepository.findById(newBookmark.getFacilityId())
                    .orElseThrow(() -> new RuntimeException("Building not found"));
        }else{
            building = buildingRepository.findById(newBookmark.getBuildingId())
                    .orElseThrow(() -> new RuntimeException("Building not found"));
        }
        BookmarkEntity bookmark = bookmarkRepository.save(BookmarkEntity.builder()
                .user(user)
                .type(newBookmark.getType())
                .building(building)
                .facility(facility)
                .build());

        return BookmarkGetDto.builder()
                .id(bookmark.getId())
                .user(bookmark.getUser())
                .type(newBookmark.getType())
                .building(bookmark.getBuilding())
                .facility(bookmark.getFacility())
                .build();

    }

    public List<BookmarkGetDto> getAllBookmark(){
        return bookmarkRepository.findAll().stream()
                .map(bookmark -> BookmarkGetDto.builder()
                        .id(bookmark.getId())
                        .user(bookmark.getUser())
                        .type(bookmark.getType())
                        .building(bookmark.getBuilding())
                        .facility(bookmark.getFacility())
                        .build()
                ).collect(Collectors.toList());
    }
    public BookmarkGetDto getBookmarkById(Long id) {
        try {
            BookmarkEntity bookmark = bookmarkRepository.findById(id).get();
            return BookmarkGetDto.builder()
                    .id(bookmark.getId())
                    .user(bookmark.getUser())
                    .type(bookmark.getType())
                    .building(bookmark.getBuilding())
                    .facility(bookmark.getFacility())
                    .build();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Transactional
    public List<BookmarkGetDto> deleteBookmark(Long id){
        try{
            bookmarkRepository.deleteById(id);
            return getAllBookmark();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    public List<BookmarkGetDto> getBookmarksByUserId(Long id) {
        return bookmarkRepository.findByUser_Id(id).stream()
                .map(bookmark -> BookmarkGetDto.builder()
                        .id(bookmark.getId())
                        .user(bookmark.getUser())
                        .type(bookmark.getType())
                        .building(bookmark.getBuilding())
                        .facility(bookmark.getFacility())
                        .build()
                ).collect(Collectors.toList());
    }
}


