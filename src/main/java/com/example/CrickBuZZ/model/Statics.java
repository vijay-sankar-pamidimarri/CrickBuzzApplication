package com.example.CrickBuZZ.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Statics {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToOne(mappedBy = "statics")
    Player player;
}
