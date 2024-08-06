package com.example.vltv.controllers;


import com.example.vltv.dtos.request.create.TeamCreateDto;
import com.example.vltv.dtos.response.TeamResponseDto;
import com.example.vltv.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/team")
@CrossOrigin
public class TeamController {
    private  final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<?> getTeamById(@Param("team_id") Long id){
        return ResponseEntity.ok(TeamResponseDto.getDto(teamService.getTeamById(id)));
    }

    @PostMapping
    public ResponseEntity<?> createTeam(@RequestBody TeamCreateDto dto){
        return ResponseEntity.ok(TeamResponseDto.getDto(teamService.createTeam(dto)));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTeamById(@Param("team_id") Long id){
        teamService.deleteTeamById(id);
        return ResponseEntity.ok("Team successfully deleted");
    }

    //no need for now
    /*@PutMapping
    public ResponseEntity<?> deleteTeamById(@RequestBody TeamUpdateDto dto){
        return ResponseEntity.ok(TeamResponseDto.getDto(teamService.updateTeam(dto)));
    }*/

}
