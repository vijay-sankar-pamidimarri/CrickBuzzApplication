package com.example.CrickBuZZ.requestdto;

import com.example.CrickBuZZ.Eenums.GenderEnum;
import com.example.CrickBuZZ.Eenums.PlayerGame;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerDto {
    int id;
    String name;
    int age;
    String Country;
    GenderEnum gender;
    PlayerGame playerGame;
    String GoodName;
    String Email;
    int Weight;
}

