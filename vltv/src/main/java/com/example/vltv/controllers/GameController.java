package com.example.vltv.controllers;

import com.example.vltv.dtos.request.create.GameCreateDto;

import com.example.vltv.dtos.response.GameResponseDto;

import com.example.vltv.models.game.GameInfo;
import com.example.vltv.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/game")
@CrossOrigin
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;

    }

    @GetMapping
    public ResponseEntity<?> getGameById(@RequestParam("id") Long id){


        return ResponseEntity.ok(GameResponseDto.getDto(gameService.getGameById(id)));
    }

    @GetMapping("/live")
    public ResponseEntity<?> getLiveGames(){

        List<GameInfo> games = gameService.getLiveGames();

        return ResponseEntity.ok(games
                                    .stream()
                                    .map(GameResponseDto::getDto)
                                    .toList());
    }


    @PostMapping
    public ResponseEntity<?> createGame(@RequestBody GameCreateDto dto){


        return ResponseEntity.ok(GameResponseDto.getDto(gameService.createGame(dto)));
    }




    //test
   /* @GetMapping
    public GameResponseDto getGameById(@RequestParam(value = "id") Long id){
        Team team1 = new Team();
        team1.setName("Navi");
        Team team2 = new Team();
        team2.setName("Faze");
        Player player = new Player();
        player.setTeam(team1);
        player.setAge(20);
        player.setUsername("s1mple");


        team1 = teamService.saveTeam(team1);
        team2 = teamService.saveTeam(team2);

        Player playerSaved = playerService.createOrUpdatePlayer(player);



        MapInfo map1 = MapInfo.builder()
                .mapType(MapType.ASCENT)
                .teamTwoRounds(13)
                .teamOneRounds(9)
                .isFinished(true)
                .teamOneStat(new ArrayList<>())
                .teamTwoStat(new ArrayList<>())
                .build();

        MapInfo map2 = MapInfo.builder()
                .mapType(MapType.BIND)
                .teamTwoRounds(13)
                .teamOneRounds(4)
                .isFinished(true)
                .teamOneStat(new ArrayList<>())
                .teamTwoStat(new ArrayList<>())
                .build();

        MapInfo map3 = MapInfo.builder()
                .mapType(MapType.BIND)
                .teamTwoRounds(13)
                .teamOneRounds(11)
                .isFinished(true)
                .teamOneStat(new ArrayList<>())
                .teamTwoStat(new ArrayList<>())
                .build();
        List<MapInfo> list = new ArrayList() {{
            add(mapService.saveMap(map1));
            add(mapService.saveMap(map2));
            add(mapService.saveMap(map3));
        }};



        GameInfo game = new GameInfo();
        game.setGameFormat(GameFormat.BO3);
        game.setGameStage(GameStage.GROUP_STAGE);
        game.setTeamOne(team1);
        game.setTeamTwo(team2);
        game.setTeamOneMaps(2);
        game.setTeamTwoMaps(1);
        game.setDateTimeStart(LocalDateTime.now());
        game.setIsFinished(true);
        game.setMaps(list);



        return GameResponseDto.getDto(gameService.saveGame(game));

    }
*/
}
