package com.example.vltv.models.team;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer wins;
    private Integer loses;

    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Double headshots;

    @OneToOne(mappedBy = "statistic")
    private TeamMember teamMember;


    public Statistic(Integer wins, Integer loses, Integer kills, Integer deaths, Integer assists, Double headshots, TeamMember teamMember) {
        this.wins = wins;
        this.loses = loses;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.headshots = headshots;
        this.teamMember = teamMember;
    }



}
