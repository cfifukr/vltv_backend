package com.example.vltv.models.game;

import com.example.vltv.models.enums.Tier;
import com.example.vltv.models.team.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tournamentId;

    private LocalDateTime dateStart;

    private String name;

    //Many to Many participants

    private String placesJson;

    private Double prizePoolUsd;

    private String country;

    private Boolean isFinished;

    @Enumerated(value = EnumType.ORDINAL)
    private Tier tier;

    @ManyToOne
    private Team winner;



}
