package com.glowthon.soleil.domain.lecture.service;


import com.glowthon.soleil.domain.lecture.dto.LectureGetDto;
import com.glowthon.soleil.domain.lecture.dto.LecturePostDto;
import com.glowthon.soleil.domain.lecture.entity.LectureEntity;
import com.glowthon.soleil.domain.lecture.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class LectureService {

    @Autowired
    public LectureRepository lectureRepository;

    @Transactional
    public LectureGetDto addLecture(LecturePostDto newLecture){

        LectureEntity lecture = lectureRepository.save(LectureEntity.builder()
                .room(newLecture.getRoom())
                .name(newLecture.getName())
                .professor(newLecture.getProfessor())
                .build());

        return LectureGetDto.builder()
                .id(lecture.getId())
                .room(lecture.getRoom())
                .name(lecture.getName())
                .professor(lecture.getProfessor())
                .build();

    }

    public List<LectureGetDto> getAllLecture(){
        return lectureRepository.findAll().stream()
                .map(lecture -> LectureGetDto.builder()
                        .id(lecture.getId())
                        .room(lecture.getRoom())
                        .name(lecture.getName())
                        .professor(lecture.getProfessor())
                        .build()
                ).collect(Collectors.toList());
    }
    public LectureGetDto getLectureById(Long id) {
        try {
            LectureEntity lecture = lectureRepository.findById(id).get();
            return LectureGetDto.builder()
                    .id(lecture.getId())
                    .room(lecture.getRoom())
                    .name(lecture.getName())
                    .professor(lecture.getProfessor())
                    .build();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Transactional
    public List<LectureGetDto> deleteLecture(Long id){
        try{
            lectureRepository.deleteById(id);
            return getAllLecture();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    public List<LectureGetDto> getLectureByRoomId(Long id) {
        return lectureRepository.findByRoom_Id(id).stream()
                .map(lecture -> LectureGetDto.builder()
                        .id(lecture.getId())
                        .room(lecture.getRoom())
                        .name(lecture.getName())
                        .professor(lecture.getProfessor())
                        .build()
                ).collect(Collectors.toList());
    }
}


