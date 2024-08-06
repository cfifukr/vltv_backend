package com.example.vltv.models.team;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "TYPE")
@Data
public abstract class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamMemberId;

    @Column(nullable = false)
    private String username;

    private String name;

    private Integer age;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Statistic statistic;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Team team;

    public Long getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(Long teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}