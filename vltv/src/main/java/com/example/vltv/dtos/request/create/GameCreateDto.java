package com.example.vltv.dtos.request.create;

import com.example.vltv.models.enums.GameFormat;
import com.example.vltv.models.enums.GameStage;
import com.example.vltv.models.game.GameInfo;
import com.example.vltv.models.game.Tournament;
import com.example.vltv.models.team.Team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameCreateDto {

    private String gameFormat;
    private String gameStage;

    private Long teamOneId;
    private Long teamTwoId;

    private List<MapCreateDto> maps = new ArrayList<>();

    private Integer teamOneMaps;
    private Integer teamTwoMaps;

    private LocalDateTime dateTimeStart;
    private Boolean isFinished;
    private Boolean isStarted;
    private Long tournamentId;

    public GameInfo getGameInfo(Team teamOne, Team teamTwo, Tournament tournament){
        GameInfo result = GameInfo.builder()
                .gameFormat(GameFormat.valueOf(this.gameFormat.trim().toUpperCase()))
                .gameStage(GameStage.valueOf(this.gameStage.trim().toUpperCase()))
                .teamOneMaps(this.teamOneMaps)
                .teamTwoMaps(this.teamTwoMaps)
                .teamOne(teamOne)
                .teamTwo(teamTwo)
                .dateTimeStart(this.getDateTimeStart())
                .isFinished(this.isFinished)
                .isStarted(this.isStarted)
                .tournament(tournament)
                .build();
        return result;
    }


}
