package com.glowthon.soleil.domain.schedule.service;


import com.glowthon.soleil.domain.building.entity.BuildingEntity;
import com.glowthon.soleil.domain.lecture.entity.LectureEntity;
import com.glowthon.soleil.domain.lecture.repository.LectureRepository;
import com.glowthon.soleil.domain.schedule.dto.ScheduleGetDto;
import com.glowthon.soleil.domain.schedule.dto.SchedulePostDto;
import com.glowthon.soleil.domain.schedule.entity.ScheduleEntity;
import com.glowthon.soleil.domain.schedule.entity.WeekDay;
import com.glowthon.soleil.domain.schedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ScheduleService {

    @Autowired
    public ScheduleRepository scheduleRepository;

    @Autowired
    public LectureRepository lectureRepository;

    @Transactional
    public ScheduleGetDto addSchedule(SchedulePostDto newSchedule){
        LectureEntity lecture = lectureRepository.findById(newSchedule.getLectureId())
                .orElseThrow(() -> new RuntimeException("Building not found"));

        ScheduleEntity schedule = scheduleRepository.save(ScheduleEntity.builder()
                .lecture(lecture)
                .day(newSchedule.getDay())
                .time(newSchedule.getTime())
                .build());

        return ScheduleGetDto.builder()
                .id(schedule.getId())
                .lecture(schedule.getLecture())
                .day(schedule.getDay())
                .time(schedule.getTime())
                .build();

    }

    public List<ScheduleGetDto> getAllSchedule(){
        return scheduleRepository.findAll().stream()
                .map(schedule -> ScheduleGetDto.builder()
                        .id(schedule.getId())
                        .lecture(schedule.getLecture())
                        .day(schedule.getDay())
                        .time(schedule.getTime())
                        .build()
                ).collect(Collectors.toList());
    }
    public ScheduleGetDto getScheduleById(Long id) {
        try {
            ScheduleEntity schedule = scheduleRepository.findById(id).get();
            return ScheduleGetDto.builder()
                    .id(schedule.getId())
                    .lecture(schedule.getLecture())
                    .day(schedule.getDay())
                    .time(schedule.getTime())
                    .build();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Transactional
    public List<ScheduleGetDto> deleteSchedule(Long id){
        try{
            scheduleRepository.deleteById(id);
            return getAllSchedule();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    public List<ScheduleGetDto> getScheduleByLectureId(Long id) {
        return scheduleRepository.findByLecture_Id(id).stream()
                .map(schedule -> ScheduleGetDto.builder()
                        .lecture(schedule.getLecture())
                        .day(schedule.getDay())
                        .time(schedule.getTime())
                        .build()
                ).collect(Collectors.toList());
    }

    public Map<WeekDay, List<Integer>> getScheduleByRoomId(Long id){
        List<ScheduleEntity> schedules = scheduleRepository.findByLecture_Room_Id(id);
        return schedules.stream()
                .collect(Collectors.groupingBy(ScheduleEntity::getDay,
                        Collectors.mapping(ScheduleEntity::getTime, Collectors.toList())));
    }
}


