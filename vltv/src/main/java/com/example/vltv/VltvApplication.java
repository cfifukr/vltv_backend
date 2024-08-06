package com.example.vltv;

import com.example.vltv.dtos.request.create.CoachCreateDto;
import com.example.vltv.dtos.request.create.PlayerCreateDto;
import com.example.vltv.models.team.Coach;
import com.example.vltv.models.team.Player;
import com.example.vltv.models.team.Team;
import com.example.vltv.service.CoachService;
import com.example.vltv.service.PlayerService;
import com.example.vltv.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VltvApplication implements CommandLineRunner {

    private final TeamService teamService;


    @Autowired
    public VltvApplication(TeamService teamService) {

        this.teamService = teamService;
    }



    public static void main(String[] args) {
        SpringApplication.run(VltvApplication.class, args);
    }

    @Override
    public void run(String... args){

        Team team1 = new Team();
        team1.setName("Faze Clan");
        teamService.saveTeam(team1);


    }
}
