package com.glowthon.soleil.domain.schedule.controller;

import com.glowthon.soleil.domain.schedule.dto.ScheduleGetDto;
import com.glowthon.soleil.domain.schedule.dto.SchedulePostDto;
import com.glowthon.soleil.domain.schedule.entity.WeekDay;
import com.glowthon.soleil.domain.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/schedules")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("")
    public ScheduleGetDto newSchedule(@RequestBody SchedulePostDto newLecture){
        return scheduleService.addSchedule(newLecture);
    }

    @GetMapping("")
    public List<ScheduleGetDto> getAllSchedules(){
        return scheduleService.getAllSchedule();
    }
    @GetMapping("/lecture/{id}")
    public List<ScheduleGetDto> getSchedulesByLectureId(@PathVariable("id") Long id){
        return scheduleService.getScheduleByLectureId(id);
    }

    @GetMapping("/room/{id}")
    public Map<WeekDay, List<Integer>> getSheduleByRoomId(@PathVariable("id") Long id){
        return scheduleService.getScheduleByRoomId(id);
    }
    @GetMapping("/{id}")
    public ScheduleGetDto getScheduleById(@PathVariable("id") Long id){
        return scheduleService.getScheduleById(id);
    }

    @DeleteMapping("/{id}")
    public List<ScheduleGetDto> deleteSchedule(@PathVariable("id") Long id){
        return scheduleService.deleteSchedule(id);
    }




}
