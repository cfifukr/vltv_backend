package com.example.vltv.dtos.response;



import com.example.vltv.models.team.TeamMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TeamMemberResponseDto {

    private Long teamMemberId;
    private String username;
    private String name;
    private Integer age;
    private String team;


    public static TeamMemberResponseDto getResonseDto(TeamMember teamMember){
        TeamMemberResponseDto playerResponseDto = TeamMemberResponseDto.builder()
                .teamMemberId(teamMember.getTeamMemberId())
                .username(teamMember.getUsername())
                .name(teamMember.getName())
                .age(teamMember.getAge())
                .team((teamMember.getTeam() == null ? " No team" : teamMember.getTeam().getName()))
                .build();
        return playerResponseDto;
    }
}
