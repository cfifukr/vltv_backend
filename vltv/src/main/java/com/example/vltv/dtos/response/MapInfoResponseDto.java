package com.example.vltv.dtos.response;

import com.example.vltv.models.game.MapInfo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class MapInfoResponseDto {

    private Long map_id;

    private String mapType;

    private Integer teamOneRounds;
    private Integer teamTwoRounds;

    private List<MapStatResponseDto> teamOneStat = new ArrayList<>();
    private List<MapStatResponseDto> teamTwoStat = new ArrayList<>();

    private Boolean isFinished;

    public static MapInfoResponseDto getDto(MapInfo mapInfo) {
        List<MapStatResponseDto> teamOneStats = mapInfo.getTeamOneStat().stream()
                .map(i -> MapStatResponseDto.getDto(i)).toList();

        List<MapStatResponseDto> teamTwoStats = mapInfo.getTeamTwoStat().stream()
                .map(i -> MapStatResponseDto.getDto(i)).toList();

        MapInfoResponseDto result = MapInfoResponseDto.builder()
                .map_id(mapInfo.getMapId())
                .mapType(mapInfo.getMapType().getName())
                .teamOneRounds(mapInfo.getTeamOneRounds())
                .teamTwoRounds(mapInfo.getTeamTwoRounds())
                .teamOneStat(teamOneStats)
                .teamTwoStat(teamTwoStats)
                .isFinished(mapInfo.getIsFinished())
                .build();

        return result;
    }

}
