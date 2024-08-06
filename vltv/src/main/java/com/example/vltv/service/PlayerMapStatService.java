package com.example.vltv.service;


import com.example.vltv.dtos.request.create.MapStatCreateDto;
import com.example.vltv.models.game.PlayerMapStat;
import com.example.vltv.models.team.Player;
import com.example.vltv.repositories.PlayerMapStatRepository;
import com.example.vltv.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerMapStatService {
    private final PlayerMapStatRepository repository;
    private final PlayerRepository playerRepository;


    @Autowired
    public PlayerMapStatService(PlayerMapStatRepository playerMapStatRepository,
                                PlayerRepository playerRepository){
        this.repository = playerMapStatRepository;
        this.playerRepository = playerRepository;
    }

    @Transactional
    public List<PlayerMapStat> saveStat(MapStatCreateDto... dtos){
        List<PlayerMapStat> res = new ArrayList();
        for(MapStatCreateDto dto : dtos){
            try {
                res.add(save(dto));
            }catch (IllegalArgumentException e){
                System.out.println(e);
                return null;
            }
        }
        return res;
    }

    private PlayerMapStat save(MapStatCreateDto statDto) throws IllegalArgumentException{
        Optional<Player> player = playerRepository.findById(statDto.getPlayerId());
        if(player.isEmpty()){
            throw new IllegalArgumentException("Player id field isn`t valid");
        }

        PlayerMapStat playerMapStat = statDto.getPlayerMapStat(player.get());
        return repository.save(playerMapStat);
    }

    @Transactional
    public PlayerMapStat save(PlayerMapStat stat){
        return repository.save(stat);
    }
}
