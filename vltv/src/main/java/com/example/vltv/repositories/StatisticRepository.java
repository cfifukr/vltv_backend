package com.example.vltv.repositories;

import com.example.vltv.models.team.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
