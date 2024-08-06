package com.example.vltv.models.team;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Coach> coach = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Player> players = new HashSet<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Coach> getCoach() {
        return coach;
    }

    public void setCoach(Set<Coach> coach) {
        if (coach.size() > 2) {
            throw new IllegalArgumentException("Maximum number of coaches is 2.");
        }
        this.coach = coach;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        if (players.size() > 5) {
            throw new IllegalArgumentException("Maximum number of players is 5.");
        }
        this.players = players;
    }

    // Methods to add a coach or a player
    public void addCoach(Coach coach) {
        if (this.coach.size() >= 2) {
            throw new IllegalArgumentException("Maximum number of coaches is 2.");
        }
        this.coach.add(coach);
        coach.setTeam(this);
    }

    public void addPlayer(Player player) {
        if (this.players.size() >= 5) {
            throw new IllegalArgumentException("Maximum number of players is 5.");
        }
        this.players.add(player);
        player.setTeam(this);
    }
}
