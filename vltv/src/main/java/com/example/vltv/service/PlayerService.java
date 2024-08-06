package com.example.vltv.service;

import com.example.vltv.dtos.request.create.PlayerCreateDto;
import com.example.vltv.dtos.request.update.PlayerUpdateDto;
import com.example.vltv.models.team.Player;
import com.example.vltv.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @Transactional
    public Player createNewPlayer(PlayerCreateDto playerCreateDto){
        return playerRepository.save(playerCreateDto.getPlayer());
    }

    @Transactional
    public Player createOrUpdatePlayer(Player player){
        return playerRepository.save(player);
    }

    @Transactional(readOnly = true)
    public Player getPlayerById(Long id){
        return playerRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletePlayerById(Long id){
        playerRepository.deleteById(id);
    }

    @Transactional
    public Player updatePlayer(PlayerUpdateDto playerUpdateDto){
        return playerRepository.save(playerUpdateDto.getPlayer());
    }

}
