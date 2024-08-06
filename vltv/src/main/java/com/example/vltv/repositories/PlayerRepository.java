package com.example.vltv.repositories;

import com.example.vltv.models.team.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
