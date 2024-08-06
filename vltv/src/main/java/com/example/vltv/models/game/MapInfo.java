package com.example.vltv.models.game;


import com.example.vltv.models.enums.MapType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MapInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mapId;

    @Enumerated(EnumType.STRING)
    private MapType mapType;



    private Integer teamOneRounds;
    private Integer teamTwoRounds;


    @OneToMany
    @Builder.Default
    private List<PlayerMapStat> teamOneStat = new ArrayList<>();

    @OneToMany
    @Builder.Default
    private List<PlayerMapStat> teamTwoStat = new ArrayList<>();

    private Boolean isFinished;





}
