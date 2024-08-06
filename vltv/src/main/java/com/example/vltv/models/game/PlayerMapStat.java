package com.example.vltv.models.game;


import com.example.vltv.models.team.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlayerMapStat {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "match_stat_id")
    private Long matchStatId;

    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Double headshots;
    private Double adr;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player_stat_id")
    private Player player;
}
