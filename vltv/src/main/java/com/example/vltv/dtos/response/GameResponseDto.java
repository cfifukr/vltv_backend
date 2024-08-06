package com.example.vltv.dtos.response;



import com.example.vltv.models.game.GameInfo;

import com.example.vltv.models.game.Tournament;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GameResponseDto {


    private Long game_id;

    private String gameFormat;

    private String gameStage;


    private String teamOne;
    private String teamTwo;

    private List<MapInfoResponseDto> maps = new ArrayList<>();

    private Integer teamOneMapsWon;
    private Integer teamTwoMapsWon;

    private String tournamentName;
    private Long tournamentId;

    private LocalDateTime dateTimeStart;
    private Boolean isFinished;
    private Boolean isStarted;


    public static GameResponseDto getDto(GameInfo game){
        return  GameResponseDto.builder()
                .game_id(game.getGame_id())
                .gameFormat(game.getGameFormat().getShortName())
                .gameStage(game.getGameStage().getStage())
                .teamOne(game.getTeamOne().getName())
                .teamTwo(game.getTeamTwo().getName())
                .maps(game.getMaps().stream()
                        .map(i -> MapInfoResponseDto.getDto(i)).toList())
                .teamOneMapsWon(game.getTeamOneMaps())
                .teamTwoMapsWon(game.getTeamTwoMaps())
                .dateTimeStart(game.getDateTimeStart())
                .isFinished(game.getIsFinished())
                .isStarted(game.getIsStarted())
                .tournamentName(game.getTournament().getName())
                .tournamentId(game.getTournament().getTournamentId())
                .build();

    }


}
