package com.example.vltv.dtos.request.create;

import com.example.vltv.models.game.PlayerMapStat;
import com.example.vltv.models.team.Player;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapStatCreateDto {
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Double headshots;
    private Double adr;
    private Long playerId;

    public PlayerMapStat getPlayerMapStat(Player player){
        PlayerMapStat result = PlayerMapStat.builder()
                .kills(this.kills)
                .deaths(this.deaths)
                .assists(this.assists)
                .headshots(this.headshots)
                .adr(this.adr)
                .player(player)
                .build();
        return result;
    }

}
