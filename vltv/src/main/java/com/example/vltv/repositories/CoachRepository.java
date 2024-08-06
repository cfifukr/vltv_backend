package com.example.vltv.repositories;

import com.example.vltv.models.team.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}
