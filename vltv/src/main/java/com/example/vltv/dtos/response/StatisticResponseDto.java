package com.example.vltv.dtos.response;


import com.example.vltv.models.team.Statistic;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StatisticResponseDto {
    private Long id;
    private Integer wins;
    private Integer loses;
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Double headshots;

    public static StatisticResponseDto getDto(Statistic statistic){
        return StatisticResponseDto.builder()
                .id(statistic.getId())
                .wins(statistic.getWins())
                .loses(statistic.getLoses())
                .kills(statistic.getKills())
                .deaths(statistic.getDeaths())
                .assists(statistic.getAssists())
                .headshots(statistic.getHeadshots())
                .build();

    }

}
