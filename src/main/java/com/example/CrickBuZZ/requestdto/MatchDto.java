package com.example.CrickBuZZ.requestdto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchDto {
    String PlaceofVenue;
    String MatchName;
}
