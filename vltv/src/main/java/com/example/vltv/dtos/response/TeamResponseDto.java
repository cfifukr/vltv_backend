package com.example.vltv.dtos.response;

import com.example.vltv.models.team.Team;
import lombok.Builder;

import java.util.Set;
import java.util.stream.Collectors;

@Builder
public class TeamResponseDto {
    private Long id;
    private String name;
    private Set<TeamMemberResponseDto> players;
    private Set<TeamMemberResponseDto> coaches;

    public static TeamResponseDto getDto(Team team){
       TeamResponseDto dto = TeamResponseDto.builder()
               .id(team.getId())
               .name(team.getName())
               .players(team.getPlayers()
                       .stream()
                       .map((i) -> TeamMemberResponseDto.getResonseDto(i)).collect(Collectors.toSet()))
               .coaches(team.getCoach()
                       .stream()
                       .map((i) -> TeamMemberResponseDto.getResonseDto(i)).collect(Collectors.toSet()))
               .build();
       return dto;

    }

}
