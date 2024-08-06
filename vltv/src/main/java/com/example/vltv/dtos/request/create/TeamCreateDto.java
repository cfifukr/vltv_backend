package com.example.vltv.dtos.request.create;

import com.example.vltv.models.team.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamCreateDto {
    private String name;



    public Team getTeam(){
        Team team = new Team();
        team.setName(name);


        return team;
    }
}
