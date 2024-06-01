package com.glowthon.soleil.domain.lecture.controller;

import com.glowthon.soleil.domain.lecture.dto.LectureGetDto;
import com.glowthon.soleil.domain.lecture.dto.LecturePostDto;
import com.glowthon.soleil.domain.lecture.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lectures")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class LectureController {
    @Autowired
    private LectureService roomService;

    @PostMapping("")
    public LectureGetDto newLecture(@RequestBody LecturePostDto newLecture){
        return roomService.addLecture(newLecture);
    }

    @GetMapping("")
    public List<LectureGetDto> getAllLectures(){
        return roomService.getAllLecture();
    }
    @GetMapping("/room/{id}")
    public List<LectureGetDto> getLecturesByRoomId(@PathVariable("id") Long id){
        return roomService.getLectureByRoomId(id);
    }

    @GetMapping("/{id}")
    public LectureGetDto getLectureById(@PathVariable("id") Long id){
        return roomService.getLectureById(id);
    }

    @DeleteMapping("/{id}")
    public List<LectureGetDto> deleteLecture(@PathVariable("id") Long id){
        return roomService.deleteLecture(id);
    }



}
