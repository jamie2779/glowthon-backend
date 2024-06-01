package com.glowthon.soleil.domain.bookmark.controller;

import com.glowthon.soleil.domain.bookmark.dto.BookmarkGetDto;
import com.glowthon.soleil.domain.bookmark.dto.BookmarkPostDto;
import com.glowthon.soleil.domain.bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping("")
    public BookmarkGetDto newBookmark(@RequestBody BookmarkPostDto newBookmark){
        return bookmarkService.addBookmark(newBookmark);
    }

    @GetMapping("")
    public List<BookmarkGetDto> getAllBookmarks(){
        return bookmarkService.getAllBookmark();
    }
    @GetMapping("/user/{id}")
    public List<BookmarkGetDto> getBookmarksByUserId(@PathVariable("id") Long id){
        return bookmarkService.getBookmarksByUserId(id);
    }

    @GetMapping("/{id}")
    public BookmarkGetDto getBookmarkById(@PathVariable("id") Long id){
        return bookmarkService.getBookmarkById(id);
    }

    @DeleteMapping("/{id}")
    public List<BookmarkGetDto> deleteBookmarks(@PathVariable("id") Long id){
        return bookmarkService.deleteBookmark(id);
    }



}
