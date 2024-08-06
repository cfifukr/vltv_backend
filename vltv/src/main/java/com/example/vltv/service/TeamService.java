package com.example.vltv.service;

import com.example.vltv.dtos.request.create.TeamCreateDto;
import com.example.vltv.models.team.Team;
import com.example.vltv.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    @Transactional
    public Team createTeam(TeamCreateDto teamCreateDto){
        return teamRepository.save(teamCreateDto.getTeam());
    }

    @Transactional
    public Team getTeamById(Long id){
        return teamRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteTeamById(Long id){
        teamRepository.deleteById(id);
    }

    @Transactional
    public Team updateTeam(Team team){
        return teamRepository.save(team);
    }

    @Transactional
    public Team saveTeam(Team team){
        return teamRepository.save(team);
    }


}
