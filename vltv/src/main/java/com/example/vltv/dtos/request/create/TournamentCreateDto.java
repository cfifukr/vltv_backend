package com.example.vltv.dtos.request.create;

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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TournamentCreateDto {

    private LocalDateTime timeStarted;
    private String name;
    private String placesJson;
    private Double prizePoolUsd;
    private String country;
    private Boolean isFinished;
    private Long winnerId;
    private String tier;

    public Tournament getTournament(Team winner){
        return  Tournament.builder()
                .name(this.name)
                .country(this.country)
                .isFinished(this.isFinished)
                .prizePoolUsd(this.prizePoolUsd)
                .placesJson(this.placesJson)
                .dateStart(this.timeStarted)
                .winner(winner)
                .tier(Tier.valueOf(this.tier.toUpperCase().trim()))
                .build();
    }


}
