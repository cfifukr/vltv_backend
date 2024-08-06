package com.example.vltv.repositories;


import com.example.vltv.models.game.MapInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<MapInfo, Long> {
}
