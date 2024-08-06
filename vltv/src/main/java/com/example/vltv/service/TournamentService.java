package com.example.vltv.service;

import com.example.vltv.dtos.request.create.TeamCreateDto;
import com.example.vltv.dtos.request.create.TournamentCreateDto;
import com.example.vltv.models.game.Tournament;
import com.example.vltv.models.team.Team;
import com.example.vltv.repositories.TeamRepository;
import com.example.vltv.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository,
                             TeamRepository teamRepository){
        this.tournamentRepository = tournamentRepository;
        this.teamRepository = teamRepository;
    }


    public Tournament save(Tournament tournament){
        return tournamentRepository.save(tournament);
    }


    public Tournament create(TournamentCreateDto tournamentCreateDto){
        if(tournamentCreateDto.getIsFinished()){
            Team winner = teamRepository.findById(tournamentCreateDto.getWinnerId())
                    .orElseThrow(() -> new IllegalArgumentException("No team with such id (Tournament_Service)"));
            return tournamentRepository.save(tournamentCreateDto.getTournament(winner));

        }
        return tournamentRepository.save(tournamentCreateDto.getTournament(null));



    }
    public Tournament finishTournament(Long id){
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No tournament with such id (Tournament_Service)"));
        tournament.setIsFinished(true);

        return tournamentRepository.save(tournament);
    }

    public Tournament getTournament(Long id){
        return  tournamentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No tournament with such id (Tournament_Service)"));


    }

    public List<Tournament> getTournaments(Integer amount){
        return  tournamentRepository.getTournaments(amount);

    }
}
