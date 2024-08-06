package com.example.vltv.dtos.response;

import com.example.vltv.models.game.PlayerMapStat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class MapStatResponseDto {
    private Long matchStatId;

    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Double headshots;
    private Double adr;

    public static MapStatResponseDto getDto (PlayerMapStat mapStat){

        MapStatResponseDto result = MapStatResponseDto.builder()
                .matchStatId(mapStat.getMatchStatId())
                .kills(mapStat.getKills())
                .deaths(mapStat.getDeaths())
                .assists(mapStat.getAssists())
                .headshots(mapStat.getHeadshots())
                .adr(mapStat.getAdr())
                .build();
        return result;
    }


}
