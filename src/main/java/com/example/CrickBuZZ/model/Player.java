package com.example.CrickBuZZ.model;

import com.example.CrickBuZZ.Eenums.GenderEnum;
import com.example.CrickBuZZ.Eenums.PlayerGame;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@FieldDefaults(level =AccessLevel.PRIVATE)
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    int Age;
    String Contry;
    @Enumerated(EnumType.STRING)
    GenderEnum gender;
    PlayerGame playerGame;
    String GoodName;
    int Weight;
    String Email;
    @ManyToOne
    @JoinColumn
    Team team;
    @OneToOne
    @JsonIgnore
    @JoinColumn
    Statics statics;
    @Override
    public String toString() {
           return "Player{" +
                  "name='" + name + '\'' +
                  ", age=" + Age +
                   ", country='" + Contry + '\'' +
                  ", teamName='" + (team != null ? team.getNameOfTeam() : "N/A") + '\'' + // Avoid calling team.toString()
            '}';
}


}
