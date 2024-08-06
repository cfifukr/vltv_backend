package com.example.vltv.service;

import com.example.vltv.dtos.request.create.MapCreateDto;
import com.example.vltv.models.game.GameInfo;
import com.example.vltv.models.game.MapInfo;
import com.example.vltv.models.game.PlayerMapStat;
import com.example.vltv.repositories.GameRepository;
import com.example.vltv.repositories.MapRepository;
import com.example.vltv.repositories.PlayerMapStatRepository;
import com.example.vltv.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MapService {
    private final GameRepository gameRepository;
    private final MapRepository mapRepository;
    private final PlayerRepository playerRepository;
    private  final PlayerMapStatRepository playerMapStatRepository;

    @Autowired
    public MapService(MapRepository mapRepository,
                      PlayerRepository playerRepository,
                      GameRepository gameRepository,
                      PlayerMapStatRepository playerMapStatRepository){
        this.mapRepository = mapRepository;
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
        this.playerMapStatRepository = playerMapStatRepository;
    }

    @Transactional(readOnly = true)
    public MapInfo getMap(Long id){
        return mapRepository.findById(id).orElse(null);
    }

    @Transactional
    public MapInfo createMap(MapCreateDto mapCreateDto){
        GameInfo gameInfo = gameRepository.findById(mapCreateDto.getGameId())
                .orElseThrow(() -> new IllegalArgumentException("There is no game with this id"));
        if(gameInfo.checkAddMap()){
            List<PlayerMapStat> teamOne = mapCreateDto.getTeamOneStat()
                    .stream()
                    .map(dto -> {
                        System.out.println("Processing team one player with ID: " + dto.getPlayerId());
                        return playerMapStatRepository.save(dto.getPlayerMapStat(playerRepository
                                .findById(dto.getPlayerId())
                                .orElseThrow(() -> new IllegalArgumentException("There is no player with this id(createMap-mapService)"))));
                    })
                    .toList();
            List<PlayerMapStat> teamTwo = mapCreateDto.getTeamTwoStat()
                    .stream()
                    .map(dto -> {
                        System.out.println("Processing team two player with ID: " + dto.getPlayerId());
                        return playerMapStatRepository.save(dto.getPlayerMapStat(playerRepository
                                .findById(dto.getPlayerId())
                                .orElseThrow(() -> new IllegalArgumentException("There is no player with this id(createMap-mapService)"))));
                    })
                    .toList();

            MapInfo mapInfo = mapCreateDto.getMapInfo(teamOne, teamTwo);

            System.out.println("Saving map info");
            gameInfo.addMap(mapRepository.save(mapInfo));
            gameRepository.save(gameInfo);
            System.out.println("Saved game");


            return mapInfo;
        }
        throw new RuntimeException("Max maps for game");
    }
}
