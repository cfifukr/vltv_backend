package com.example.vltv.repositories;

import com.example.vltv.models.game.GameInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<GameInfo, Long> {

    @Query("SELECT x FROM GameInfo x WHERE x.isStarted = true AND x.isFinished = false")
    List<GameInfo> getLiveGames();
}
