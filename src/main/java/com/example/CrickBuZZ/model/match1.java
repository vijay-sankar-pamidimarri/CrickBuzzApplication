package com.example.CrickBuZZ.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
@FieldDefaults(level = AccessLevel.PRIVATE)
public class match1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @CreationTimestamp
    Date StartDate;
    @UpdateTimestamp
    Date EndDate;
    String PlaceofVenue;
    String MatchName;
    @JsonIgnore
    @ManyToMany(mappedBy = "matches")
    List<Team> team;
}
