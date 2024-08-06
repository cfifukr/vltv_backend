package com.example.vltv.service;

import com.example.vltv.dtos.request.create.GameCreateDto;
import com.example.vltv.models.game.GameInfo;
import com.example.vltv.repositories.GameRepository;
import com.example.vltv.repositories.TeamRepository;
import com.example.vltv.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    private final TeamRepository teamRepository;
    private final TournamentRepository tournamentRepository;

    @Autowired
    public GameService(GameRepository gameRepository,
                       TeamRepository teamRepository,
                       TournamentRepository tournamentRepository){
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
        this.tournamentRepository = tournamentRepository;
    }

    public GameInfo getGameById(Long id){

        return gameRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("There isn`t any game with such  id  (Game Service)")
        );
    }
    public GameInfo createGame(GameCreateDto gameCreateDto){
        GameInfo game = gameCreateDto.getGameInfo(
                //get Team one by id
                teamRepository
                        .findById(gameCreateDto.getTeamOneId())
                        .orElseThrow(() ->
                                new IllegalArgumentException("There isn`t any team with such  id (Game Service)")),
                //get Team two by id
                teamRepository
                        .findById(gameCreateDto.getTeamTwoId())
                        .orElseThrow(() ->
                                new IllegalArgumentException("There isn`t any team with such id  (Game Service)")),
                tournamentRepository.findById(gameCreateDto.getTournamentId())
                        .orElseThrow(
                                () -> new IllegalArgumentException("There isn`t any tournament with such id (Game Service)")
                        ));

        return gameRepository.save(game);


    }
    public  GameInfo saveGame(GameInfo game){
        return gameRepository.save(game);
    }


    public List<GameInfo> getLiveGames(){
        return gameRepository.getLiveGames();
    }
}
