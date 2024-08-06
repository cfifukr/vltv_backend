package com.example.vltv.controllers;


import com.example.vltv.dtos.request.create.TournamentCreateDto;
import com.example.vltv.dtos.response.TournamentResponseDto;
import com.example.vltv.models.game.Tournament;
import com.example.vltv.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tournament")
@CrossOrigin
public class TournamentController {
    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService){
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public ResponseEntity<?> getTournament(@RequestParam("id") Long id){
        Tournament tournament = tournamentService.getTournament(id);
        return ResponseEntity.ok(TournamentResponseDto.getDto(tournament));
    }

    @GetMapping("/upcoming")
    public ResponseEntity<?> getTournaments(@RequestParam("amount") Integer amount){
        List<Tournament> tournament = tournamentService.getTournaments(amount);
        return ResponseEntity.ok(
                tournament.stream().map(TournamentResponseDto::getDto)
                        .toList()
        );
    }

    @PostMapping
    public ResponseEntity<?> saveTournament(@RequestBody TournamentCreateDto tournamentCreateDto){
        Tournament tournament = tournamentService.create(tournamentCreateDto);
        return ResponseEntity.ok(TournamentResponseDto.getDto(tournament));
    }
}
