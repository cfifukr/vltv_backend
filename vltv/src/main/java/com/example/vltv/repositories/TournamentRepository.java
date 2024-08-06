package com.example.vltv.repositories;

import com.example.vltv.models.game.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    @Query(value = "SELECT * FROM Tournament t WHERE t.is_finished = false ORDER BY t.date_start LIMIT :amount", nativeQuery = true)
    List<Tournament> getTournaments(@Param("amount") Integer amount);
}
