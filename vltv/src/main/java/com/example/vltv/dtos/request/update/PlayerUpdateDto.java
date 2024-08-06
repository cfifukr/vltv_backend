package com.example.vltv.dtos.request.update;

import com.example.vltv.models.team.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerUpdateDto {
    private Long playerId;
    private String username;
    private String name;
    private Integer age;



    public Player getPlayer(){
        Player player = new Player();
        player.setTeamMemberId(playerId);
        player.setUsername(this.username);
        player.setName(this.name);
        player.setAge(age);

        return player;
    }
}
