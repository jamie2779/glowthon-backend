package com.glowthon.soleil.domain.bookmark.service;


import com.glowthon.soleil.domain.bookmark.dto.BookmarkGetDto;
import com.glowthon.soleil.domain.bookmark.dto.BookmarkPostDto;
import com.glowthon.soleil.domain.bookmark.entity.BookmarkEntity;
import com.glowthon.soleil.domain.bookmark.repository.BookmarkRepository;
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

    @Transactional
    public BookmarkGetDto addBookmark(BookmarkPostDto newBookmark){

        BookmarkEntity bookmark = bookmarkRepository.save(BookmarkEntity.builder()
                .user(newBookmark.getUser())
                .type(newBookmark.getType())
                .building(newBookmark.getBuilding())
                .facility(newBookmark.getFacility())
                .build());

        return BookmarkGetDto.builder()
                .id(bookmark.getId())
                .user(newBookmark.getUser())
                .type(newBookmark.getType())
                .building(newBookmark.getBuilding())
                .facility(newBookmark.getFacility())
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


