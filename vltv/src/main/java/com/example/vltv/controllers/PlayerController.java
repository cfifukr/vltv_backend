package com.example.vltv.controllers;


import com.example.vltv.dtos.request.create.PlayerCreateDto;
import com.example.vltv.dtos.request.update.PlayerUpdateDto;
import com.example.vltv.dtos.response.TeamMemberResponseDto;
import com.example.vltv.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/player")
@CrossOrigin
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }



    @GetMapping
    public ResponseEntity<?> getPlayer(@Param("id") Long id){
        return ResponseEntity.ok(TeamMemberResponseDto.getResonseDto(playerService.getPlayerById(id)));
    }

    @DeleteMapping
    public ResponseEntity<?> deletePlayer(@Param("id") Long id){
        playerService.deletePlayerById(id);
        return ResponseEntity.ok("Player deleted successfully");
    }

    @PostMapping
    public ResponseEntity<?> createPlayer(@RequestBody PlayerCreateDto dto){
        return ResponseEntity.ok(TeamMemberResponseDto.getResonseDto(playerService.createNewPlayer(dto)));
    }

    @PutMapping
    public ResponseEntity<?> updatePlayer(@RequestBody PlayerUpdateDto dto){
        return ResponseEntity.ok(TeamMemberResponseDto.getResonseDto(playerService.updatePlayer(dto)));
    }

}
