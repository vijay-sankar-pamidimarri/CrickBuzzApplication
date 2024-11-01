package com.example.CrickBuZZ.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String nameOfTeam;
    String History;
    String Head;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "match_team",  // Name of the join table
        joinColumns = @JoinColumn(name = "match_id"),  // Foreign key to Match entity
        inverseJoinColumns = @JoinColumn(name = "team_id")  // Foreign key to Team entity
    )
    List<match1> matches;
    @JsonIgnore
    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
    List<Player> players;
}
