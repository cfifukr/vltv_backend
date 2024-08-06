package com.example.vltv.controllers;


import com.example.vltv.dtos.request.create.CoachCreateDto;
import com.example.vltv.dtos.request.update.CoachUpdateDto;
import com.example.vltv.dtos.response.TeamMemberResponseDto;
import com.example.vltv.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/coach")
@CrossOrigin
public class CoachController {
    private CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService){
        this.coachService = coachService;
    }

    @GetMapping
    public ResponseEntity<?> getCoach(@Param("id") Long id){
        return ResponseEntity.ok(TeamMemberResponseDto.getResonseDto(coachService.getCoachById(id)));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCoach(@Param("id") Long id){
        coachService.deleteCoachById(id);
        return ResponseEntity.ok("Coach deleted successfully");
    }

    @PostMapping
    public ResponseEntity<?> createCoach(@RequestBody CoachCreateDto dto){
        return ResponseEntity.ok(TeamMemberResponseDto.getResonseDto(coachService.createNewCoach(dto)));
    }

    @PutMapping
    public ResponseEntity<?> updateCoach(@RequestBody CoachUpdateDto dto){
        return ResponseEntity.ok(TeamMemberResponseDto.getResonseDto(coachService.updateCoach(dto)));
    }

}
