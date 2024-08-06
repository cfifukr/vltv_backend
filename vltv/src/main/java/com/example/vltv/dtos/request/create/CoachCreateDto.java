package com.example.vltv.dtos.request.create;

import com.example.vltv.models.team.Coach;
import com.example.vltv.models.team.Player;
import com.example.vltv.models.team.Statistic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoachCreateDto {
    private String username;
    private String name;
    private Integer age;

    public Coach getCoach(){
        Statistic statistic = new Statistic(0,0,null,null,null,null, null);

        Coach coach = new Coach();
        coach.setUsername(this.username);
        coach.setName(this.name);
        coach.setAge(this.age);
        statistic.setTeamMember(coach);
        coach.setStatistic(statistic);
        return coach;

    }
}