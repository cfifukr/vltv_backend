package com.example.vltv.service;

import com.example.vltv.dtos.request.create.CoachCreateDto;
import com.example.vltv.dtos.request.create.PlayerCreateDto;
import com.example.vltv.dtos.request.update.CoachUpdateDto;
import com.example.vltv.dtos.request.update.PlayerUpdateDto;
import com.example.vltv.models.team.Coach;
import com.example.vltv.models.team.Player;
import com.example.vltv.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoachService {
    private final CoachRepository coachRepository;
    
    @Autowired
    public CoachService(CoachRepository coachRepository){
        this.coachRepository = coachRepository;
    }

    @Transactional
    public Coach createNewCoach(CoachCreateDto coachCreateDto){
        return coachRepository.save(coachCreateDto.getCoach());
    }

    @Transactional
    public Coach createNewCoach(Coach coach){
        return coachRepository.save(coach);
    }


    @Transactional(readOnly = true)
    public Coach getCoachById(Long id){
        return coachRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteCoachById(Long id){
        coachRepository.deleteById(id);
    }

    @Transactional
    public Coach updateCoach(CoachUpdateDto coachUpdateDto){
        return coachRepository.save(coachUpdateDto.getCoach());
    }

}
