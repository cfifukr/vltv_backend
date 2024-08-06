package com.example.vltv.dtos.request.create;

import com.example.vltv.models.team.Player;
import com.example.vltv.models.team.Statistic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerCreateDto {
    private String username;
    private String name;
    private Integer age;

    public Player getPlayer(){
        Statistic statistic = new Statistic(0,0,0,0,0,0.0, null);

        Player player = new Player();
        player.setUsername(this.username);
        player.setName(this.name);
        player.setAge(this.age);
        statistic.setTeamMember(player);
        player.setStatistic(statistic);
        return player;

    }
}
