package com.example.vltv.dtos.response;

import com.example.vltv.models.enums.Tier;
import com.example.vltv.models.game.Tournament;
import com.example.vltv.models.team.Team;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TournamentResponseDto {

    private Long tournamentId;
    private LocalDateTime dateStart;
    private String name;
    private String placesJson;
    private Double prizePoolUsd;
    private String country;
    private Boolean isFinished;
    private String winner;
    private Long winnerId;
    private Tier tier;


    public static TournamentResponseDto getDto(Tournament tournament){
        TournamentResponseDto result = TournamentResponseDto.builder()
                .tournamentId(tournament.getTournamentId())
                .name(tournament.getName())
                .dateStart(tournament.getDateStart())
                .placesJson(tournament.getPlacesJson())
                .prizePoolUsd(tournament.getPrizePoolUsd())
                .country(tournament.getCountry())
                .isFinished(tournament.getIsFinished())
                .tier(tournament.getTier())
                .build();

        if(!tournament.getIsFinished() && tournament.getWinner() != null){
            result.setWinnerId(tournament.getWinner().getId());
            result.setWinner(tournament.getWinner().getName());
        }

        return result;

    }


}
