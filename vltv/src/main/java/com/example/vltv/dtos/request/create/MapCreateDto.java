package com.example.vltv.dtos.request.create;

import com.example.vltv.models.enums.MapType;
import com.example.vltv.models.game.MapInfo;
import com.example.vltv.models.game.PlayerMapStat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MapCreateDto {
    private Long gameId;

    private String mapTypeString;

    private Integer teamOneRounds;
    private Integer teamTwoRounds;

    private List<MapStatCreateDto> teamOneStat = new ArrayList<>();

    private List<MapStatCreateDto> teamTwoStat = new ArrayList<>();

    private Boolean isFinished;


    public MapInfo getMapInfo(List<PlayerMapStat> teamOneStat, List<PlayerMapStat> teamTwoStat){
        MapInfo result = MapInfo.builder()
                .mapType(MapType.valueOf(mapTypeString.trim().toUpperCase()))
                .teamOneRounds(this.teamOneRounds)
                .teamTwoRounds(this.teamTwoRounds)
                .teamOneStat(teamOneStat)
                .teamTwoStat(teamTwoStat)
                .isFinished(isFinished)
                .build();
        return result;

    }

}
