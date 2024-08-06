package com.example.vltv.dtos.request.update;

import com.example.vltv.models.team.Coach;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoachUpdateDto {
    private Long coachId;
    private String username;
    private String name;
    private Integer age;



    public Coach getCoach(){
        Coach coach = new Coach();
        coach.setTeamMemberId(coachId);
        coach.setUsername(this.username);
        coach.setName(this.name);
        coach.setAge(age);

        return coach;
    }
}
