package com.example.vltv.models.game;

import com.example.vltv.models.enums.GameFormat;
import com.example.vltv.models.enums.GameStage;
import com.example.vltv.models.team.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GameInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long game_id;

    @Enumerated(EnumType.STRING)
    private GameFormat gameFormat;

    @Enumerated(EnumType.STRING)
    private GameStage gameStage;

    @ManyToOne
    private Team teamOne;
    @ManyToOne
    private Team teamTwo;

    @OneToMany
    @Builder.Default
    private List<MapInfo> maps = new ArrayList<>();

    private Integer teamOneMaps;
    private Integer teamTwoMaps;

    private LocalDateTime dateTimeStart;

    @ManyToOne
    private Tournament tournament;

    private Boolean isStarted;

    private Boolean isFinished;


    public void addMap(MapInfo mapInfo){

        if(checkAddMap()){
            maps.add(mapInfo);
        }

    }

    public boolean checkAddMap(){
        if(this.gameFormat.getMaxMaps() <= this.maps.size()){
            return false;
        }
        return true;
    }



}
